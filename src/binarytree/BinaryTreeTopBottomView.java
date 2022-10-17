package binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class BinaryTreeTopBottomView {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		TreeNode root = null;
		// 1 2 4 -1 -1 5 -1 -1 3 6 -1 -1 7 -1 -1
		//root = buildTree();
		
		// 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
		root = buildTreeLevelwise();
		
		levelOrderTraversal(root);
		
				
		System.out.println("Top View :- ");
		List<Integer> top_1 = topView_M_1(root);
		System.out.println(top_1);
		
		System.out.println("Top View :- ");
		List<Integer> top_2 = topView_M_2(root);
		System.out.println(top_2);
	
		System.out.println("Bottom View :- ");
		List<Integer> bottom_1 = bottomView_M_1(root);
		System.out.println(bottom_1);
		
		System.out.println("Bottom View :- ");
		List<Integer> bottom_2 = bottomView_M_2(root);
		System.out.println(bottom_2);
	}
	
	/***
	 * 
	 * Time Complexity :- O(nlogn)
	 * Space Complexity :- O(n)
	 */
	public static List<Integer> topView_M_1(TreeNode root){
		if(root==null)
			return new ArrayList<>();
		List<NodeVSDist> nodes = new LinkedList<NodeVSDist>();
		Map<Integer, Integer> map = new TreeMap<>();
		nodes.add(new NodeVSDist(root, 0));
		while(!nodes.isEmpty()) {
			NodeVSDist temp = nodes.remove(0);
			if(!map.containsKey(temp.dist))
				map.put(temp.dist, temp.node.data);
			if(temp.node.left!=null)
				nodes.add(new NodeVSDist(temp.node.left, temp.dist-1));
			if(temp.node.right!=null)
				nodes.add(new NodeVSDist(temp.node.right, temp.dist+1));
		}
		return new LinkedList<>(map.values());
	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 */
	public static List<Integer> topView_M_2(TreeNode root){
		ArrayList<Integer> result = new ArrayList<>();
		if(root==null)
			return result;
		List<NodeVSDist> nodes = new LinkedList<NodeVSDist>();
		Map<Integer, Integer> map = new HashMap<>();
		int min =0;
		int max =0;
		nodes.add(new NodeVSDist(root, 0));
		while(!nodes.isEmpty()) {
			NodeVSDist temp = nodes.remove(0);
			if(!map.containsKey(temp.dist))
				map.put(temp.dist, temp.node.data);
			if(temp.node.left!=null) {
				nodes.add(new NodeVSDist(temp.node.left, temp.dist-1));
				min = Math.min(min,temp.dist - 1);
			}
			if(temp.node.right!=null) {
				nodes.add(new NodeVSDist(temp.node.right, temp.dist+1));
				max = Math.max(max,temp.dist + 1);
			}
		}
		for(int i=min;i<=max;i++) {
			result.add(map.get(i));
		}
		return result;
	}
	
	/***
	 * 
	 * Time Complexity :- O(nlogn)
	 * Space Complexity :- O(n)
	 */
	public static List<Integer> bottomView_M_1(TreeNode root){
		if(root==null)
			return new ArrayList<>();
		List<NodeVSDist> nodes = new LinkedList<NodeVSDist>();
		Map<Integer, Integer> map = new TreeMap<>();
		nodes.add(new NodeVSDist(root, 0));
		while(!nodes.isEmpty()) {
			NodeVSDist temp = nodes.remove(0);
			map.put(temp.dist, temp.node.data);
			if(temp.node.left!=null)
				nodes.add(new NodeVSDist(temp.node.left, temp.dist-1));
			if(temp.node.right!=null)
				nodes.add(new NodeVSDist(temp.node.right, temp.dist+1));
		}
		return new LinkedList<>(map.values());
	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 */
	public static List<Integer> bottomView_M_2(TreeNode root){
		ArrayList<Integer> result = new ArrayList<>();
		if(root==null)
			return result;
		List<NodeVSDist> nodes = new LinkedList<NodeVSDist>();
		Map<Integer, Integer> map = new HashMap<>();
		int min =0;
		int max =0;
		nodes.add(new NodeVSDist(root, 0));
		while(!nodes.isEmpty()) {
			NodeVSDist temp = nodes.remove(0);
			map.put(temp.dist, temp.node.data);
			if(temp.node.left!=null) {
				nodes.add(new NodeVSDist(temp.node.left, temp.dist-1));
				min = Math.min(min,temp.dist - 1);
			}
			if(temp.node.right!=null) {
				nodes.add(new NodeVSDist(temp.node.right, temp.dist+1));
				max = Math.max(max,temp.dist + 1);
			}
		}
		for(int i=min;i<=max;i++) {
			result.add(map.get(i));
		}
		return result;
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

class NodeVSDist{
	TreeNode node;
	int dist;
	public NodeVSDist(TreeNode node,int dist) {
		this.node = node;
		this.dist = dist;
	}
}
