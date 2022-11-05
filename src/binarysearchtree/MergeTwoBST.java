package binarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;

public class MergeTwoBST {

	public static void main(String[] args) {
		TreeNode root1 = null;
		
		root1 = insertIntoBST(root1,10);
		root1 = insertIntoBST(root1,5);
		root1 = insertIntoBST(root1,20);
		root1 = insertIntoBST(root1,1);
		root1 = insertIntoBST(root1,7);
		root1 = insertIntoBST(root1,15);
		root1 = insertIntoBST(root1,30);
		
		System.out.println("Tree-1 :- ");
		levelOrderTraversal(root1);

		TreeNode root2 = null;
		root2 = insertIntoBST(root2,11);
		root2 = insertIntoBST(root2,6);
		root2 = insertIntoBST(root2,21);
		root2 = insertIntoBST(root2,2);
		root2 = insertIntoBST(root2,8);
		root2 = insertIntoBST(root2,16);
		root2 = insertIntoBST(root2,31);

		System.out.println("\nTree-2 :- ");
		levelOrderTraversal(root2);
		
		/***
		 * 
		 * Method - 1
		 * Insert element of one tree into another one by one
		 * Time Complexity :- O(mlogn)
		 * 
		 */
		
//		insertFromOneTreeToAnother(root1, root2);
//		
//		System.out.println("After inserting elements of one tree into other :- ");
//		levelOrderTraversal(root2);
//		System.out.println();
//		System.out.println("InOrder Traversal of Merged Tree :- ");
//		inorder(root2);
		
		
		/***
		 * Method -2
		 * Step - 1 :- getInorder traversal of both list
		 * Step - 2 :- Merge both list to create a sorted list
		 * Step - 3 :- Create BST from merged list
		 * Time Complexity :- O(m+n)
		 * Space Complexity :- O(m+n)
		 */
//		ArrayList<Integer> list1 = new ArrayList<>();
//		ArrayList<Integer> list2 = new ArrayList<>();
//		inordertraversal(root1, list1);
//		inordertraversal(root2, list2);
//		
//		ArrayList<Integer> mergedList = mergeSortedList(list1, list2);
//		
//		index=0;
//		TreeNode mergedRoot = createBST(mergedList, 0, mergedList.size()-1);
//		levelOrderTraversal(mergedRoot);
//		
//		System.out.println("InOrder Traversal of Merged Tree :- ");
//		inorder(mergedRoot);
		
		TreeNode head = null;
		
		TreeNode temp = flatten(root1, head);;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.right;
		}
	}
	
	/***
	 * Method - 1
	 * Time Complexity :- O(mlogn)
	 * Space Complexity :- O(m)
	 * Insert each element of one tree to other one by one
	 */
	public static void insertFromOneTreeToAnother(TreeNode root1,TreeNode root2) {
		if(root1==null)
			return;
		insertIntoBST(root2, root1.data);
		insertFromOneTreeToAnother(root1.left, root2);
		insertFromOneTreeToAnother(root1.right, root2);
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
	
	// Method - 2
	static int index = 0;
	public static TreeNode createBST(ArrayList<Integer> list,int start,int end) {
		if(start>end)
			return null;
		int mid = (start+end)/2;
		TreeNode root = new TreeNode(list.get(mid));
		index++;
		root.left = createBST(list, start, mid-1);
		root.right = createBST(list,mid+1,end);
		return root;
	}
	public static ArrayList<Integer> mergeSortedList(ArrayList<Integer> list1,ArrayList<Integer> list2){
		ArrayList<Integer> result = new ArrayList<>();
		int i=0,j=0;
		while(i<list1.size() && j<list2.size()) {
			int n1 = list1.get(i);
			int n2 = list2.get(j);
			if(n1<n2) {
				result.add(n1);
				i++;
			}else {
				result.add(n2);
				j++;
			}
		}
		while(i<list1.size()) {
			result.add(list1.get(i++));
		}
		while(j<list2.size()) {
			result.add(list2.get(j++));
		}
		return result;
	}
	
	// Method - 3
	
	public static TreeNode flatten(TreeNode root,TreeNode head) {
		if(root==null)
			return null;
		TreeNode temp = flatten(root.right,head);
		root.right = temp;
		if(temp!=null)
			temp.left = root;
		return temp = root;
		//return flatten(root.left,temp);
		
	}
	
	public static void inordertraversal(TreeNode root,ArrayList<Integer> list) {
		if(root==null)
			return;
		inordertraversal(root.left,list);
		list.add(root.data);
		inordertraversal(root.right, list);
	}

	public static void levelOrderTraversal(TreeNode root) {
		System.out.println("Level Order Traversal :- ");
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
	
	public static void inorder(TreeNode root) {
		if(root==null)
			return;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
}
