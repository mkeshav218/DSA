package binarytree;

import java.util.LinkedList;
import java.util.Scanner;

public class KsumPathsInBinarytree {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		TreeNode root = null;
		
		// 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
		root = buildTreeLevelwise();
		
		levelOrderTraversal(root);
		
		int target = 5;
		traverseTree(root, new LinkedList<>(), target);
		System.out.println(kSumLists);
	}
	
	
	public static LinkedList<LinkedList<Integer>> kSumLists = new LinkedList<>();
	/***
	 * 
	 * Time Complexity: O(n*h*h)  , as maximum size of path list can be h 
	 * Space Complexity: O(h)
	 *
	 */
	public static void traverseTree(TreeNode root,LinkedList<Integer> list, int target) {
		if(root==null)
			return;
		list.add(root.data);
		int sum = 0;
		LinkedList<Integer> curr = new LinkedList<>();
		for(int i=list.size()-1;i>=0;i--) {
			sum += list.get(i);
			curr.add(0,list.get(i));
			if(sum==target) {
				LinkedList<Integer> temp = (LinkedList<Integer>) curr.clone();
				kSumLists.add(temp);
			}
		}
		traverseTree(root.left, list, target);
		traverseTree(root.right, list, target);
		if(list.size()>0) {
			list.remove(list.size()-1);
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
