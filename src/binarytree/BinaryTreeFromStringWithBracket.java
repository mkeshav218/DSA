package binarytree;

import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTreeFromStringWithBracket {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		TreeNode root = null;

		String s = "4(2(3)(1))(6(5))";//"1(2)(3)";
		System.out.println("Input :-" + s);
		
		root = buildTreeFromString(s);
		
		levelOrderTraversal(root);
		
		reverseLevelOrderTraversal(root);
		
		System.out.println("PreOrder Traversal :- ");
		preOrder(root);
		System.out.println();
		
		System.out.println("PostOrder Traversal :- ");
		postOrder(root);
		System.out.println();

		System.out.println("InOrder Traversal :- ");
		inOrder(root);
		System.out.println();
		
		String stringFromTree = tree2string(root);
		System.out.println(stringFromTree);
	}
	

	public static TreeNode buildTreeFromString(String s) {
		if(s==null)
			return null;
		
		TreeNode root = new TreeNode(s.charAt(0)-'0');
		if(s.length()>1) {
			StringBuffer left = new StringBuffer();
			StringBuffer right = new StringBuffer();
			int l=1,index=2;
			while(l!=0) {
				char ch = s.charAt(index++);
				if(ch=='(')
					l++;
				if(ch==')')
					l--;
				if(l!=0)
					left.append(ch);
			}
			root.left = buildTreeFromString(left.toString());
			if(index!=s.length()) {
				l=1;
				index++;
				while(l!=0) {
					char ch = s.charAt(index++);
					if(ch=='(')
						l++;
					if(ch==')')
						l--;
					if(l!=0)
						right.append(ch);
				}
				root.right = buildTreeFromString(right.toString());
			}
		}
		return root;
	}
	
	public static String tree2string(TreeNode root) {
        StringBuffer res = new StringBuffer();
        tree(root,res);
        return res.toString();
    }

    public static void tree(TreeNode root,StringBuffer sb){
        sb.append(root.data);
        if(root.left!=null){
            sb.append('(');
            tree(root.left,sb);
            sb.append(')');
        }else{
            if(root.right!=null){
                sb.append("()");
            }
        }
        if(root.right!=null){
            sb.append('(');
            tree(root.right,sb);
            sb.append(')');
        }
    }
	
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(height) = O(n){In case of skew tree}
	 * 
	 */
	public static void preOrder(TreeNode root) {
		if(root==null)
			return;
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(height) = O(n){In case of skew tree}
	 * 
	 */
	public static void postOrder(TreeNode root) {
		if(root==null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(height) = O(n){In case of skew tree}
	 * 
	 */
	public static void inOrder(TreeNode root) {
		if(root==null)
			return;
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	
	public static void reverseLevelOrderTraversal(TreeNode root) {
		if(root==null)
			return;
		LinkedList<Integer> list = new LinkedList<>();
		LinkedList<TreeNode> nodes = new LinkedList<>();
		nodes.add(root);
		nodes.add(null);
		while(!nodes.isEmpty()) {
			TreeNode temp = nodes.remove(0);
			if(temp!=null) {
				list.add(0, temp.data);
				if(temp.right!=null)
					nodes.add(temp.right);
				if(temp.left!=null)
					nodes.add(temp.left);
			}else {
				if(!nodes.isEmpty()) {
					list.add(0,-1);
					nodes.add(null);
				}	
			}
		}
		System.out.println("\nReverse Level Order Traversal :- ");
		for(int i:list) {
			if(i==-1)
				System.out.println();
			else
				System.out.print(i+" ");
		}
		System.out.println();
	}
	
	/***
	 * 
	 * Level order traversal can be done by using a queue and traversing nodes by depth.
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 * 
	 */
	public static void levelOrderTraversal(TreeNode root) {
		System.out.println("\nLevel Order Traversal :- ");
		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
		nodes.add(root);
		nodes.add(null);
		while(!nodes.isEmpty()) {
			TreeNode curr = nodes.removeFirst();
			if(curr!=null) {
				System.out.print(curr.data+" ");
				if(curr.left!=null)
					nodes.addLast(curr.left);
				if(curr.right!=null)
					nodes.addLast(curr.right);
			}else {
				System.out.println();
				if(!nodes.isEmpty())
					nodes.add(null);
			}
		}
	}

	public static TreeNode buildTree() {
		System.out.println("Enter the node value :- ");
		int data = scan.nextInt();
		if(data==-1)
			return null;
		TreeNode node = new TreeNode(data);
		System.out.println("Enter data for inserting in left of :- " + data);
		node.left = buildTree();
		System.out.println("Enter data for inserting in right of :- " + data);
		node.right = buildTree();
		return node;
	}
	
	
}
