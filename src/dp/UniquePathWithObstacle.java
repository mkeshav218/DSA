package dp;

public class UniquePathWithObstacle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println("Using Memoization :- " + uniquePathMem(obstacleGrid));
		
		System.out.println("Using Tabulation :- " + uniquePathTab(obstacleGrid));
		
		System.out.println("Using Space Optimization :- " + uniquePathSO(obstacleGrid));

	}
	
	/***
	 * Time Complexity :- O(m * n)
	 * Space Complexity :- O(m * n)
	 */
	public static int uniquePathMem(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		
		if(obstacleGrid[m-1][n-1]==1 || obstacleGrid[0][0]==1){
            return 0;
        }
        dpPathMem = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dpPathMem[i][j] = -1;
            }
        }
        return uniquePathMemUtil(m-1,n-1,obstacleGrid);
	}
	public static int[][] dpPathMem;
    public static int uniquePathMemUtil(int i,int j,int[][] path){
        if(i==0 && j==0){
            return dpPathMem[i][j] = 1;
        }
        if(i<0 || j<0){
            return 0;
        }
        if(dpPathMem[i][j]!=-1){
            return dpPathMem[i][j];
        }
        int left = 0;
        if(i>=0 && j>=1 && path[i][j-1]!=1){
            left = uniquePathMemUtil(i,j-1,path);
        }
        int up = 0;
        if(i>=1 && j>=0 && path[i-1][j]!=1){
            up = uniquePathMemUtil(i-1,j,path);
        }
        return dpPathMem[i][j] = left + up;
    }

	/***
	 * Time Complexity :- O(m * n)
	 * Space Complexity :- O(m * n)
	 */
    public static int uniquePathTab(int[][] path){
        int m = path.length;
		int n = path[0].length;
		
		if(path[m-1][n-1]==1 || path[0][0]==1){
            return 0;
        }
        int[][] dpPathTab = new int[m][n];
        dpPathTab[0][0] = 1;
        for(int i=1;i<n;i++){
            if(path[0][i]!=1){
                dpPathTab[0][i] = 1;
            }else{
                break;
            }
        }
        for(int j=1;j<m;j++){
            if(path[j][0]!=1){
                dpPathTab[j][0] = 1;
            }else{
                break;
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(path[i][j]!=1){
                    dpPathTab[i][j] = dpPathTab[i-1][j] + dpPathTab[i][j-1];
                }
            }
        }
        return dpPathTab[m-1][n-1];
    }
    
	/***
	 * Time Complexity :- O(m * n)
	 * Space Complexity :- O(n)
	 */
    public static int uniquePathSO(int[][] path) {
        int m = path.length;
		int n = path[0].length;
		
		if(path[m-1][n-1]==1 || path[0][0]==1){
            return 0;
        }
		int[] prev = new int[n];
		for(int i=0;i<n;i++) {
			if(path[0][i]==0) {
				prev[i] = 1;
			}else {
				break;
			}
		}
		for(int i=1;i<m;i++) {
			int[] dpPathSO = new int[n];
			for(int j=0;j<n;j++) {
				if(path[i][j]==1) {
					dpPathSO[j] = 0;
				}else {
					if(j==0) {
						dpPathSO[j] = prev[j];
					}else {
						dpPathSO[j] = dpPathSO[j-1] + prev[j];
					}
				}
			}
			prev = dpPathSO;
		}
		return prev[n-1];
    }
}
