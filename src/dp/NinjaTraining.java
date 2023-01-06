package dp;

public class NinjaTraining {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] training = {{2,1,3},{3,4,6},{10,1,6},{8,3,7}};//{{1,2,5},{3,1,1},{3,3,3}};// {{10,20,30},{30,20,10},{10,20,30},{20,10,30},{30,20,10}};//{{10,40,70},{20,50,80},{30,60,90}};// 
		
		System.out.println("Using Recursion :- "+trainingRec(training.length-1, 3, training));
		
		dpTraining = new int[training.length][4];
		System.out.println("Using Memoization :- "+trainingMem(training.length-1, 3, training));
		
		System.out.println("Using Tabulation :- "+trainingTab(training));

		System.out.println("Using Space Optimization :- "+trainingSO(training));

	}

	public static int trainingRec(int d,int t,int[][] training) {
		if(d==0) {
			int max = 0;
			for(int i=0;i<3;i++) {
				if(t!=i) {
					max = Math.max(max,training[0][i]);
				}
			}
			return max;
		}
		int max = 0;
		for(int i=0;i<3;i++) {
			if(t!=i) {
				max = Math.max(max,training[d][i] + trainingRec(d-1, i, training));
			}
		}
		return max;
	}
	
	public static int[][] dpTraining;
	public static int trainingMem(int d,int t,int[][] training) {
		if(dpTraining[d][t]!=0) {
			return dpTraining[d][t];
		}
		if(d==0) {
			int max = 0;
			for(int i=0;i<3;i++) {
				if(t!=i) {
					max = Math.max(max,training[0][i]);
				}
			}
			return dpTraining[d][t] = max;
		}

		int max = 0;
		for(int i=0;i<3;i++) {
			if(t!=i) {
				max = Math.max(max,trainingMem(d-1, i, training) + training[d][i]);
			}
		}
		return dpTraining[d][t]= max;
	}
	
	public static int trainingTab(int[][] training) {
		int[][] dpTrainingTab = new int[training.length][3];
		for(int i=0;i<3;i++) {
			dpTrainingTab[0][i] = training[0][i];
		}
		for(int i=1;i<training.length;i++) {
			for(int j=0;j<3;j++) {
				int max = 0;
				for(int k=0;k<3;k++) {
					if(j!=k) {
						max = Math.max(max, dpTrainingTab[i-1][k]);
					}
				}
				dpTrainingTab[i][j] = training[i][j]+ max;
			}
		}
		int max = 0;
		for(int i=0;i<3;i++) {
			max = Math.max(max, dpTrainingTab[dpTrainingTab.length-1][i]);
		}
		return max;
	}
	
	public static int trainingSO(int[][] training) {
		int[] prev = new int[3];
		for(int i=0;i<3;i++) {
			prev[i] = training[0][i];
		}
		for(int i=1;i<training.length;i++) {
			int[] dpTrainingSO = new int[3];
			for(int j=0;j<3;j++) {
				int max = 0;
				for(int k=0;k<3;k++) {
					if(j!=k) {
						max = Math.max(max, prev[k]);
					}
				}
				dpTrainingSO[j] = training[i][j]+ max;
			}
			prev = dpTrainingSO;
		}
		int max = 0;
		for(int i=0;i<3;i++) {
			max = Math.max(max, prev[i]);
		}
		return max;
	}
	

}
