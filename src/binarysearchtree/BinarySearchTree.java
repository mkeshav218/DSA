package binarysearchtree;

import java.util.LinkedList;
import java.util.Scanner;

public class BinarySearchTree {
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

		// 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
//		root = buildTreeLevelwise();
		
		levelOrderTraversal(root);
				
		System.out.println("PreOrder Traversal :- ");
		preOrder(root);
		System.out.println();
		
		System.out.println("PostOrder Traversal :- ");
		postOrder(root);
		System.out.println();

		System.out.println("InOrder Traversal :- ");
		inOrder(root);
		System.out.println();
		
		System.out.println("Tree after deleting node 2 :- ");
		root = deleteNode(root, 2);
		levelOrderTraversal(root);
		
		System.out.println("Tree after deleting node 7 :- ");
		root = deleteNode(root, 7);
		levelOrderTraversal(root);

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
	
	public static TreeNode deleteNode(TreeNode root, int key) {
        prevTargetNode = null;
        TreeNode targetNode = getNode(root,key);
        if(targetNode==null)
            return root;
        else{
            if(targetNode.left==null && targetNode.right==null){
                if(root==targetNode)
                    return null;
                if(prevTargetNode.left==targetNode)
                    prevTargetNode.left = null;
                else
                    prevTargetNode.right = null;
            }else if(targetNode.left==null){
                TreeNode s = getSuccessor(targetNode);
                targetNode.data = s.data;
                targetNode.right = deleteNode(targetNode.right,s.data);
            }else if(targetNode.right==null){
                TreeNode s = getPredecessor(targetNode);
                targetNode.data = s.data;
                targetNode.left = deleteNode(targetNode.left,s.data);
            }else{
                TreeNode s = getPredecessor(targetNode);
                targetNode.data = s.data;
                targetNode.left = deleteNode(targetNode.left,s.data);
            }
        }
        return root;
    }
	
	public static TreeNode getSuccessor(TreeNode root){
        TreeNode temp = root;
        if(temp.right!=null){
            temp=temp.right;
        }
        while(temp.left!=null){
            temp = temp.left;
        }
        return temp;
    }

    public static TreeNode getPredecessor(TreeNode root){
        TreeNode temp = root;
        if(temp.left!=null){
            temp=temp.left;
        }
        while(temp.right!=null){
            temp = temp.right;
        }
        return temp;
    }

    static TreeNode prevTargetNode = null;
    public static TreeNode getNode(TreeNode root,int key){
        if(root==null)
            return null;
        TreeNode temp = root;
        while(temp!=null){
            if(temp.data==key)
                return temp;
            else if(temp.data>key){
                prevTargetNode = temp;
                temp = temp.left;
            }else{
                prevTargetNode = temp;
                temp = temp.right; 
            }   
        }
        return null;
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
