package dp;

import java.util.HashMap;

/***
 * 
 * In Fibonacci sequence, each number is the sum of the two preceding ones, starting from 0 and 1.
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * 
 * Given n, calculate F(n).
 * 
 */
public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7;
		
		System.out.println("Using Memoization :- ");
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<=n;i++) {
			System.out.println(i+"th fib no :- " + calculate(i, map));
		}
		
		System.out.println("\nUsing Tabulation :- ");
		for(int i=0;i<=n;i++) {
			System.out.println(i+"th fib no :- " + calculate(i));
		}
		
		System.out.println("\nUsing Space optimization");
		for(int i=0;i<=n;i++) {
			System.out.println(i+"th fib no :- " + calculateSO(i));
		}
	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 * 
	 */
	public static int calculate(int n,HashMap<Integer,Integer> map) {
		if(n==0 || n==1) {
			return n;
		}
		if(map.containsKey(n))
			return map.get(n);
		map.put(n, calculate(n-1, map)+calculate(n-2, map));
		return map.get(n);
	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 * 
	 */
	public static int calculate(int n) {
		if(n==0 || n==1) {
			return n;
		}
		int[] dpFib = new int[n+1];
		dpFib[0]=0;
		dpFib[1]=1;
		for(int i=2;i<=n;i++) {
			dpFib[i] = dpFib[i-1] + dpFib[i-2];
		}
		return dpFib[n];
	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(1)
	 * 
	 */
	public static int calculateSO(int n) {
		if(n==0 || n==1)
			return n;
		int prev2 = 0,prev1 = 1,index=1;
		while(index<n) {
			int curr = prev1 + prev2;
			prev2 = prev1;
			prev1 = curr;
			index++;
		}
		return prev1;
	}

}
