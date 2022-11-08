package binarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/***
 * 
 * Given an array arr[] of N integers and replace every element with the least greater element on its right side in the array. 
 * If there are no greater elements on the right side, replace it with -1. 
 *
 * Input: arr[] = {8, 58, 71, 18, 31, 32, 63, 92, 43, 3, 91, 93, 25, 80, 28}
 * Output:        {18, 63, 80, 25, 32, 43, 80, 93, 80, 25, 93, -1, 28, -1, -1}
 * 
 *  Time Complexity: O(N* log N)
 *  Space Complexity: O(N)
 */
public class ReplaceElementWithLeastBiggerElementOnRight {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		int[] arr = {8, 58, 71, 18, 31, 32, 63, 92, 43, 3, 91, 93, 25, 80, 28};
		
		ArrayList<Integer> list = findLeastGreater(arr.length, arr);
		for(int i:list)
			System.out.print(i+" ");
		
	}
	
	public static ArrayList<Integer> findLeastGreater(int n, int[] arr) {
		TreeNode root = null;
        Successor s = new Successor();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            s.succ = -1;
            root = insert(root,arr[i],s);
            if(s.succ==-1){
                arr[i]=-1;
            }else{
                arr[i] = s.succ;
            }
        }
        for(int i:arr)
            list.add(i);
        return list;
    }

    public static TreeNode insert(TreeNode root,int data, Successor s){
        if(root==null){
            return new TreeNode(data);
        }
        if(data>=root.data){
            root.right = insert(root.right,data,s);
        }else{
            s.succ = root.data;
            root.left = insert(root.left,data,s);
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

class Successor{
    int succ;
}
