package binarysearchtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/***
 * 
 * Given a Binary Tree, convert it to Binary Search Tree in such a way that keeps the original 
 * structure of Binary Tree intact.
 * 
 * Time Complexity : O(NLogN).
 * Space Complexity : O(N).
 * 
 */

public class BinaryTreeToBST {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		TreeNode root = null;
		
		// 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
		root = buildTreeLevelwise();

		root = binaryTreeToBST(root);
		System.out.println("InOrder Traversal :- ");
		inOrder(root);
		System.out.println();
	}
	
	
	public static TreeNode binaryTreeToBST(TreeNode root)
    {
        if(root==null)
            return root;
        index = 0;
        ArrayList<Integer> list = new ArrayList<>();

        traverse(root,list);
        Collections.sort(list);
        constructUtil(root,list);
        return root;
    }
	public static void traverse(TreeNode root,ArrayList<Integer> list){
        if(root==null)
            return;
        traverse(root.left,list);
        list.add(root.data);
        traverse(root.right,list);
    }
    
    static int index = 0;
    public static void constructUtil(TreeNode root,ArrayList<Integer> list){
        if(root==null)
            return;
        constructUtil(root.left,list);
        root.data = list.get(index++);
        constructUtil(root.right,list);
    }
	public static void inOrder(TreeNode root) {
		if(root==null)
			return;
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
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
