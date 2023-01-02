package dp;

/***
 * 
 * Calculate the minimum energy used by frog to reach from 1st stair to Nth stair.
 * If frog is on ith stair, he can jump either to (i+1)th stair or (i+2)th stair.
 * Energy lost in jump is given by absolute value of (height[i-1]-height[j-1]);
 *
 */
public class FrogJump {

	public static void main(String[] args) {
		int[] heights = {10,20,30,10};
		int n = heights.length;
		System.out.println("Using Memoization :- "+calEnergyMem(n, heights));
		System.out.println("Using Tabulation :- "+calEnergyTab(n, heights));
		System.out.println("Using Space Optimization :- "+calEnergySO(n, heights));
	}

	/***
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(1)
	 */
	public static int calEnergySO(int n,int[] heights){
		if(n==0 || n==1)
			return 0;
		int prev2 = 0;
		int prev1 = Math.abs(heights[1]-heights[0]);
		for(int i=2;i<n;i++){
			int left = prev1 + Math.abs(heights[i]-heights[i-1]);
			int right = prev2 + Math.abs(heights[i]-heights[i-2]);
			prev2 = prev1;
			prev1 = Math.min(left,right);
		}
		return prev1;
	}    

	/***
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 */
	public static int calEnergyTab(int n,int[] heights){
		if(n==0 || n==1)
			return 0;
		int[] dp = new int[n];
		dp[0] = 0;
		dp[1] = Math.abs(heights[1]-heights[0]);
		for(int i=2;i<n;i++){
			int left = dp[i-1] + Math.abs(heights[i]-heights[i-1]);
			int right = dp[i-2] + Math.abs(heights[i]-heights[i-2]);
			dp[i] = Math.min(left,right);
		}
		return dp[n-1];
	}

	/***
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 */
	public static int[] dpArray = new int[100];
	public static int calEnergyMem(int n, int height[]){
		if(n==0 || n==1){
			return 0;
		}
		if(n==2){
			return Math.abs(height[1]-height[0]);
		}
		if(dpArray[n]!=0)
			return dpArray[n];
		int left = calEnergyMem(n-1,height) + Math.abs(height[n-1]-height[n-2]);
		int right = calEnergyMem(n-2,height) + Math.abs(height[n-1]-height[n-3]);
		return dpArray[n] = Math.min(left,right);
	}

}
