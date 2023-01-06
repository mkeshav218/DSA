package dp;

public class UniquePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<4;i++) {
			System.out.println("Using Recursion " + countPathRec(i, i));
		}
		System.out.println();
		for(int i=1;i<4;i++) {
			dpPathMem = new int[i+1][i+1];
			System.out.println("Using Memoization :- " + countPathMem(i, i));
		}
		dpPathMem = new int[3][7];
		System.out.println("Using Memoization :- " + countPathMem(2, 6));
		
		System.out.println();
		for(int i=1;i<4;i++) {
			System.out.println("Using Tabulation :- " + countPathTab(i, i));
		}
	}
	/***
	 * Time Complexity :- O(2 ^(n * m))
	 * Space Complexity :- O(n + m)
	 */
	public static int countPathRec(int i,int j) {
		if(i==0 && j==0) {
			return 1;
		}
		if(i<0 || j<0)
			return 0;
		int left = countPathRec(i-1,j);
		int up = countPathRec(i, j-1);
		return left + up;
	}
	
	/***
	 * Time Complexity :- O(n * m)
	 * Space Complexity :- O(n * m)
	 */
	public static int[][] dpPathMem;
	public static int countPathMem(int i,int j) {
		if(i==0 && j==0) {
			return dpPathMem[i][j] = 1;
		}
		if(i<0 || j<0)
			return 0;
		if(dpPathMem[i][j]!=0)
			return dpPathMem[i][j];
		int left = countPathRec(i-1,j);
		int up = countPathRec(i, j-1);
		return dpPathMem[i][j] = left + up;
	}
	
	/***
	 * Time Complexity :- O(n * m)
	 * Space Complexity :- O(n * m)
	 */
	public static int countPathTab(int row,int col) {
		int[][] dpPathTab = new int[row+1][col+1];
		for(int i=0;i<=col;i++) {
			dpPathTab[0][i] = 1;
		}
		for(int i=1;i<=row;i++) {
			dpPathTab[i][0] = 1;
		}
		for(int i=1;i<=row;i++) {
			for(int j=1;j<=col;j++) {
				dpPathTab[i][j] = dpPathTab[i-1][j] + dpPathTab[i][j-1];
			}
		}
		return dpPathTab[row][col];
	}

}
