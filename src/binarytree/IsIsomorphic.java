package binarytree;

import java.util.LinkedList;
import java.util.Scanner;


/***
 * 
 *Two trees are called isomorphic if one can be obtained from another by a series of flips, 
 *i.e. by swapping left and right children of several nodes. Any number of nodes at any level can have their children swapped.
 * Two empty trees are isomorphic.
 *
 *traverse both trees.
 * Let the current internal nodes of two trees being traversed be n1 and n2 respectively. 
 * There are following two conditions for subtrees rooted with n1 and n2 to be isomorphic. 

	Data of n1 and n2 is same. 
	One of the following two is true for children of n1 and n2 
		......a) Left child of n1 is isomorphic to left child of n2 and right child of n1 is isomorphic to right child of n2. 
		......b) Left child of n1 is isomorphic to right child of n2 and right child of n1 is isomorphic to left child of n2.
 *
 */
public class IsIsomorphic {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		TreeNode root1 = null,root2=null;
		
		// 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
		root1 = buildTreeLevelwise();
		root2 = buildTreeLevelwise();
		levelOrderTraversal(root1);
		levelOrderTraversal(root2);

		System.out.println("Is root1 & root2 isomorphic :- " + isIsomorphic(root1, root2));
	
	}
	
	/***
	 * 
	 * Expected Time Complexity: O(min(M, N)) where M and N are the sizes of the two trees.
	 * Expected Auxiliary Space: O(min(H1, H2)) where H1 and H2 are the heights of the two trees.
	 * 
	 */
    public static boolean isIsomorphic(TreeNode root1, TreeNode root2)  
    { 
        if(root1==null && root2==null)
            return true;
        if(root1==null || root2==null)
            return false;
        if(root1.data!=root2.data)
            return false;
        return (isIsomorphic(root1.left,root2.left) && isIsomorphic(root1.right,root2.right)) ||
            (isIsomorphic(root1.left,root2.right) && isIsomorphic(root1.right,root2.left));
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
