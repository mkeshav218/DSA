package dp;

import java.util.Arrays;

public class MinFallingPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] path = {{2,1,3},{6,5,4},{7,8,9}};
		
		dpPathMem = new int[path.length][path[0].length];
		for(int i=0;i<path.length;i++) {
			Arrays.fill(dpPathMem[i], Integer.MIN_VALUE);
		}
		int min = Integer.MAX_VALUE;
		for(int i=0;i<path[0].length;i++) {
			min = Math.min(min, minPathMem(path.length-1, i, path));
		}
		System.out.println("Using Memoization = " + min);
		
		System.out.println("Using Tabulation :- " + minPathTab(path));
		
		System.out.println("Using Space Optimization :- " + minPathSO(path));

	}
	
	public static int[][] dpPathMem;
	public static int minPathMem(int m,int n,int[][] path) {
		if(m==0)
			return dpPathMem[m][n] = path[m][n];
		if(dpPathMem[m][n]!=Integer.MIN_VALUE) {
			return dpPathMem[m][n];
		}
		int up = Integer.MAX_VALUE,left = Integer.MAX_VALUE , right = Integer.MAX_VALUE;
		if(n>0) {
			left = minPathMem(m-1, n-1, path);
		}
		if(n<path[0].length-1) {
			right = minPathMem(m-1, n+1, path);
		}
		up = minPathMem(m-1, n, path);
		int value = Math.min(up, Math.min(left, right));
		return dpPathMem[m][n] = path[m][n] + value;
	}
	
	public static int minPathTab(int[][] path) {
		int m = path.length;
		int n = path[0].length;
		int[][] dpPathTab = new int[m][n];
		for(int i=0;i<n;i++) {
			dpPathTab[0][i] = path[0][i];
		}
		for(int i=1;i<m;i++) {
			for(int j=0;j<n;j++) {
				int up = dpPathTab[i-1][j];
				int left = Integer.MAX_VALUE , right = Integer.MAX_VALUE;
				if(j!=0 && j!=n-1) {
					left = dpPathTab[i-1][j-1];
					right = dpPathTab[i-1][j+1];
				}else if(j!=0) {
					left = dpPathTab[i-1][j-1];
				}else if(j!=n-1) {
					right = dpPathTab[i-1][j+1];
				}
				dpPathTab[i][j] = path[i][j] + Math.min(up, Math.min(left, right));
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			min = Math.min(min, dpPathTab[m-1][i]);
		}
		return min;
	}
	
	public static int minPathSO(int[][] path) {
		int m = path.length;
		int n = path[0].length;
		int[] prev = new int[n];
		for(int i=0;i<n;i++) {
			prev[i] = path[0][i];
		}
		for(int i=1;i<m;i++) {
			int[] dpPathSO = new int[n];
			for(int j=0;j<n;j++) {
				int up = prev[j];
				int left = Integer.MAX_VALUE , right = Integer.MAX_VALUE;
				if(j!=0 && j!=n-1) {
					left = prev[j-1];
					right = prev[j+1];
				}else if(j!=0) {
					left = prev[j-1];
				}else if(j!=n-1) {
					right = prev[j+1];
				}
				dpPathSO[j] = path[i][j] + Math.min(up, Math.min(left, right));
			}
			prev = dpPathSO;
		}
		int min = Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			min = Math.min(min, prev[i]);
		}
		return min;
	}


}
