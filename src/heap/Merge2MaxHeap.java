package heap;
/***
 * 
 * Given two binary max heaps as arrays, merge the given heaps to form a new max heap.
 *
 */
public class Merge2MaxHeap {

	public static void main(String[] args) {
		int[] a = {10, 5, 6, 2};
		int[] b = {12, 7, 9};
		MHeap h = new MHeap(a.length+b.length);
	    h.insert(a);
	    h.insert(b);
	    h.buildMaxHeap();
	    System.out.println("After merging heaps :- ");
	    h.print();
	}

}

class MHeap{
    int[] arr;
    int size;
    
    public MHeap(int size){
        this.arr = new int[size];
        this.size = 0;
    }
    
    public void insert(int[] data){
        for(int i:data)
            arr[size++] = i;
    }
    
    public void buildMaxHeap(){
        for(int i=(size/2)-1;i>=0;i--)
            heapify(i);
    }
    
    public void heapify(int index){
        int left = 2*index+1;
        int right = 2*index + 2;
        int curr = index;
        
        if(left<size && arr[left]>arr[curr]) {
			curr = left;
		}
		if(right<size && arr[right]>arr[curr]) {
			curr = right;
		}
		
		if(curr!=index) {
			int k = arr[curr];
			arr[curr] = arr[index];
			arr[index] = k;
			
			heapify(curr);
		}

    }
    
    public void print(){
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}