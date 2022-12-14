package heap;

/***
 * 
 * Given an input stream of N integers. The task is to insert these numbers into a new stream and 
 * find the median of the stream formed by each insertion of X to the new stream.
 * 
 * Time Complexity : O(nlogn)
 * Space Complexity  : O(n)
 * 
 * In sorted list
 * if sizeof(list) is odd, median = middle element
 * else median = avg of n/2th and ((n/2)+1)th element
 * 
 */
public class MedianInStreamOfIntegers {

	public static void main(String[] args) {
		int N = 10;//4;
		int[] X = {9384,887,2778,6916,7794,8336,5387,493,6650,1422};//{5,15,1,3};
		
		MaxHeap maxHeap = new MaxHeap(N);
		MinHeap minHeap = new MinHeap(N);
		
		double median = X[0];
		maxHeap.insert(X[0]);
		System.out.println("Median = " + median);
		
		for(int i=1;i<N;i++) {
			int data = X[i];
			if(maxHeap.size==minHeap.size) {
				if(data>median) {
					minHeap.insert(data);
					median = minHeap.arr[1];
				}else {
					maxHeap.insert(data);
					median = maxHeap.arr[1];
				}
			}else if(maxHeap.size>minHeap.size) {
				if(data>median) {
					minHeap.insert(data);
				}else {
					int top = maxHeap.removeTop();
					minHeap.insert(top);
					maxHeap.insert(data);
				}
				median = ((double)maxHeap.arr[1]+minHeap.arr[1])/2;
			}else {
				if(data<median) {
					maxHeap.insert(data);
				}else {
					int top = minHeap.removeTop();
					maxHeap.insert(top);
					minHeap.insert(data);
				}
				median = ((double)maxHeap.arr[1]+minHeap.arr[1])/2;
			}
			System.out.println("Median = " + median);
		}
	}

}

class MaxHeap{
	int[] arr;
	int size;
	
	public MaxHeap(int size) {
		this.arr = new int[size+1];
		this.size = 0;
	}
	
	public void insert(int data) {
		size++;
		arr[size] = data;
		
		int index = size;
		while(index>1) {
			int pIndex = index/2;
			if(arr[pIndex]<arr[index]) {
				swap(pIndex,index);
				index = pIndex;
			}else {
				break;
			}
		}
	}
	
	public int removeTop() {
		int top = arr[1];
		arr[1] = arr[size];
		size--;
		heapify(1);
		return top;
	}
	
	private void heapify(int index) {
		int left = 2*index;
		int right = 2*index + 1;
		int curr = index;
		if(left<=size && arr[left]>arr[curr]) {
			curr = left;
		}
		if(right<=size && arr[right]>arr[curr]) {
			curr = right;
		}
		if(curr!=index) {
			swap(curr,index);
			heapify(curr);
		}
	}
	
	private void swap(int i1,int i2) {
		int k = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = k;
	}
}

class MinHeap{
	int[] arr;
	int size;
	
	public MinHeap(int size) {
		this.arr = new int[size+1];
		this.size = 0;
	}
	
	public void insert(int data) {
		size++;
		arr[size] = data;
		int index = size;
		while(index>1) {
			int pIndex = index/2;
			if(arr[pIndex]>arr[index]) {
				swap(pIndex,index);
				index = pIndex;
			}else {
				break;
			}
		}
	}
	
	public int removeTop() {
		int top = arr[1];
		arr[1] = arr[size];
		size--;
		heapify(1);
		return top;
	}
	
	private void heapify(int index) {
		int curr = index;
		int left = 2*index;
		int right = 2*index + 1;
		
		if(left<=size && arr[left]<arr[curr]) {
			curr = left;
		}
		if(right<=size && arr[right]<arr[curr]) {
			curr = right;
		}
		if(curr!=index) {
			swap(curr,index);
			heapify(curr);
		}
	}
	
	private void swap(int i1,int i2) {
		int k = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = k;
	}
}
