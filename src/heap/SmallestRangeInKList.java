package heap;

/***
 * 
 * Given K sorted lists of integers, KSortedArray[] of size N each.
 * The task is to find the smallest range that includes at least one element from each of the K lists.
 * If more than one such range's are found, return the first such range found.
 * 
 * Time Complexity : O(n * k *log k)
 * Space Complexity  : O(k)
 * 
 */
public class SmallestRangeInKList {

	public static void main(String[] args) {
		int[][] KSortedArray= {{1,3,5,7,9},
                				{0,2,4,6,8},
                				{2,3,5,7,11}};
		int n = 5,k=3;
		int[] res = findSmallestRange(KSortedArray, n, k);
		System.out.println("Min = " + res[0] + ", Max = " + res[1]);
	}
	
	static int[] findSmallestRange(int[][] KSortedArray,int n,int k)
	{
		NodeHeap h = new NodeHeap(k);
	    for(int i=0;i<k;i++){
	        h.insert(KSortedArray[i][0],i,0);
	    }
	    int min = Integer.MAX_VALUE;
	    int max = Integer.MIN_VALUE;
	    int diff = Integer.MAX_VALUE;
	    while(true){
	        Node top = h.removeTop();
	        if(h.max-top.data<diff){
	            diff = h.max-top.data;
	            min = top.data;
	            max = h.max;
	        }
	        if(top.col<n-1){
	            h.insert(KSortedArray[top.row][top.col+1],top.row,top.col+1);
	        }else{
	            break;
	        }
	    }
	    return new int[]{min,max};
	}

}

class NodeHeap{
    Node[] arr;
    int size;
    int max;
    
    public NodeHeap(int size){
        this.arr = new Node[size+1];
        this.size = 0;
        this.max = Integer.MIN_VALUE;
    }
    
    public void insert(int data,int row,int col){
        this.size++;
        arr[size] = new Node(data,row,col);
        modify(size);
        max = Math.max(max,data);
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
    
    public Node removeTop(){
        Node top = arr[1];
        arr[1] = arr[size];
        size--;
        heapify(1);
        return top;
    }
    
    public void heapify(int index){
        int curr = index;
        int left = 2*index;
        int right = 2*index + 1;
        
        if(left<=size && arr[left].data<arr[curr].data)
            curr = left;
        if(right<=size && arr[right].data<arr[curr].data)
            curr = right;
        if(curr!=index){
            swap(curr,index);
            heapify(curr);
        }
    }
    
    private void swap(int i1,int i2){
        Node k = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = k;
    }
}

class Node{
    int data;
    int row;
    int col;
    
    public Node(int data,int row,int col){
        this.data = data;
        this.row = row;
        this.col = col;
    }
}