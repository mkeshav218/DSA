package heap;

public class HeapBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heap h = new Heap();
		h.deleteRoot();
		int data = 60;
		for(int i = 0;i<5;i++) {
			h.insert(data);
			h.printHeap();
			data -= 10;
		}
		h.insert(70);
		h.printHeap();
		
//		System.out.println("Delete root testing :- ");
//		h.deleteRoot();
//		h.printHeap();
//		
//		for(int i=h.size/2;i>0;i--) {
//			heapify(h.arr, h.size, i);
//		}

		heapSort(h);
		
		System.out.println("After sorting :- ");
		h.printHeap();
		
	}
	
	/***
	 * 
	 * Time Complexity :- O(nlogn)
	 * 
	 * Build-heap using heapify function (from i=(n/2) to 1)
	 * 
	 * Step 1 :- Swap 1st element with last
	 * Step 2 :- reduce length by 1
	 * Step 3 :- Heapify the first element
	 */
	public static void heapSort(Heap h) {
		int length = h.size;
		while(length>1) {
			int k =  h.arr[1];
			h.arr[1] = h.arr[length];
			h.arr[length] = k;
			length--;
			heapify(h.arr, length, 1);
		}
	}
	
	public static void heapify(int[] arr,int size,int index) {
		int curr = index;
		int left = 2*curr;
		int right = 2*curr + 1;
		
		if(left<=size && arr[left]>arr[curr]) {
			curr = left;
		}
		if(right<=size && arr[right]>arr[curr]) {
			curr = right;
		}
		
		if(curr!=index) {
			int k = arr[curr];
			arr[curr] = arr[index];
			arr[index] = k;
			
			heapify(arr, size, curr);
		}
	}

}



class Heap{
	int[] arr;
	int size;
	public Heap() {
		arr = new int[100];
		size = 0;
	}
	
	//Time Complexity :- O(logn)
	void insert(int data) {
		size++;
		arr[size] = data;
		int index = size;
		
		while(index>1) {
			int p_index = index/2;
			if(arr[p_index]<arr[index]) {
				int k = arr[p_index];
				arr[p_index] = arr[index];
				arr[index] = k;
			}else {
				break;
			}
			index = p_index;
		}
	}
	
	//Time Complexity :- O(logn)
	void deleteRoot() {
		if(size==0) {
			System.out.println("Heap is empty...Nothing to delete");
			return;
		}
		arr[1] = arr[size];
		size--;
		int currentIndex = 1;
		while(currentIndex<size) {
			int leftChildIndex = 2*currentIndex;
			int rightChildIndex = 2*currentIndex+1;
			if(size>=leftChildIndex && arr[leftChildIndex]>arr[currentIndex]) {
				int k = arr[leftChildIndex];
				arr[leftChildIndex] = arr[currentIndex];
				arr[currentIndex]  = k;
				currentIndex = leftChildIndex;
			}else {
				if(size>=rightChildIndex && arr[rightChildIndex]>arr[currentIndex]) {
					int k = arr[rightChildIndex];
					arr[rightChildIndex] = arr[currentIndex];
					arr[currentIndex]  = k;
					currentIndex = rightChildIndex;
				}else {
					break;
				}
			}
		}

	}
	
	void printHeap() {
		for(int i=1;i<=size;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

}