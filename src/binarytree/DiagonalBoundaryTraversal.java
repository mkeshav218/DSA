package binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DiagonalBoundaryTraversal {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		TreeNode root = null;
		// 1 2 4 -1 -1 5 -1 -1 3 6 -1 -1 7 -1 -1
		//root = buildTree();
		
		//1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 8 9 -1 -1 -1 -1
		// 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
		root = buildTreeLevelwise();
		
		levelOrderTraversal(root);
		
		System.out.println("Diagonal Traversal :- ");
		List<Integer> result = diagonalTraversal(root);
		System.out.println(result);

	}
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 */
	public static List<Integer> diagonalTraversal(TreeNode root){
		List<Integer> result = new ArrayList<>();
		if(root==null)
			return result;
		Map<Integer,ArrayList<Integer>> map = new HashMap<>();
		int level = 0;
		LinkedList<NodeVSDist> queue = new LinkedList<>();
		queue.add(new NodeVSDist(root, 0));
		int maxLevel = 0;
		while(!queue.isEmpty()) {
			NodeVSDist nodeVSDist = queue.remove(0);
			TreeNode temp = nodeVSDist.node;
			int dist = nodeVSDist.dist;
			
			ArrayList<Integer> list = map.get(dist);
			if(list==null) {
				list = new ArrayList<>();
				list.add(temp.data);
				map.put(dist, list);
			}else {
				list.add(temp.data);
				map.put(dist, list);
			}
			
			if(temp.left!=null) {
				queue.add(new NodeVSDist(temp.left, dist+1));
				maxLevel = Math.max(maxLevel, dist+1);
			}
			if(temp.right!=null)
				queue.add(new NodeVSDist(temp.right, dist));
		}
		for(int i=0;i<=maxLevel;i++) {
			result.addAll(map.get(i));
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
