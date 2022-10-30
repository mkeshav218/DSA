package binarytree;

import java.util.LinkedList;
import java.util.Scanner;

/***
 * 
 * Method - 1
 * Store the path from root to node in a list
 * return kth element from the last of the list
 * 
 * Method - 2
 * Recursively reduce the k by 1 while returning from given node
 * store the result once the value of k becomes 0 
 * 
 * Value of k would be greater than 1
 *
 */
public class KthAncestor {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		TreeNode root = null;
		
		// 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
		root = buildTreeLevelwise();
		
		levelOrderTraversal(root);
		
		
		int node = 5;
		
		//Method - 1 
		for(int k=0;k<=3;k++) {
			TreeNode ancestor = kthAncestor(root, node, k);
			if(ancestor!=null)
				System.out.println(k+"th ancestor of " + node + " :- " + ancestor.data );
			else
				System.out.println(k+"th ancestor of " + node + " :- " + null );
		}
		
		//Method - 2 
		for(int i=0;i<=3;i++) {
			k=i;
			result = null;
			getKthAncestor(root, node);
			if(result!=null) {
				System.out.println(i+"th ancestor of " + node + " :- " + result.data );
			}else {
				System.out.println(i+"th ancestor of " + node + " :- " + result );
			}
		}
		

	
	}
	
	/***
	 * 
	 * Method-1
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 * 
	 */
	public static TreeNode kthAncestor(TreeNode root,int node,int k) {
		list = new LinkedList<TreeNode>();
		traverse(root, node, new LinkedList<TreeNode>());
		if(list.size()<=k) {
			return null;
		}else {
			return list.get(list.size()-k-1);
		}
	}
	public static LinkedList<TreeNode> list;
	public static void traverse(TreeNode root,int n,LinkedList<TreeNode> curr) {
		if(root==null) {
			return;
		}
		if(root.data==n) {
			curr.add(root);
			list = (LinkedList<TreeNode>) curr.clone();
			return;
		}
		curr.add(root);
		traverse(root.left, n, curr);
		traverse(root.right, n, curr);
		curr.remove(curr.size()-1);
	}
	
	/***
	 * 
	 * Method-2
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 * 
	 */
	static int k = 2;
	static TreeNode result = null;
	public static TreeNode getKthAncestor(TreeNode root,int node) {
		if(root==null) {
			return null;
		}
		if(root.data==node) {
			return root;
		}
		TreeNode left = getKthAncestor(root.left, node);
		TreeNode right = getKthAncestor(root.right, node);
		if(left!=null && right==null) {
			k--;
			if(k==0) {
				result = root;
			}
			return left;
		}
		if(left==null && right!=null) {
			k--;
			if(k==0) {
				result = root;
			}
			return right;
		}
		return null;

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
