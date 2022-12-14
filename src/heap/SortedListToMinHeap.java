package heap;

public class SortedListToMinHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6,7};
		HNode root = build(nums, 0, nums.length-1);
		preOrder(root);
		System.out.println();
		inOrder(root);
		System.out.println();
		postOrder(root);
	}
	
	public static HNode build(int[] nums,int start,int end) {
		int size = end-start;
		if(size>2) {
			HNode node = new HNode(nums[start]);
			int half = (size+1)/2;
			node.left = build(nums,start+1,start+half);
			node.right = build(nums,start+half+1,end);
			return node;
		}else if(size==2) {
			HNode node = new HNode(nums[start]);
			node.left = new HNode(nums[start+1]);
			node.right = new HNode(nums[start+2]);
			return node;
		}else if(size==1) {
			HNode node = new HNode(nums[start]);
			node.left = new HNode(nums[start+1]);
			return node;
		}else {
			return null;
		}
	}
	
	private static void preOrder(HNode root) {
		if(root==null)
			return;
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	private static void inOrder(HNode root) {
		if(root==null)
			return;
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	
	private static void postOrder(HNode root) {
		if(root==null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}

}

class HNode{
	int data;
	HNode left;
	HNode right;
	
	public HNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
