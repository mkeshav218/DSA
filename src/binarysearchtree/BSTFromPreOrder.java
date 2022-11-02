package binarysearchtree;

import java.util.LinkedList;

public class BSTFromPreOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preOrder = {10, 5, 1, 7, 40, 50};
		TreeNode root = null;
		for(int i=0;i<preOrder.length;i++) {
			root = construct(root, preOrder[i]);
		}
		System.out.println("Inorder traversal :- ");
		inOrder(root);
		
		System.out.println("\nLevelOrder Traversal :- ");
		levelOrder(root);
		
		index = 0;
		TreeNode root1 = constructTree(preOrder, Integer.MIN_VALUE, Integer.MAX_VALUE);
		
		System.out.println("Inorder traversal :- ");
		inOrder(root1);
		
		System.out.println("\nLevelOrder Traversal :- ");
		levelOrder(root1);
	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * 
	 */
	static int index = 0;
	public static TreeNode constructTree(int[] preOrder,int min,int max) {
		if(index>=preOrder.length)
			return null;
		TreeNode temp = null;
		if(preOrder[index]>min && preOrder[index]<max) {
			int data = preOrder[index++];
			temp = new TreeNode(data);
			temp.left = constructTree(preOrder, min, data);
			temp.right = constructTree(preOrder, data, max);
		}

		return temp;
	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * 
	 */
	public static TreeNode construct(TreeNode root,int data) {
		if(root==null) {
			root = new TreeNode(data);
			return root;
		}
		TreeNode temp = root;
		TreeNode newNode = new TreeNode(data);
		while(true) {
			if(temp.data<data) {
				if(temp.right!=null)
					temp = temp.right;
				else {
					temp.right = newNode;
					break;
				}
			}else {
				if(temp.left!=null)
					temp = temp.left;
				else {
					temp.left = newNode;
					break;
				}
			}			
		}
		return root;
	}
	
	public static void inOrder(TreeNode root) {
		if(root==null)
			return;
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}

	public static void levelOrder(TreeNode root) {
		if(root==null)
			return;
		LinkedList<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		while(!q.isEmpty()) {
			TreeNode temp = q.remove(0);
			if(temp!=null) {
				System.out.print(temp.data+" ");
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}else {
				System.out.println();
				if(!q.isEmpty()) {
					q.add(null);
				}
			}
		}
	}
}
