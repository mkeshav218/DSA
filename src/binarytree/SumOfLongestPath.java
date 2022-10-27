package binarytree;

import java.util.LinkedList;
import java.util.Scanner;

public class SumOfLongestPath {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		TreeNode root = null;
		// 1 2 4 -1 -1 5 -1 -1 3 6 -1 -1 7 -1 -1
		//root = buildTree();
		
		// 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
		root = buildTreeLevelwise();
		
		levelOrderTraversal(root);
		
		
		System.out.println("PreOrder Traversal :- ");
		preOrder(root);
		System.out.println();
		
		System.out.println("Sum of longest path (M-1) :- " + sumOfLongRootToLeafPath(root));
		System.out.println("Sum of longest path (M-2) :- " + sumOfLongRootToLeafPath1(root));

	}
	
	/***
	 * Method - 1
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 * 
	 */
	public static int sumOfLongRootToLeafPath(TreeNode root)
    {
        int[] res = calculate(root);
        return res[1];
    }
    
    public static int[] calculate(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }
        int[] left = calculate(root.left);
        int[] right = calculate(root.right);
        if(left[0]>right[0]){
            int h = left[0]+1;
            int sum = left[1] + root.data;
            return new int[]{h,sum};
        }else if(left[0]<right[0]){
            int h = right[0]+1;
            int sum = right[1] + root.data;
            return new int[]{h,sum};
        }else{
            int h = left[0]+1;
            int sum = 0;
            if(left[1]>right[1]){
                sum = left[1] + root.data;
            }else{
                sum = right[1] + root.data;
            }
            return new int[]{h,sum};
        }
    }
    
	/***
	 * Method - 2
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 * Using static variables
	 * 
	 */
    public static int maxSum = 0;
    public static int maxLevel = 0;
    public static int sumOfLongRootToLeafPath1(TreeNode root)
    {
        maxSum = 0;
        maxLevel = 0;
        calculate1(root,0,0);
        return maxSum;
    }
    
    public static void calculate1(TreeNode root,int level,int sum){
        if(root==null){
            if(maxLevel<level){
                maxLevel = level;
                maxSum = sum;
            }else if(maxLevel==level){
                maxSum = Math.max(maxSum,sum);
            }
            return;
        }
        calculate1(root.left,level+1,sum+root.data);
        calculate1(root.right,level+1,sum+root.data);
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
