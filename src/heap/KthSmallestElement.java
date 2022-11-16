package heap;

/***
 * 
 * Initialize Max-Heap 
 * Until size of Max-heap is less than k, insert element into it
 * once the size is >= k, 
 * 		check is top element is > element of arr, if true delete top element & insert element of array
 *  Top element of Max heap will be the Kth smallest element.
 *
 */
public class KthSmallestElement {

	public static void main(String[] args) {
		int[] nums = {3,2,1,5,6,4};
		for(int k=1;k<=6;k++) {
			KSizeMaxHeap h = new KSizeMaxHeap(k);
	        for(int i:nums){
	            if(h.size<k){
	                h.insert(i);
	            }else{
	                if(h.arr[1]>i){
	                    h.deleteTop();
	                    h.insert(i);
	                }
	            }
	        }
	        System.out.println(k+"th smallest element :- " + h.arr[1]);
		}
	}

}

class KSizeMaxHeap{
    int[] arr;
    int size;

    public KSizeMaxHeap(int size){
        this.arr = new int[size+1];
        this.size = 0;
    }

    public void insert(int data){
        this.size++;
        arr[size] = data;
        modify(size);
    }
    
    public void deleteTop(){
        arr[1] = arr[size];
        this.size--;
        heapify(1);
    }
    
    public void heapify(int index){
        int left = 2*index;
        int right = 2*index+1;
        int curr = index;
        if(left<=size && arr[left]>arr[curr])
            curr = left;
        if(right<=size && arr[right]>arr[curr])
            curr = right;
        if(index!=curr){
            swap(index,curr);
            heapify(curr);
        }
    }
    
    public void modify(int index){
        if(index<=1)
            return;
        int parent = index/2;
        if(arr[parent]<arr[index]){
            swap(parent,index);
            modify(parent);
        }
    }
    
    public void swap(int index1,int index2){
        int k = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = k;
    }
}