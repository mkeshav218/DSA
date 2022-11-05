package binarysearchtree;

import java.util.LinkedList;

public class BSTtoSortedDLL {

	public static void main(String[] args) {
		TreeNode root = null;
		root = insertIntoBST(root,4);
		root = insertIntoBST(root,2);
		root = insertIntoBST(root,6);
		root = insertIntoBST(root,1);
		root = insertIntoBST(root,3);
		root = insertIntoBST(root,5);
		root = insertIntoBST(root,7);

		levelOrderTraversal(root);
		
		DLL d = new DLL();
		bstToDll(root, d);
		TreeNode temp = d.head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.right;
		}
		System.out.println();
		temp = d.tail;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.left;
		}

	}
	
	public static void bstToDll(TreeNode root,DLL d) {
		if(root==null)
			return;
		bstToDll(root.left, d);
		if(d.head==null) {
			d.head = root;
			d.tail = root;
		}else {
			d.tail.right = root;
			root.left = d.tail;
			d.tail =root;
		}
		bstToDll(root.right, d);
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

class DLL{
	TreeNode head;
	TreeNode tail;
}
