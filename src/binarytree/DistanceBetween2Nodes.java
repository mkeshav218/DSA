package binarytree;

import java.util.LinkedList;
import java.util.Scanner;

/***
 * 
 * Method - 1
 * Find Lowest common ancestor
 * Distance between two nodes = sum of distance of nodes from lca.
 * 
 * Method - 2 
 * Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca)
 *
 */
public class DistanceBetween2Nodes {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		TreeNode root = null;
		
		// 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
		root = buildTreeLevelwise();
		
		levelOrderTraversal(root);
		
		int n1 = 4,n2 = 7;
		TreeNode lowestAncestor = lca(root, n1, n2);
		
		//Method - 1
        int d1 = findDist(lowestAncestor,n1,0);
        int d2 = findDist(lowestAncestor,n2,0);
        int dist = d1 + d2;
        System.out.println("Distance between " + n1 + " & " + n2 + " :- " + dist );
        
        //Method - 2
        int dist1 = findDist(root, n1, 0);
        int dist2 = findDist(root, n2, 0);
        int dist3 = findDist(root, lowestAncestor.data, 0);
        int totalDist = dist1 + dist2 - (2*dist3);
        System.out.println("Distance between " + n1 + " & " + n2 + " :- " + totalDist );

	}
	
	public static int findDist(TreeNode root,int a,int dist){
        if(root==null)
            return -1;
        if(root.data==a){
            return dist;
        }
        int left = findDist(root.left,a,dist+1);
        if(left==-1)
            return findDist(root.right,a,dist+1);
        return left;
    }
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 * 
	 */
	public static TreeNode lca(TreeNode root, int n1,int n2)
	{
	    if(root==null){
	        return null;
	    }
	    if(root.data==n1 || root.data==n2)
	        return root;
	    TreeNode leftNode = lca(root.left,n1,n2);
	    TreeNode rightNode = lca(root.right,n1,n2);

	    if(leftNode!=null && rightNode!=null){
	        return root;
	    }else if(leftNode==null && rightNode !=null){
	        return rightNode;
	    }else if(leftNode!=null && rightNode==null){
	        return leftNode;
	    }else{
	        return null;
	    }
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
