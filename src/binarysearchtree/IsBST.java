package binarysearchtree;

import java.util.LinkedList;
import java.util.Scanner;
/***
 * 
 * Integer.MIN_VALUE <= Node.val <= Integer.MAX_VALUE
 *
 */
public class IsBST {
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

		System.out.println("Is BST Valid :- " + isValidBST(root));
	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 * 
	 */
    public static boolean isValidBST(TreeNode root) {
        return traverse(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public static boolean traverse(TreeNode root,long min,long max){
        if(root==null)
            return true;
        if(root.data>=min && root.data<=max){
            return traverse(root.left,min,(long)root.data-1) && traverse(root.right,(long)root.data+1,max);
        }else{
            return false;
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
