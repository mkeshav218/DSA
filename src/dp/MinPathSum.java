package dp;

public class MinPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println("Using Memoization :- " + minPathMem(grid));
		System.out.println("Using Tabulation :- " + minPathTab(grid));
		System.out.println("Using Space Optimization :- " + minPathSO(grid));

	}
	
	/***
	 * Time Complexity :- O(m * n)
	 * Space Complexity :- O(m * n)
	 */
	public static int minPathMem(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		dpPathMem = new int[m][n];
		return minPathMemUtil(m-1, n-1, grid);
	}
	public static int[][] dpPathMem;
	private static int minPathMemUtil(int m,int n, int[][] grid) {
		if(m==0 && n==0) {
			return grid[m][n];
		}
		if(m<0 || n<0) {
			return Integer.MAX_VALUE;
		}
		if(dpPathMem[m][n]!=0)
			return dpPathMem[m][n];
		int up = minPathMemUtil(m-1, n, grid);
		int left = minPathMemUtil(m, n-1, grid);
		return dpPathMem[m][n] = grid[m][n] +  Math.min(up, left);
	}
	
	/***
	 * Time Complexity :- O(m * n)
	 * Space Complexity :- O(m * n)
	 */
	public static int minPathTab(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dpPathTab = new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				int left = Integer.MAX_VALUE;
				int up = Integer.MAX_VALUE;
				if(i>0)
					left = dpPathTab[i-1][j];
				if(j>0)
					up = dpPathTab[i][j-1];
				int value = Math.min(up, left);
				if(value!=Integer.MAX_VALUE)
					dpPathTab[i][j] = grid[i][j] + Math.min(left,up);
				else
					dpPathTab[i][j] = grid[i][j];
			}
		}
		return dpPathTab[m-1][n-1];
	}
	
	/***
	 * Time Complexity :- O(m * n)
	 * Space Complexity :- O(n)
	 */
	public static int minPathSO(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[] prev = new int[n];
		for(int i=0;i<m;i++) {
			int[] dpPathSO = new int[n];
			for(int j=0;j<n;j++) {
				int left = Integer.MAX_VALUE;
				int up = Integer.MAX_VALUE;
				if(i>0) {
					left = prev[j];
				}
				if(j>0) {
					up = dpPathSO[j-1];
				}
				int value = Math.min(up, left);
				if(value!=Integer.MAX_VALUE)
					dpPathSO[j] = grid[i][j] + Math.min(left,up);
				else
					dpPathSO[j] = grid[i][j];
			}
			prev = dpPathSO;
		}
		return prev[n-1];
	}
}
