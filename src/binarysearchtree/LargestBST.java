package binarysearchtree;

import java.util.LinkedList;
import java.util.Scanner;
/***
 * 
 * Given a binary tree. Find the size of its largest subtree that is a Binary Search Tree.
 * Size is equal to the number of nodes in the subtree.
 *
 */
public class LargestBST {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		TreeNode root = null;
		// 1 4 4 6 8 -1 -1 -1 -1 3 10 -1 -1 -1 -1
		root = buildTreeLevelwise();
		levelOrderTraversal(root);
		
		System.out.println("Size of largest BST :- " + largestBst(root));
	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(h)
	 */
    public static int largestBst(TreeNode root)
    {
        return check1(root).total;
    }
    public static Info check1(TreeNode root){
        if(root==null){
            return new Info(1,-1,-1,0);
        }
        if(root.left==null && root.right==null){
            return new Info(1,root.data,root.data,1);
        }
        Info left = check1(root.left);
        Info right = check1(root.right);
        int total = 0;
        if(left.isBst==1 && right.isBst==1){
            if((left.max==-1 || root.data>left.max) && (right.min==-1 || root.data<right.min)){
                total += left.total+right.total+1;
                int min = 0;
                if(left.min==-1){
                    min = root.data;
                }else{
                    min = left.min;
                }
                int max = 0;
                if(right.max==-1){
                    max = root.data;
                }else{
                    max = right.max;
                }
                return new Info(1,min,max,total);
            }else{
                total = Math.max(left.total,right.total);
                return new Info(0,-1,-1,total);
            }
        }else{
            total = Math.max(left.total,right.total);
            return new Info(0,-1,-1,total);
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

class Info{
    int isBst;
    int min;
    int max;
    int total;
    
    public Info(int isBst,int min,int max,int total){
        this.isBst = isBst;
        this.min = min;
        this.max = max;
        this.total = total;
    }
}
