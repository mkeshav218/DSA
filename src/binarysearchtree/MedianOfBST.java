package binarysearchtree;

import java.util.LinkedList;
import java.util.Scanner;
/***
 * 
 * Given a Binary Search Tree of size N, find the Median of its Node values.
 * If number of nodes are even: then median = ((n/2th node + ((n)/2th+1) node) /2 
 * If number of nodes are odd: then median = (n+1)/2th node.
 *
 * Count the number of nodes in the given BST using Morris Inorder Traversal.
 * Then perform Morris Inorder traversal one more time by counting nodes and by checking if the count is equal to the median point.
 * To consider even no. of nodes, an extra pointer pointing to the previous node is used.
 */
public class MedianOfBST {
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
		
		System.out.println("Median = " + findMedian(root));
	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(1)
	 * 
	 */
	public static float findMedian(TreeNode root)
    {
        int count = 0;
        TreeNode temp = root;
        while(temp!=null){
        	TreeNode predecessor = temp.left;
            count++;
            if(predecessor!=null){
                while(predecessor.right!=null && predecessor.right!=temp){
                    predecessor = predecessor.right; 
                }
                if(predecessor.right==temp){
                    predecessor.right = null;
                    temp =temp.right;
                    count--;
                }else{
                    predecessor.right = temp;
                    temp =temp.left;
                }
            }else{
                temp =temp.right;
            }
        }
        
        int index = count/2;
        int counter = -1;
        int currentData = 0;
        int prevData = 0;
        temp = root;
        while(temp!=null){
        	TreeNode predecessor = temp.left;
            if(predecessor!=null){
                while(predecessor.right!=null && predecessor.right!=temp){
                    predecessor = predecessor.right; 
                }
                if(predecessor.right==temp){
                    counter++;
                    prevData = currentData;
                    currentData = temp.data;
                    if(counter==index){
                        break;
                    }
                    predecessor.right = null;
                    temp =temp.right;
                }else{
                    predecessor.right = temp;
                    temp =temp.left;
                }
            }else{
                counter++;
                prevData = currentData;
                currentData = temp.data;
                if(counter==index){
                    break;
                }
                temp =temp.right;
            }
        }
        if(count%2==1){
            return currentData;
        }else{
            float num = prevData+currentData; 
            return num/2;
        }
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
