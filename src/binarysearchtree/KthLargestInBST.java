package binarysearchtree;

import java.util.LinkedList;
import java.util.Scanner;
class Counter{
    int count;
    int value;
}
public class KthLargestInBST {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		TreeNode root = null;
		// 1 2 4 -1 -1 5 -1 -1 3 6 -1 -1 7 -1 -1
		root = insertIntoBST(root,4);
		root = insertIntoBST(root,2);
		root = insertIntoBST(root,6);
		root = insertIntoBST(root,1);
		root = insertIntoBST(root,3);
		root = insertIntoBST(root,5);
		root = insertIntoBST(root,7);
		
		levelOrderTraversal(root);

		int K = 3;
		Counter c = new Counter();
        traverse(root,c,K);
        System.out.println(K+"th largest element :- " + c.value);
	}
	
	public static void traverse(TreeNode root,Counter c,int K){
        if(root==null || c.count>=K)
            return;
        traverse(root.right,c,K);
        c.count++;
        if(c.count==K){
            c.value = root.data;
        }
        traverse(root.left,c,K);
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
