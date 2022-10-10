package linkedList;

public class MergeSort {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.insertAtBeg(8);
		list.insertAtEnd(2);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		list.insertAtEnd(3);
		list.insertAtEnd(1);
		list.insertAtEnd(9);
		list.printList();
		
		list.head = mergeSortLinkedList(list.head);
		list.printList();
	}
	
	/***
	 * 
	 * Time Complexity :- O(nlogn)
	 * Space Complexity :- O(n)
	 * 
	 * Find mid of the linked-list
	 * Break the linked-List into two half
	 * Merge the two half
	 * 
	 */
	public static Node mergeSortLinkedList(Node head) {
		if(head==null || head.next==null)
			return head;
		Node mid = midNode(head);
		Node left = head;
		Node right = mid.next;
		mid.next = null;
		
		left = mergeSortLinkedList(left);
		right = mergeSortLinkedList(right);
		return merge(left,right);
	}
	
	public static Node merge(Node left,Node right) {
		if(left==null)
			return right;
		if(right==null)
			return left;
		Node newHead = new Node(-1);
		Node temp = newHead;
		Node t1 = left,t2 = right;
		while(t1!=null && t2!=null) {
			if(t1.data<t2.data) {
				temp.next = t1;
				temp = t1;
				t1 =t1.next;
			}else {
				temp.next = t2;
				temp = t2;
				t2 =t2.next;
			}
		}
		if(t1!=null) {
			temp.next = t1;
		}
		if(t2!=null) {
			temp.next = t2;
		}
		return newHead.next;
	}
	
	public static Node midNode(Node head) {
		if(head==null) {
			return head;
		}
		Node slowPtr = head;
		Node fastPtr = head.next;
		while(fastPtr!=null && fastPtr.next!=null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
		}
		return slowPtr;
	}
}
