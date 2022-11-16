package heap;

/***
 * 
 * Given an array of integers. Find the K-th largest sum of contiguous subarray within the array of numbers 
 * that has both negative and positive numbers.
 * 
 * Input: a[] = {20, -5, -1}, K = 3
 * Output: 14
 * Explanation: All sum of contiguous subarrays are (20, 15, 14, -5, -6, -1) 
 * so the 3rd largest sum is 14.
 * 
 * Time Complexity :- O(N2 log K) 
 * Space Complexity :- O(N)
 *
 */
public class KthLargestSumContiguousSubarray {

	public static void main(String[] args) {
		int[] Arr = {2,6,4,1};
		int K = 3;
		int N = Arr.length;
		ContiguosMinHeap h = new ContiguosMinHeap(K);
        for(int i=0;i<N;i++){
            int sum = 0;
            for(int j=i;j<N;j++){
                int num = Arr[j];
                sum += num;
                if(h.size<K)
                    h.insert(sum);
                else{
                    if(h.arr[1]<sum){
                        h.deleteTop();
                        h.insert(sum);
                    }
                }
            }
        }
        System.out.println("Res = " + h.arr[1]);
	}

}

class ContiguosMinHeap{
    int[] arr;
    int size;
    public ContiguosMinHeap(int size){
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
        int curr = index;
        int left = 2*index;
        int right = 2*index + 1;
        if(left<=size && arr[left]<arr[curr])
            curr = left;
        if(right<=size && arr[right]<arr[curr])
            curr = right;
        if(curr!=index){
            swap(curr,index);
            heapify(curr);
        }
    }
    
    public void modify(int index){
        if(index<=1)
            return;
        int parent = index/2;
        if(arr[parent]>arr[index]){
            swap(parent,index);
            modify(parent);
        }
    }
    
    public void swap(int i1,int i2){
        int k = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = k;
    }
}