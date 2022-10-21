package binarytree;

import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTree {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		TreeNode root = null;
		// 1 2 4 -1 -1 5 -1 -1 3 6 -1 -1 7 -1 -1
		//root = buildTree();
		
		// 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
		root = buildTreeLevelwise();
		
		levelOrderTraversal(root);
		
		reverseLevelOrderTraversal(root);
		
		System.out.println("PreOrder Traversal :- ");
		preOrder(root);
		System.out.println();
		
		System.out.println("morrish PreOrder Traversal :- ");
		morrishTraversalPreOrder(root);
		System.out.println("\n");
		
		System.out.println("PostOrder Traversal :- ");
		postOrder(root);
		System.out.println();

		System.out.println("InOrder Traversal :- ");
		inOrder(root);
		System.out.println();
		
		System.out.println("morrish InOrder Traversal :- ");
		morrishTraversalInOrder(root);
		System.out.println("\n");
		
		System.out.println("No of Leaf Node :- " + noOfLeafNodes(root));

		System.out.println("Height of tree :- " + height(root));

		System.out.println("Diameter of tree :- " + diameter(root));

		TreeNode mirrNode = mirror(root);
		levelOrderTraversal(mirrNode);
	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- o(1)
	 * 
	 */
	public static void morrishTraversalPreOrder(TreeNode root) {
		if(root==null)
			return;
		TreeNode curr = root;
		while(curr!=null) {
			if(curr.left==null) {
				System.out.print(curr.data+" ");
				curr = curr.right;
			}else {
				TreeNode predecessorNode = predecessor(curr);
				if(predecessorNode.right==curr) {
					predecessorNode.right = null;
					curr = curr.right;
				}else {
					System.out.print(curr.data+" ");
					predecessorNode.right = curr;
					curr = curr.left;
				
			    }
			}
		}
	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- o(1)
	 * 
	 */
	public static void morrishTraversalInOrder(TreeNode root) {
		if(root==null)
			return;
		TreeNode curr = root;
		while(curr!=null) {
			if(curr.left==null) {
				System.out.print(curr.data+" ");
				curr = curr.right;
			}else {
				TreeNode predecessorNode = predecessor(curr);
				if(predecessorNode.right==curr) {
					System.out.print(curr.data+" ");
					predecessorNode.right = null;
					curr = curr.right;
				}else {

					predecessorNode.right = curr;
					curr = curr.left;
				
			    }
			}
		}
	}
	
	public static TreeNode predecessor(TreeNode root) {
		if(root==null || root.left==null)
			return root;
		TreeNode temp = root;
		temp = temp.left;
		while(temp.right!=null && temp.right!=root)
			temp = temp.right;
		return temp;
	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(height) = O(n){In case of skew tree}
	 * 
	 */
	public static TreeNode mirror(TreeNode root) {
		if(root==null)
			return root;
		TreeNode mirrorRoot = new TreeNode(root.data);
		mirrorRoot.left = mirror(root.right);
		mirrorRoot.right = mirror(root.left);
		return mirrorRoot;
	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(height) = O(n){In case of skew tree}
	 * 
	 */
	public static int diameter(TreeNode root) {
		return fastDiameter(root)[1] - 1;
	}
	//@returns an array of size 2, first element is height & second is diameter
	public static int[] fastDiameter(TreeNode root) {
		if(root==null) {
			return new int[] {0,0};
		}
		int[] left = fastDiameter(root.left);
		int[] right = fastDiameter(root.right);
		int h = Math.max(left[0],right[0]) + 1;
		int comboDiameter = left[0] + right[0] + 1;
		int d = Math.max(comboDiameter, Math.max(left[1], right[1]));
		return new int[] {h,d};
	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(height) = O(n){In case of skew tree}
	 * 
	 */
	public static int height(TreeNode root) {
		if(root==null)
			return 0;
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(height) = O(n){In case of skew tree}
	 * 
	 */
	public static int noOfLeafNodes(TreeNode root) {
		if(root==null)
			return 0;
		if(root.left==null && root.right==null)
			return 1;
		int noOfLeftLeaf = noOfLeafNodes(root.left);
		int noOfRightLeaf = noOfLeafNodes(root.right);
		return noOfLeftLeaf+noOfRightLeaf;
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
