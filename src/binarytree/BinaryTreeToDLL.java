package binarytree;

import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTreeToDLL {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		TreeNode root = null;
		// 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
		root = buildTreeLevelwise();
		
		levelOrderTraversal(root);
		
		TreeNode head = dLL(root, true);
		TreeNode temp = head;
		System.out.println("DLL/Inorder representation :- ");
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp =temp.right;
		}
		
	}
	
	public static TreeNode dLL(TreeNode root,boolean flag)
    {
        if(root==null)
            return root;
        if(root.left==null && root.right==null)
            return root;
        TreeNode leftNode = dLL(root.left,false);
        if(leftNode!=null){
            leftNode.right = root;
            root.left = leftNode;
        }
        TreeNode rightNode = dLL(root.right,true);
        if(rightNode!=null){
            rightNode.left = root;
            root.right = rightNode;
        }
        TreeNode temp = root;
        if(flag){
            while(temp.left!=null)
                temp = temp.left;
        }else{
            while(temp.right!=null)
                temp = temp.right;
        }
        return temp;
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
