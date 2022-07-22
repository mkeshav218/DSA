package graph;

public class test {

	public static void main(String[] args) {
		int n  = 5;
		addEdge(n);
		System.out.println(n);
	}
	
	static void addEdge(int n) {
		n = 10;
	}
	
	static void updateElem(int[] a) {
		a[3] = 100;
		printAdjList(a);
	}
	
	static void printAdjList(int[] a) {
		System.out.println("****** Array Elements ******");
		for(int i:a) {
			System.out.print(i+" ");
		}
		System.out.println("\n");
	}
	

}
