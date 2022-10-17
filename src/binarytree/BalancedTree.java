package binarytree;

import java.util.LinkedList;
import java.util.Scanner;

public class BalancedTree {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		TreeNode root = null;
		// 1 2 4 -1 -1 5 -1 -1 3 6 -1 -1 7 -1 -1
		//root = buildTree();
		
		//1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 8 9 -1 -1 -1 -1
		// 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
		root = buildTreeLevelwise();
		
		levelOrderTraversal(root);
		
		System.out.println("Is tree balanced :- "+ isBalanced(root));
		
	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 */
	public static boolean isBalanced(TreeNode root)
    {
	    if(root==null)
	        return true;
	    int[] res = check(root);
	    if(res[1]==1)
	        return true;
	    return false;
    }
    
    public static int[] check(TreeNode root){
        if(root==null)
            return new int[]{0,1};
        int[] left = check(root.left);
        int[] right = check(root.right);
        if(left[1]==1 && right[1]==1 && Math.abs(left[0]-right[0])<=1){
            return new int[]{Math.max(left[0],right[0])+1,1};
        }else{
            return new int[]{0,0};
        }
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
	
	public static TreeNode buildTreeLevelwise() {
		TreeNode root = null;
		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
		System.out.println("Enter the root node :- ");
		int data = scan.nextInt();
		if(data!=-1) {
			root = new TreeNode(data);
			nodes.add(root);
			while(!nodes.isEmpty()) {
				TreeNode curr = nodes.removeFirst();
				System.out.println("Enter the left child of :- " + curr.data);
				data = scan.nextInt();
				if(data!=-1) {
					curr.left = new TreeNode(data);
					nodes.add(curr.left);
				}
				System.out.println("Enter the right child of :- " + curr.data);
				data = scan.nextInt();
				if(data!=-1) {
					curr.right = new TreeNode(data);
					nodes.add(curr.right);
				}
			}
		}
		return root;
	}

}
