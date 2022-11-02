package binarysearchtree;

import java.util.LinkedList;
import java.util.Scanner;
/***
 * 
 * Given a Binary Search Tree (with all values unique) and two node values. 
 * Find the Lowest Common Ancestors of the two nodes in the BST.
 *
 */
public class LCAofBST {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		TreeNode root = null;
		// 1 2 4 -1 -1 5 -1 -1 3 6 -1 -1 7 -1 -1
		root = insertIntoBST(root,4);
		root = insertIntoBST(root,2);
		root = insertIntoBST(root,6);
		root = insertIntoBST(root,1);
		root = insertIntoBST(root,3);
		root = insertIntoBST(root,5);
		root = insertIntoBST(root,7);
		
		levelOrderTraversal(root);
		
		int n1 = 3;
		int n2 = 5;
		
		//Method - 1
		System.out.println("LCA of " + n1 +" & " + n2 + " :- " + LCA(root,n1,n2).data);

		//Method - 2
		System.out.println("LCA of " + n1 +" & " + n2 + " :- " + LCA(root,n1,n2).data);

	}

	//Method - 1
	public static TreeNode LCA(TreeNode root, int n1, int n2)
	{
        if(root==null)
            return null;
        if(root.data==n1 || root.data==n2)
            return root;
        TreeNode left = LCA(root.left,n1,n2);
        TreeNode right = LCA(root.right,n1,n2);
        if(left!=null && right!=null)
            return root;
        else if(left!=null)
            return left;
        else if(right!=null)
            return right;
        else
            return null;
    }
	
	/***
	 * 
	 * Method - 2
	 * Using the properties of BST
	 * 
	 */
	public static TreeNode LCA2(TreeNode root, int n1, int n2)
	{
        if(root==null)
            return null;
        if(root.data>n1 && root.data>n2)
            return LCA(root.left,n1,n2);
        else if(root.data<n1 && root.data<n2)
            return LCA(root.right,n1,n2);
        else
            return root;
    }
	
	public static TreeNode insertIntoBST(TreeNode root,int data) {
		if(root==null) {
			root = new TreeNode(data);
			return root;
		}
		if(root.data>data) {
			root.left = insertIntoBST(root.left, data);
		}else {
			root.right = insertIntoBST(root.right, data);
		}
		return root;
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

}
