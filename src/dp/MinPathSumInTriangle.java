package dp;

public class MinPathSumInTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] triangle = {{1},{2,3},{3,6,7},{8,9,6,10}};
		System.out.println("Using recursion :- " + minPathSumRec(0, 0, triangle, 0));
		System.out.println("Using recursion :- " + minPathSumRec(0, 0, triangle));
		
		dpPathSumMem = new int[triangle.length][triangle.length];
		System.out.println("Using Memoization :- " + minPathSumMem(0, 0, triangle));

		System.out.println("Using Tabulation :- " + minPathSumTab(triangle));

		System.out.println("Using Space Optimization :- " + minPathSumSO(triangle));

	}
	
	/***
	 * Time Complexity :- O(2 ^ n)
	 * Space Complexity :- O(n)
	 */
	public static int minPathSumRec(int m,int n,int[][] triangle,int total) {
		if(m==triangle.length-1) {
			return total + triangle[m][n];
		}
			
		int down =  minPathSumRec(m+1, n, triangle, triangle[m][n] + total);
		int right =  minPathSumRec(m+1, n+1, triangle,triangle[m][n] + total);
		return Math.min(down, right);
	}
	
	public static int minPathSumRec(int m,int n,int[][] triangle) {
		if(m==triangle.length-1) {
			return triangle[m][n];
		}
			
		int down =  triangle[m][n] + minPathSumRec(m+1, n, triangle);
		int right = triangle[m][n] + minPathSumRec(m+1, n+1, triangle);
		return Math.min(down, right);
	}
	
	/***
	 * Time Complexity :- O(n * n)
	 * Space Complexity :- O(n * n)
	 */
	public static int[][] dpPathSumMem;
	public static int minPathSumMem(int m,int n,int[][] triangle) {
		if(m==triangle.length-1) {
			return dpPathSumMem[m][n] = triangle[m][n];
		}
		if(dpPathSumMem[m][n] != 0)
			return dpPathSumMem[m][n];
		int down = minPathSumMem(m+1, n, triangle);
		int right = minPathSumMem(m+1, n+1, triangle);
		return dpPathSumMem[m][n] = triangle[m][n] + Math.min(down, right);
	}
	
	/***
	 * Time Complexity :- O(n * n)
	 * Space Complexity :- O(n * n)
	 */
	public static int minPathSumTab(int[][] triangle) {
		int n = triangle.length;
		int[][] dpPathSumTab = new int[n][n];
		for(int i=0;i<n;i++) {
			dpPathSumTab[n-1][i] = triangle[n-1][i];
		}
		for(int i=n-2;i>=0;i--) {
			for(int j=0;j<=i;j++) {
				dpPathSumTab[i][j] = triangle[i][j] + Math.min(dpPathSumTab[i+1][j], dpPathSumTab[i+1][j+1]);
			}
		}
		return dpPathSumTab[0][0];
	}
	
	/***
	 * Time Complexity :- O(n * m)
	 * Space Complexity :- O(n)
	 */
	public static int minPathSumSO(int[][] triangle) {
		int n = triangle.length;
		int[] prev = new int[n];
		for(int i=0;i<n;i++) {
			prev[i] = triangle[n-1][i];
		}
		for(int i=n-2;i>=0;i--) {
			int[] dpPathSumSO = new int[n];
			for(int j=0;j<=i;j++) {
				dpPathSumSO[j] = triangle[i][j] + Math.min(prev[j], prev[j+1]);
			}
			prev = dpPathSumSO;
		}
		return prev[0];
	}

}
