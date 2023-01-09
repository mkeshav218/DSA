package dp;

import java.util.Arrays;
/***
 * Given an integer array nums, return true if you can partition the array into two subsets
 * such that the sum of the elements in both subsets is equal or false otherwise.
 */
public class PartitionEqualSubSetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = 
		{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100};
				
				//{1,2,5};//{4,1,5,11,5};//{2,2,3,5,2};//{100};
		int target = 0,n=input.length;
		for(int i:input)
			target += i;
		if(target%2==1) {
			System.out.println("Not Possible");
		}else {
			target /= 2;
//			System.out.println("Using Recursion :- " + calRec(n-1, target, input));
			
			dpMem = new int[n][target+1];
			for(int i=0;i<n;i++)
				Arrays.fill(dpMem[i],-1);
			int resMem = calMem(n-1, target, input);
			System.out.println("Using Memoization :- " + (resMem>0?true:false));
			
			int resTab = calTab(n-1, target, input);
			System.out.println("Using Tabulation  :- " + (resTab>0?true:false));

			int resSO = calSO(n-1, target, input);
			System.out.println("Using Space Optimization  :- " + (resSO>0?true:false));

		}
		
	}
	
	public static boolean calRec(int i,int target, int[] input) {
		if(i<0)
			return false;
		if(target==0)
			return true;
		if(i==0) {
			if(input[i]==target)
				return true;
			return false;
		}
		boolean exclude = calRec(i-1, target, input);
		return exclude || calRec(i-1, target-input[i], input);
	}
	
	public static int[][] dpMem;
	public static int calMem(int i,int target,int[] input) {
		if(i<0 || target<0)
			return 0;
		if(i==0) {
			if(input[i]==target)
				return dpMem[i][target] = 1;
		}
		if(dpMem[i][target]!=-1)
			return dpMem[i][target];

		if(target==0)
			return dpMem[i][target] = 1;
		int exclude = calMem(i-1, target, input);
		int include = 0;
        if(exclude<1)
            include = calMem(i-1,target-input[i],input);
		return dpMem[i][target] = exclude + include;
	}
	
	public static int calTab(int n,int target,int[] input) {
		if(n==0) return 0;
		int[][] dpTab = new int[n][target+1];
		for(int i=0;i<n;i++)
			dpTab[i][0] = 1;
		if(input[0]<=target)
			dpTab[0][input[0]] = 1;
		for(int i=1;i<n;i++) {
			for(int j=1;j<=target;j++) {
				int exclude = dpTab[i-1][j];
				int include = 0;
				if(exclude<1 && input[i]<=j)
					include = dpTab[i-1][j-input[i]];
				dpTab[i][j] = include + exclude;
			}
		}
		return dpTab[n-1][target];
	}
	
	public static int calSO(int n,int target,int[] input) {
		if(n==0) return 0;
		int[] dpSO = new int[target+1];
		dpSO[0] = 1;
		if(input[0]<=target)
			dpSO[input[0]] = 1;
		for(int i=1;i<n;i++) {
			int[] curr = new int[target+1];
			curr[0] = 1;
			for(int j=1;j<=target;j++) {
				int exclude = dpSO[j];
				int include = 0;
				if(exclude<1 && input[i]<=j)
					include = dpSO[j-input[i]];
				curr[j] = include + exclude;
			}
			dpSO = curr;
		}
		return dpSO[target];
	}

}
