package dp;

import java.util.Arrays;

public class CherryPickup2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
		
        int n = grid.length;
        int m = grid[0].length;
        dpGridMem = new int[n][m][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dpGridMem[i][j],-1);
            }
        }
        System.out.println("Using Memoization :- "  + calculateMem(0,0,m-1,n,m,grid));
        
        System.out.println("Using Tabulation :- "  + calculateTab(n,m,grid));

	}
	
	/***
	 * Time complexity :- O(3^n * 3^n)
	 */
    public static int calculateRec(int i,int j1,int j2,int n,int m,int[][] grid){
        if(j1<0 || j1>=m || j2<0 || j2>=m){
            return Integer.MIN_VALUE;
        }
        if(i==n-1){
            if(j1==j2)
                return grid[i][j1];
            else
                return grid[i][j1] + grid[i][j2];
        }
        int curr = 0;
        if(j1==j2){
            curr = grid[i][j1];
        }else{
            curr = grid[i][j1] + grid[i][j2];
        }
        int max = 0;
        for(int r=-1;r<=1;r++){
            for(int c=-1;c<=1;c++){
                int value = calculateRec(i+1,j1+r,j2+c,n,m,grid);
                max = Math.max(max,value);
            }
        }
        return curr + max;
    }
	
    /***
     * Time Complexity :- O(n*m*m)
     * Space Complexity :- O(n*m*m)
     */
    public static int[][][] dpGridMem;
    public static int calculateMem(int i,int j1,int j2,int n,int m,int[][] grid){
        if(j1<0 || j1>=m || j2<0 || j2>=m){
            return Integer.MIN_VALUE;
        }
        if(i==n-1){
            if(j1==j2)
                return grid[i][j1];
            else
                return grid[i][j1] + grid[i][j2];
        }
        if(dpGridMem[i][j1][j2]!=-1)
            return dpGridMem[i][j1][j2];
        int curr = 0;
        if(j1==j2){
            curr = grid[i][j1];
        }else{
            curr = grid[i][j1] + grid[i][j2];
        }
        int max = 0;
        for(int r=-1;r<=1;r++){
            for(int c=-1;c<=1;c++){
                int value = calculateMem(i+1,j1+r,j2+c,n,m,grid);
                max = Math.max(max,value);
            }
        }
        return dpGridMem[i][j1][j2] = curr + max;
    } 
    
    public static int calculateTab(int n,int m,int[][] grid){
        int[][][] dpGridTab = new int[n][m][m];
        for(int j1=0;j1<m;j1++){
            for(int j2=0;j2<m;j2++){
                if(j1==j2)
                    dpGridTab[n-1][j1][j2] = grid[n-1][j1];
                else
                    dpGridTab[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2];
            }
        }
        for(int i=n-2;i>=0;i--){
            for(int j1=0;j1<m;j1++){
                for(int j2=0;j2<m;j2++){
                    int curr = 0;
                    if(j1==j2){
                        curr = grid[i][j1];
                    }else{
                        curr = grid[i][j1] + grid[i][j2];
                    }
                    int max = 0;
                    for(int dj1=-1;dj1<=1;dj1++){
                        for(int dj2=-1;dj2<=1;dj2++){
                            int value = Integer.MIN_VALUE;
                            if(j1+dj1>=0 && j1+dj1<m && j2+dj2>=0 && j2+dj2<m)
                                value = dpGridTab[i+1][j1+dj1][j2+dj2];
                            max = Math.max(max,value);
                        }
                    }
                    dpGridTab[i][j1][j2] = max + curr;
                }
            }
        }
        return dpGridTab[0][0][m-1];
    }
}