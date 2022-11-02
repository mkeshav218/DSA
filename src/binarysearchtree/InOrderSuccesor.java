package binarysearchtree;

import java.util.LinkedList;
import java.util.Scanner;
/***
 * 
 * write a function to populate next pointer for all nodes. 
 * The next pointer for every node should be set to point to inorder successor.
 * 
 * Time Complexity :- O(n)
 * Space Complexity :- O(n)
 *
 */
public class InOrderSuccesor {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		TreeNodeWithNext root = null;
		// 1 2 4 -1 -1 5 -1 -1 3 6 -1 -1 7 -1 -1
		root = insertIntoBST(root,4);
		root = insertIntoBST(root,2);
		root = insertIntoBST(root,6);
		root = insertIntoBST(root,1);
		root = insertIntoBST(root,3);
		root = insertIntoBST(root,5);
		root = insertIntoBST(root,7);
		
		levelOrderTraversal(root);
		populateNext(root);
		printUsingNext(root);

	}
	
	public static void populateNext(TreeNodeWithNext root){
        temp = null;
        modify(root);
    }
    static TreeNodeWithNext temp;
    public static void modify(TreeNodeWithNext root){
        if(root==null)
            return;
        modify(root.right);
        root.next = temp;
        temp = root;
        modify(root.left);
    }
    
    public static void printUsingNext(TreeNodeWithNext root) {
    	TreeNodeWithNext temp = root;
    	while(temp.left!=null) {
    		temp = temp.left;
    	}
    	System.out.println("Printing using next pointer :- ");
    	while(temp!=null) {
    		System.out.print(temp.data+" ");
    		temp = temp.next;
    	}
    }
    

	public static TreeNodeWithNext insertIntoBST(TreeNodeWithNext root,int data) {
		if(root==null) {
			root = new TreeNodeWithNext(data);
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
	public static void levelOrderTraversal(TreeNodeWithNext root) {
		System.out.println("\nLevel Order Traversal :- ");
		LinkedList<TreeNodeWithNext> nodes = new LinkedList<>();
		nodes.add(root);
		nodes.add(null);
		while(!nodes.isEmpty()) {
			TreeNodeWithNext curr = nodes.removeFirst();
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
