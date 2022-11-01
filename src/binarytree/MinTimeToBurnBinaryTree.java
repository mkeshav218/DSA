package binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class MinTimeToBurnBinaryTree {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		TreeNode root = null;
		
		// 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
		root = buildTreeLevelwise();
		
		levelOrderTraversal(root);
		TreeNode leaf = getInitialNode(root, 7);
		System.out.println("Starting node :- " + leaf.data);
		int timeTakenToBurn = timeToBurn(root, leaf);
		System.out.println("Time Taken to burn entire tree :- " + timeTakenToBurn);
		
	}
	
	public static int timeToBurn(TreeNode root,TreeNode leaf) {
		time = 0;
		nodeVsParent = new HashMap<>();
		fetchNodeVsparent(root, null);
		burn(leaf, new LinkedList<>(),0);
		return time;
	}
	
	static int time = 0;
	static HashMap<TreeNode,TreeNode> nodeVsParent;
	public static void burn(TreeNode root,LinkedList<TreeNode> visited,int level) {
		if(root==null) {
			return;
		}
		visited.add(root);
		if(time<level)
			time++;
		if(root.left!=null && !visited.contains(root.left)) {
			burn(root.left, visited,level+1);
		}
		if(root.right!=null && !visited.contains(root.right)) {
			burn(root.right, visited,level+1);
		}
		if(nodeVsParent.get(root)!=null && !visited.contains(nodeVsParent.get(root))) {
			burn(nodeVsParent.get(root), visited,level+1);
		}
	}
	
	public static void fetchNodeVsparent(TreeNode root,TreeNode parent) {
		if(root==null)
			return;
		nodeVsParent.put(root, parent);
		fetchNodeVsparent(root.left, root);
		fetchNodeVsparent(root.right, root);
	}
	
	public static TreeNode getInitialNode(TreeNode root,int data) {
		if(root==null)
			return root;
		if(root.data==data)
			return root;
		TreeNode leftNode = getInitialNode(root.left, data);
		if(leftNode!=null && leftNode.data==data)
			return leftNode;
		return getInitialNode(root.right, data);
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
