package dp;

public class NinjaTraining {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] training = {{10,40,70},{20,50,80},{30,60,90}};//{{1,2,5},{3,1,1},{3,3,3}};
		traverse(2, 3, training);
		System.out.println(res+" "+total);
	}

	public static void traverse(int d,int t,int[][] training) {
		System.out.println(d+" "+t);
		if(d==0) {
			int max = 0;
			for(int i=0;i<3;i++) {
				if(t!=i) {
					max = Math.max(max,training[0][i]);
				}
			}
			total += max;
			res = Math.max(res, total);
			System.out.println(res+" "+total);
			total -= max;
			return;
		}
		for(int i=0;i<3;i++) {
			if(t!=i) {
				total += training[d][i];
				traverse(d-1, i, training);
				total -= training[d][i];
			}
		}
	}
	
	
	public static int res = 0;
	public static int total = 0;

}
