
public class DecimalToBinary {
	public static void main(String args[]) {
		int n=6;
		int ans=0,i=0;
		while(n!=0) {
			int bit = n&1;
			ans+=(Math.pow(10, i)*bit);
			i++;
			n=n>>1;
		}
		//System.out.println(ans);
		
		int a = 1011;
		ans=0;i=0;
		while(a!=0) {
			int bit = a%10;
			ans+=(Math.pow(2, i)*bit);
			i++;
			a=a/10;
		}
		System.out.println(ans);

	}
}
