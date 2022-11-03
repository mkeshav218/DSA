package binarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/***
 * 
 * Given a BST (Binary Search Tree) that may be unbalanced, convert it into a balanced BST 
 * that has minimum possible height. 
 * 
 */
public class NormalBSTtoBalancedBST {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		TreeNode root = null;
		// 1 2 4 -1 -1 5 -1 -1 3 6 -1 -1 7 -1 -1
		root = insertIntoBST(root,1);
		root = insertIntoBST(root,2);
		root = insertIntoBST(root,3);
		root = insertIntoBST(root,4);
		root = insertIntoBST(root,5);
		root = insertIntoBST(root,6);
		root = insertIntoBST(root,7);
		
		levelOrderTraversal(root);

		list = new ArrayList<>();
		inOrderTraverse(root);
		System.out.println(list);
		root = buildHeightBalanced(list, 0, list.size()-1);
		System.out.println("InOrder Traversal :- ");
		inOrder(root);
		System.out.println();
		
		levelOrderTraversal(root);


	}
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 * 
	 */
	public static TreeNode buildHeightBalanced(ArrayList<Integer> list,int start,int end) {
		if(start>end)
			return null;
		int mid = (start+end)/2;
		TreeNode root = new TreeNode(list.get(mid));
		root.left = buildHeightBalanced(list, start, mid-1);
		root.right = buildHeightBalanced(list, mid+1, end);
		return root;
	}
	
	static ArrayList<Integer> list;
	public static void inOrderTraverse(TreeNode root) {
		if(root==null)
			return;
		inOrderTraverse(root.left);
		list.add(root.data);
		inOrderTraverse(root.right);
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
