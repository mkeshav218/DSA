package binarytree;

import java.util.HashMap;
import java.util.LinkedList;
/***
 * 
 * Given 2 Arrays of Inorder and preorder traversal. 
 * Construct binary tree from them.
 *
 * 
 */
public class TreeFromInorderPreorder {

	public static void main(String[] args) {
		int[] inorder = {1,6,8,7};
		int[] preorder = {1,6,7,8};
		
		HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        TreeNode root = build(map,0,inorder.length-1,preorder);
        levelOrderTraversal(root);
        
		System.out.println("PostOrder Traversal :- ");
        postOrder(root);
	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 * 
	 *  As Inorder contains data in seq(L-N-R) 
	 *  so store each element in hashmap so that fetching complexity would become O(1).
	 *  As preorder contains data in seq(N-L-R) 
	 *  so create node from preorder & find its left & right from inorder.
	 *   
	 */
	static int index = 0;
	public static TreeNode build(HashMap<Integer,Integer> map,int start,int end,int[] preorder){
        if(index>=preorder.length || start>end)
            return null;
        int data = preorder[index++];
        TreeNode temp = new TreeNode(data);
        int index = map.get(data);
        temp.left = build(map,start,index-1,preorder);
        temp.right = build(map,index+1,end,preorder);
        return temp;
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
	
	public static void postOrder(TreeNode root) {
		if(root==null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}

}
