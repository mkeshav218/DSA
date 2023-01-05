package dp;

import java.util.Arrays;

public class NinjaTraining {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] training = {{10,20,30},{30,20,10},{10,20,30},{20,10,30},{30,20,10}};//{{10,40,70},{20,50,80},{30,60,90}};// {{1,2,5},{3,1,1},{3,3,3}};// 
		trainingRec(training.length-1, 3, training,0);
		System.out.println(res+" ");
		
		dpTraining = new int[training.length][4];
		System.out.println(trainingMem(training.length-1, 3, training, 0));
		for(int i=0;i<training.length;i++)
			System.out.println(Arrays.toString(dpTraining[i]));

	}

	public static int res = 0;
	public static void trainingRec(int d,int t,int[][] training,int total) {
		if(d==0) {
			int max = 0;
			for(int i=0;i<3;i++) {
				if(t!=i) {
					max = Math.max(max,training[0][i]);
				}
			}
			total += max;
			res = Math.max(res, total);
			return;
		}
		for(int i=0;i<3;i++) {
			if(t!=i) {
				total += training[d][i];
				trainingRec(d-1, i, training,total);
				total -= training[d][i];
			}
		}
	}
	
	public static int[][] dpTraining;
	public static int trainingMem(int d,int t,int[][] training,int total) {
		if(d<=2 && t<=2 && dpTraining[d][t]!=0) {
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
				max = Math.max(max,trainingMem(d-1, i, training,total) + training[d][i]);
			}
		}
		return dpTraining[d][t]= max;
	}
	

}
