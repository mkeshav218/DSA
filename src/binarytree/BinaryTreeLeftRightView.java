package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BinaryTreeLeftRightView {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		TreeNode root = null;
		// 1 2 4 -1 -1 5 -1 -1 3 6 -1 -1 7 -1 -1
		//root = buildTree();
		
		// 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
		root = buildTreeLevelwise();
		
		levelOrderTraversal(root);
		
				
		System.out.println("Left View :- ");
		List<Integer> left_1 = leftView_M_1(root);
		System.out.println(left_1);
		
		System.out.println("Left View :- ");
		List<Integer> left_2 = leftView_M_2(root);
		System.out.println(left_2);
		
		System.out.println("Left View :- ");
		List<Integer> left_3 = leftView_M_3(root);
		System.out.println(left_3);
		
		System.out.println("Right View :- ");
		List<Integer> right_1 = rightView_M_1(root);
		System.out.println(right_1);
		
		System.out.println("Right View :- ");
		List<Integer> right_2 = rightView_M_2(root);
		System.out.println(right_2);
		
		System.out.println("Right View :- ");
		List<Integer> right_3 = rightView_M_3(root);
		System.out.println(right_3);
	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 * 
	 */
	static int maxLevel = 0;
	public static List<Integer> leftView_M_1(TreeNode root){
		maxLevel = 0;
		List<Integer> result = new ArrayList<>();
		if(root==null)
			return result;
		left_1(root,1,result);
		return result;
	}
    public static void left_1(TreeNode root,int level,List<Integer> result) {
        if(root==null)
            return;
        if(maxLevel<level){
            result.add(root.data);
            maxLevel = level;
        }
        if(root.left!=null)
        	left_1(root.left,level+1,result);  
        if(root.right!=null)
        	left_1(root.right,level+1,result);
    }
    
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 * 
	 */
    public static List<Integer> leftView_M_2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null)
            return result;
        left_2(root,0,result);
        return result;
    }
    public static void left_2(TreeNode root,int level,List<Integer> result) {
        if(root==null)
            return;
        if(result.size()==level){
            result.add(root.data);
        }
        if(root.left!=null)
        	left_2(root.left,level+1,result); 
        if(root.right!=null)
        	left_2(root.right,level+1,result);
    }
    
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 * 
	 */
    public static List<Integer> leftView_M_3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null)
            return result;
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while(!nodes.isEmpty()) {
        	int n = nodes.size();
        	TreeNode temp = nodes.get(0);
        	result.add(temp.data);
        	for(int i=0;i<n;i++) {
        		temp = nodes.remove(0);
        		if(temp.left!=null)
        			nodes.add(temp.left);
        		if(temp.right!=null)
        			nodes.add(temp.right);
        	}
        }
        return result;
    }
    
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 * 
	 */
	static int maxLevelRight = 0;
	public static List<Integer> rightView_M_1(TreeNode root){
		maxLevelRight = 0;
		List<Integer> result = new ArrayList<>();
		if(root==null)
			return result;
		right_1(root,1,result);
		return result;
	}
    public static void right_1(TreeNode root,int level,List<Integer> result) {
        if(root==null)
            return;
        if(maxLevelRight<level){
            result.add(root.data);
            maxLevelRight = level;
        }
        if(root.right!=null)
        	right_1(root.right,level+1,result);
        if(root.left!=null)
        	right_1(root.left,level+1,result);  
    }
    
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 * 
	 */
    public static List<Integer> rightView_M_2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null)
            return result;
        right_2(root,0,result);
        return result;
    }
    public static void right_2(TreeNode root,int level,List<Integer> result) {
        if(root==null)
            return;
        if(result.size()==level){
            result.add(root.data);
        }
        if(root.right!=null)
        	right_2(root.right,level+1,result);
        if(root.left!=null)
        	right_2(root.left,level+1,result); 
    }
    
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 * 
	 */
    public static List<Integer> rightView_M_3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null)
            return result;
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while(!nodes.isEmpty()) {
        	int n = nodes.size();
        	TreeNode temp = nodes.get(0);
        	result.add(temp.data);
        	for(int i=0;i<n;i++) {
        		temp = nodes.remove(0);
        		if(temp.right!=null)
        			nodes.add(temp.right);
        		if(temp.left!=null)
        			nodes.add(temp.left);
        	}
        }
        return result;
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
