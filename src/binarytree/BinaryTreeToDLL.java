package binarytree;

import java.util.LinkedList;
import java.util.Scanner;
/***
 * 
 * Convert a Binary Tree to Doubly-Linked-List.
 * Consider left & right pointer as the prev & next pointer of DLL.
 *
 */
public class BinaryTreeToDLL {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		TreeNode root = null;
		// 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
		root = buildTreeLevelwise();

		levelOrderTraversal(root);

		//		TreeNode head = dLL(root, true);

		TreeNode head = bToDLL(root);

		TreeNode temp = head;
		System.out.println("DLL/Inorder representation :- ");
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp =temp.right;
		}



	}
	/***
	 * 
	 * Method-1 :- 
	 * 	if left of the root exists :
	 * 		Recursively convert the left subtree to DLL.
	 *		Find the inorder predecessor of the root in the left subtree 
	 *  	Make the inorder predecessor as the previous of root and the root as the next of predecessor
	 *  if right of the root exists :
	 * 		Recursively convert the right subtree to DLL.
	 *		Find the inorder successor of the root in the right subtree 
	 *  	Make the inorder successor as the next of root and the root as the prev of successor 
	 */
	public static TreeNode bToDLL(TreeNode root)
	{
		TreeNode head = dll_1(root);
		while(head.left!=null)
			head = head.left;
		return head;
	}
	
	public static TreeNode dll_1(TreeNode root){
		if(root==null)
			return root;
		if(root.left!=null){
			TreeNode inOrderPredecessor = dll_1(root.left);
			for(;inOrderPredecessor.right!=null;)
				inOrderPredecessor = inOrderPredecessor.right;
			inOrderPredecessor.right = root;
			root.left = inOrderPredecessor;
		}
		if(root.right!=null){
			TreeNode inOrdersuccessor = dll_1(root.right);
			for(;inOrdersuccessor.left!=null;)
				inOrdersuccessor = inOrdersuccessor.left;
			inOrdersuccessor.left = root;
			root.right = inOrdersuccessor;
		}
		return root;
	}
	/***
	 * Method-2 :
	 * 
	 * @param flag :- decides which pointer to return
	 * 				if flag==true : return head of the converted-list
	 * 				if flag==false : return tail of the converted-list 
	 * 
	 */
	public static TreeNode dLL(TreeNode root,boolean flag)
	{
		if(root==null)
			return root;
		if(root.left==null && root.right==null)
			return root;
		TreeNode leftNode = dLL(root.left,false);
		if(leftNode!=null){
			leftNode.right = root;
			root.left = leftNode;
		}
		TreeNode rightNode = dLL(root.right,true);
		if(rightNode!=null){
			rightNode.left = root;
			root.right = rightNode;
		}
		TreeNode temp = root;
		if(flag){
			while(temp.left!=null)
				temp = temp.left;
		}else{
			while(temp.right!=null)
				temp = temp.right;
		}
		return temp;
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
