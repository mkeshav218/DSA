package binarytree;

import java.util.HashMap;
import java.util.Stack;

/***
 * 
 * Given two n-ary trees. Check if they are mirror images of each other or not. 
 * You are also given e denoting the number of edges in both trees, and two arrays, A[] and B[]. 
 * Each array has 2*e space separated values u,v denoting an edge from u to v for the both trees.
 *
 */
public class CheckMirrorInNAryTree {

	public static void main(String[] args) {
		
		int n = 3, e = 2;
		int[] A= {1, 2, 1, 3};
		int[] B= {1, 3, 1, 2};
		
		System.out.println("Is Mirror-Tree :- " + checkMirrorTree(n, e, A, B));
		
		n = 3;
		e = 2;
		A = new int[]{1, 2, 1, 3};
		B = new int[]{1, 2, 1, 3};
		
		System.out.println("Is Mirror-Tree :- " + checkMirrorTree(n, e, A, B));
	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 * 
	 */
    public static boolean checkMirrorTree(int n, int e, int[] A, int[] B) {
        HashMap<Integer,Stack<Integer>> map = new HashMap<>();
        for(int i=0;i<2*e;i+=2){
            if(map.containsKey(A[i])){
                Stack<Integer> s = map.get(A[i]);
                s.push(A[i+1]);
                map.put(A[i],s);
            }else{
                Stack<Integer> s = new Stack<>();
                s.push(A[i+1]);
                map.put(A[i],s);
            }
        }
        for(int i=0;i<2*e;i+=2){
            if(map.containsKey(B[i]) && map.get(B[i]).size()>0){
                if(map.get(B[i]).peek()!=B[i+1]){
                    return false;
                }
                map.get(B[i]).pop();
            }
        }
        return true;
    }

}
