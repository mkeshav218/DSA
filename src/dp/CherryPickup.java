package dp;

public class CherryPickup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = 
//			{{0,1,-1},{1,0,-1},{1,1,1}};
//				{{1,1,-1},{1,-1,1},{-1,1,1}};
				
//				{{1,1,1,1,0},
//				{0,0,0,1,0},
//				{0,0,0,0,1},
//				{1,0,0,0,0},
//				{0,1,1,1,1}};

//						{{1,1,0,0},
//						{0,1,0,1},
//						{1,1,0,0},
//						{0,1,1,1}};
				
						{{1,1,1,1,0,0,0},
						{0,0,0,1,0,0,0},
						{0,0,0,1,0,0,1},
						{1,0,0,1,0,0,0},
						{0,0,0,1,0,0,0},
						{0,0,0,1,0,0,0},
						{0,0,0,1,1,1,1}};
				
//		{{0,1,0},{1,0,0},{1,1,1}};
				
		
		int n = grid.length;
		
		int outputRec = calRec(0, 0, 0, 0, n, grid);
		System.out.println("Using Recursion :- " + Math.max(outputRec, 0) );
		
		int outputMem = calMaxCherryMem(0, 0, 0, 0, n, grid,new Integer[n][n][n][n]);
		System.out.println("Using Memoization :- " + Math.max(outputMem, 0));
		
		int outputMem3D = calMaxCherryMem3D(0, 0, 0, n, grid,new Integer[n][n][n]);
		System.out.println("Using Memoization :- " + Math.max(outputMem3D, 0));
	}
	public static int calRec(int i1,int j1,int i2,int j2,int n,int[][] grid) {
		if(j1>=n || i1>=n || i2>=n || j2>=n || grid[i1][j1]==-1 || grid[i2][j2]==-1)
			return Integer.MIN_VALUE;
		if(i1==n-1 && j1==n-1) {
			return grid[i1][j1];
		}
		if(i2==n-1 && j2==n-1)
			return grid[i2][j2];
		int count = 0;
		if(i1==i2  && j1==j2) {
			count = grid[i1][j1];
		}else {
			count = grid[i1][j1] + grid[i2][j2];
		}
		int n1 = calRec(i1+1, j1, i2+1, j2, n, grid);
		int n2 = calRec(i1+1, j1, i2, j2+1, n, grid);
		int n3 = calRec(i1, j1+1, i2+1, j2, n, grid);
		int n4 = calRec(i1, j1+1, i2, j2+1, n, grid);
		
		count += Math.max(n1, Math.max(n2, Math.max(n3, n4)));
		return count;
	}
	
	public static int calMaxCherryMem(int i1,int j1,int i2,int j2,int n,int[][] grid, Integer dpMaxCherryMem[][][][]) {
		if(j1>=n || i1>=n || i2>=n || j2>=n || grid[i1][j1]==-1 || grid[i2][j2]==-1)
			return Integer.MIN_VALUE;
		if(dpMaxCherryMem[i1][j1][i2][j2]!=null)
			return dpMaxCherryMem[i1][j1][i2][j2];
		if(i1==n-1 && j1==n-1) {
			return grid[i1][j1];
		}
		if(i2==n-1 && j2==n-1)
			return grid[i2][j2];
		int count = 0;
		if(i1==i2  && j1==j2) {
			count = grid[i1][j1];
		}else {
			count = grid[i1][j1] + grid[i2][j2];
		}
		int n1 = calMaxCherryMem(i1+1, j1, i2+1, j2, n, grid,dpMaxCherryMem);
		int n2 = calMaxCherryMem(i1+1, j1, i2, j2+1, n, grid,dpMaxCherryMem);
		int n3 = calMaxCherryMem(i1, j1+1, i2+1, j2, n, grid,dpMaxCherryMem);
		int n4 = calMaxCherryMem(i1, j1+1, i2, j2+1, n, grid,dpMaxCherryMem);
		count += Math.max(n1, Math.max(n2, Math.max(n3, n4)));
		return dpMaxCherryMem[i1][j1][i2][j2] = new Integer(count);
	}
	
	public static int calMaxCherryMem3D(int i1,int j1,int i2,int n,int[][] grid, Integer dpMaxCherryMem[][][]) {
		int j2 = (i1 + j1) - i2;
		if(j1>=n || i1>=n || i2>=n || j2>=n || grid[i1][j1]==-1 || grid[i2][j2]==-1)
			return Integer.MIN_VALUE;
		if(dpMaxCherryMem[i1][j1][i2]!=null)
			return dpMaxCherryMem[i1][j1][i2];
		if(i1==n-1 && j1==n-1) {
			return grid[i1][j1];
		}
		if(i2==n-1 && j2==n-1)
			return grid[i2][j2];
		int count = 0;
		if(i1==i2  && j1==j2) {
			count = grid[i1][j1];
		}else {
			count = grid[i1][j1] + grid[i2][j2];
		}
		int n1 = calMaxCherryMem3D(i1+1, j1, i2+1, n, grid,dpMaxCherryMem);
		int n2 = calMaxCherryMem3D(i1+1, j1, i2, n, grid,dpMaxCherryMem);
		int n3 = calMaxCherryMem3D(i1, j1+1, i2+1, n, grid,dpMaxCherryMem);
		int n4 = calMaxCherryMem3D(i1, j1+1, i2, n, grid,dpMaxCherryMem);
		count += Math.max(n1, Math.max(n2, Math.max(n3, n4)));
		return dpMaxCherryMem[i1][j1][i2] = new Integer(count);
	}
}