package dp;

public class SubSequenceSumK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input ={1,1,2,3,4};// {1,2};// {1,2,3};//
		int target = 1;//4;//3;//
		int n = input.length;
		
		total = 0;
		calRec(n-1, target, input);
		System.out.println("Using recursion :- " + total);
		   
		dpMem = new int[n][target+1];
		System.out.println("Using Memoization :- " + calMem(n-1, target, input));
		
		System.out.println("Using Tabulation :- " + calTab(target, input));
		
		System.out.println("Using Space Optimization :- " + calSO(target, input));

	}
	
	/***
	 * Time Complexity :- O(2^n)
	 * Space Complexity :- O(n)
	 */
	public static int total = 0;
	public static void calRec(int i,int target,int[] input){
		if(i<0)
			return;
		if(target==0) {
			total++;
			return;
		}
		if(i==0) {
			if(input[i]==target) {
				total++;
				return;
			}
		}
		calRec(i-1, target, input);
		if(input[i]<=target) {
			calRec(i-1, target-input[i], input);
		}
	}

	/***
	 * Time Complexity :- O(n*target)
	 * Space Complexity :- O(n*target)+O(n)
	 */
	public static int[][] dpMem;
	public static int calMem(int i,int target,int[] input) {
		if(i<0)
			return 0;
		if(i==0) {
			if(input[i]==target) {
				return dpMem[i][target] = 1;
			}
		}
		if(target==0) {
			return dpMem[i][target] = 1;
		}
		if(dpMem[i][target]!=0)
			return dpMem[i][target];
		int exclude = calMem(i-1, target, input);
		int include = 0;
		if(input[i]<=target) {
			include = calMem(i-1, target-input[i], input);
		}
		return dpMem[i][target] = include + exclude;
	}
	
	/***
	 * Time Complexity :- O(n*target)
	 * Space Complexity :- O(n*target)
	 */
	public static int calTab(int target,int[] input) {
		int n = input.length;
		int[][] dpTab = new int[n][target+1];
		
		for(int i=0;i<n;i++) {
				dpTab[i][0] = 1;
		}
		dpTab[0][input[0]] = 1;
		for(int i=1;i<n;i++) {
			for(int j=1;j<=target;j++) {
				int n1 = dpTab[i-1][j];
				int n2 = 0;
				if(input[i]<=j)
					n2 = dpTab[i-1][j-input[i]];
				dpTab[i][j] = n1 + n2;
			}
		}
		return dpTab[n-1][target];
	}
	
	public static int calSO(int target,int[] input) {
		int n = input.length;
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
				if(input[i]<=j)
					include = dpSO[j-input[i]];
				curr[j] = include + exclude;
			}
			dpSO = curr;
		}
		return dpSO[target];
	}
}
