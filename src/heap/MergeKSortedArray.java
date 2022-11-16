package heap;

import java.util.ArrayList;
/***
 * 
 * Given K sorted arrays arranged in the form of a matrix of size K*K. 
 * The task is to merge them into one sorted array.
 *
 * Time Complexity : O(n2*Log(n))
 * Space Complexity : O(n2)
 */
public class MergeKSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {{1,2,3,4},{2,2,3,4},{5,5,6,6},{7,8,9,9}}; //{{1,2,3},{4,5,6},{7,8,9}};
		int K = 4;
		
		ArrayList<Integer> res = new ArrayList<>();
		MergeUsingMinHeap h = new MergeUsingMinHeap(K);
        for(int i=0;i<K;i++){
            h.insert(arr[i][0],i,0);
        }
        while(h.size>0){
        	HeapNode node = h.removeTop();
            res.add(node.data);
            int row = node.row;
            int col = node.col;
            if(col+1<K){
                h.insert(arr[row][col+1],row,col+1);
            }
        }
        
        System.out.println("After merging :- " + res);
        
		
	}

}

class MergeUsingMinHeap{
	HeapNode[] arr;
    int size;

    
    public MergeUsingMinHeap(int size){
        this.arr = new HeapNode[size+1];
        this.size = 0;
    }
    
    public void insert(int data,int row,int col){
        this.size++;
        arr[size] = new HeapNode(data,row,col);
        modify(size);
    }
    
    public HeapNode removeTop(){
    	HeapNode num = arr[1];
        arr[1] = arr[size];
        this.size--;
        heapify(1);
        return num;
    }
    
    public void heapify(int index){
        int curr = index;
        int left = 2*index;
        int right = 2*index + 1;
        if(left<=size && arr[left].data<arr[curr].data)
            curr= left;
        if(right<=size && arr[right].data<arr[curr].data)
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
        if(arr[parent].data>arr[index].data){
            swap(parent,index);
            modify(parent);
        }
    }
    
    public void swap(int i1,int i2){
    	HeapNode k = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = k;
    }
}

class HeapNode{
	int data;
	int row;
	int col;
	
	public HeapNode(int data, int row, int col) {
		super();
		this.data = data;
		this.row = row;
		this.col = col;
	}
}