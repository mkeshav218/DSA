package dp;

/***
 * 
 * In an array of positive numbers, find the maximum sum of a subsequence,
 * such that no 2 numbers in the sequence should be adjacent in the array.
 *
 */
public class MaxSumOfNonAdjacentElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {5, 5, 10, 100, 10, 5};//{3, 2, 7, 10};//
		
		System.out.println("Using Tabulation :- " + getMaxSumTab(arr));
		System.out.println("Using Memoization :- " + getMaxSumMem(arr));
		System.out.println("Using Space Optimization :- " + getMaxSumSO(arr));
		System.out.println("Memoization Using single array :- "+ getSum(arr));
	}
	
	/***
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(1)
	 */
	public static int getMaxSumSO(int[] arr) {
		int n = arr.length;
		int includeSum = arr[0];
		int excludeSum = 0;
		for(int i=1;i<n;i++) {
			int currentIncludeSum = arr[i] + excludeSum;
			int currentExcludeSum = Math.max(includeSum, excludeSum);
			includeSum = currentIncludeSum;
			excludeSum = currentExcludeSum;
		}
		return Math.max(includeSum, excludeSum);
	}
	
	/***
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 */
	public static int getMaxSumTab(int[] arr) {
		int n = arr.length;
		int[] includeSum = new int[n];
		int[] excludeSum = new int[n];
		includeSum[0] = arr[0];
		for(int i=1;i<n;i++) {
			includeSum[i] = arr[i] + excludeSum[i-1];
			excludeSum[i] = Math.max(includeSum[i-1], excludeSum[i-1]);
		}
		return Math.max(includeSum[n-1], excludeSum[n-1]);
	}
	
	/***
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 */
	public static int[] include,exclude;
	public static int getMaxSumMem(int[] arr) {
		int n = arr.length;
		include = new int[n];
		exclude = new int[n];
		getMaxSumMemUtil(arr, n-1);
		return Math.max(include[n-1], exclude[n-1]);
	}
	public static void getMaxSumMemUtil(int[] arr,int n) {
		if(n==0) {
			include[0] = arr[0];
			exclude[0] = 0;
			return;
		}
		getMaxSumMemUtil(arr, n-1);
		include[n] = arr[n] + exclude[n-1];
		exclude[n] = Math.max(include[n-1],exclude[n-1]);
	}
	
	public static int[] dpMaxSum;
	public static int getSum(int[] arr) {
		int n = arr.length;
		dpMaxSum = new int[n];
		return getSumUtil(arr, n-1);
	}
	public static int getSumUtil(int[] arr,int n) {
		if(n<0)
			return 0;
		if(n==0)
			return arr[0];
		if(dpMaxSum[n]!=0)
			return dpMaxSum[n];
		int includeSum = arr[n] + getSumUtil(arr,n-2);
		int excludeSum = getSumUtil(arr,n-1);
		return dpMaxSum[n]=Math.max(includeSum, excludeSum);
	}

}
