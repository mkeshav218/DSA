package heap;

import java.util.LinkedList;
import java.util.Scanner;

import binarytree.TreeNode;

/***
 * 
 * Given a binary tree. check whether the given tree follows the max heap property or not.
 * Note: Properties of a tree to be a max heap - Completeness and Value of node greater than or equal to its child.
 * 
 *  Time Complexity: O(N)
 *  Space Complexity: O(N)
 *
 */
public class IsBinaryTreeHeap {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = null;
		// 60 50 40 30 20 10 -1 -1 -1 -1 -1 -1 -1
		root = buildTreeLevelwise();
		levelOrderTraversal(root);
		
        int totalNoOfNodes = countNodes(root);
        System.out.println("Is Tree Heap :- " + (isCBT(root,1,totalNoOfNodes) && isNodeHeap(root)));
	}
	

    public static boolean isCBT(TreeNode tree,int index,int total){
        if(tree==null)
            return true;
        if(index>total)
            return false;
        else{
            return isCBT(tree.left,index*2,total) && isCBT(tree.right,2*index+1,total);
        }
    }
    
    public static boolean isNodeHeap(TreeNode tree){
        if(tree==null ||(tree.left==null && tree.right==null))
            return true;
        else{
            if(tree.left!=null && tree.right!=null){
                int leftD = tree.left.data;
                int rightD = tree.right.data;
                if(tree.data>=leftD && tree.data>= rightD){
                    return isNodeHeap(tree.left) && isNodeHeap(tree.right);
                }else{
                    return false;
                }
            }else if(tree.left!=null){
                int leftD = tree.left.data;
                if(tree.data>=leftD){
                    return isNodeHeap(tree.left);
                }else{
                    return false;
                }
            }else{
                int rightD = tree.right.data;
                if(tree.data>= rightD){
                    return isNodeHeap(tree.right);
                }else{
                    return false;
                }
            }
        }
    }

	
    public static int countNodes(TreeNode tree){
        if(tree==null)
            return 0;
        return 1 + countNodes(tree.left) + countNodes(tree.right);
    }
	
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
