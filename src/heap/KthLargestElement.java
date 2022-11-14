package heap;

/***
 * 
 * Initialize Min-Heap 
 * Until size of min-heap is less than k, insert element into it
 * once the size is >= k, 
 * 		check is top element is < element of arr, if true delete top element & insert element of array
 *  Top element of min heap will be the Kth largest element.
 *
 */
public class KthLargestElement {

	public static void main(String[] args) {
		int[] nums = {3,2,1,5,6,4};
		for(int k=1;k<=6;k++) {
			KSizeHeap h = new KSizeHeap(k);
	        for(int i:nums){
	            if(h.size<k){
	                h.insert(i);
	            }else{
	                if(h.arr[1]<i){
	                    h.deleteRoot();
	                    h.insert(i);
	                }
	            }
	        }
	        System.out.println(k+"th largest element :- " + h.arr[1]);
		}
	}

}

class KSizeHeap{
    int[] arr;
    int size;

    public KSizeHeap(int size){
        this.arr = new int[size+1];
        this.size = 0;
    }

    public void insert(int data){
        size++;
        arr[size] = data;
        heapify(size);
    }

    public void heapify(int index){
        if(index<=1)
            return;
        int parent = index/2;
        if(arr[parent]>arr[index]){
            int k = arr[parent];
            arr[parent] = arr[index];
            arr[index] = k;
            heapify(parent);
        }
    }

    public void deleteRoot(){
        arr[1] = arr[size];
        size--;
        modify(1);
    }

    public void modify(int index){
        int curr = index;
        int left = 2*index;
        int right = 2*index + 1;
        if(left<=size && arr[left]<arr[curr])
            curr = left;
        if(right<=size && arr[right]<arr[curr])
            curr = right;
        if(curr!=index){
            int k = arr[index];
            arr[index] = arr[curr];
            arr[curr] = k;
            modify(curr);
        }
    }
}