package linkedList;

public class ReverseDoublyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList list = new DoublyLinkedList();
		list.insertAtBeg(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		list.insertAtEnd(6);
		list.insertAtEnd(7);
		list.insertAtEnd(8);
		list.insertAtEnd(9);
		list.insertAtEnd(10);
		list.insertAtEnd(11);
		list.insertAtEnd(12);


		list.printList();
		System.out.println("Head = " + list.head.data + ", Tail = " + list.tail.data + ", Length = " + list.length);

		System.out.println("\nReversing DLL Iteratively :- ");
		list.tail = list.head;
		list.head = reverse(list.head);
		list.printList();
		System.out.println("Head = " + list.head.data + ", Tail = " + list.tail.data + ", Length = " + list.length);

		System.out.println("\nReversing DLL By swapping next & prev pointer :- ");
		list.tail = list.head;
		list.head = reverseDLList(list.head);
		list.printList();
		System.out.println("Head = " + list.head.data + ", Tail = " + list.tail.data + ", Length = " + list.length);

		System.out.println("\nReversing DLL By Appending each element of the list to a new Empty List :- ");
		list.tail = list.head;
		list.head = reverseDLL(list.head);
		list.printList();
		System.out.println("Head = " + list.head.data + ", Tail = " + list.tail.data + ", Length = " + list.length);

		System.out.println("**********      Reversing in K group     ************");
		int k = 12;
		System.out.println("K = " + k);
		list.head = reverseInKgroupIteratively(list.head, k);
		list.printList();

		System.out.println("\nK = " + k);
		list.head = reverseInKgroupRecursively(list.head, k);
		list.printList();

	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(1)
	 * 
	 * Reverse DLL iteratively
	 * 
	 */
	public static NodeDLL reverse(NodeDLL head) {
		if(head==null || head.next==null)
			return head;
		NodeDLL prevPtr=null,curr=head,nextPtr = head.next;
		while(curr!=null) {
			curr.next = prevPtr;
			curr.prev = nextPtr;
			prevPtr = curr;
			curr = nextPtr;
			if(nextPtr!=null)
				nextPtr = nextPtr.next;
		}
		return prevPtr;
	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(1)
	 * 
	 * Reverse DLL By swapping next & prev pointer
	 * 
	 */
	public static NodeDLL reverseDLList(NodeDLL head) {
		if(head==null || head.next==null)
			return head;
		NodeDLL curr = head;
		while(curr!=null) {
			NodeDLL temp = curr.prev;
			curr.prev = curr.next;
			curr.next = temp;
			curr = curr.prev;
		}
		while(head.prev!=null){
		    head = head.prev;
		}
		return head;
	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(1)
	 * 
	 * Reverse DLL By Appending each element of the list to a new Empty List
	 * 
	 */
	public static NodeDLL reverseDLL(NodeDLL head) {
		if(head==null || head.next==null)
			return head;
		NodeDLL newHead = new NodeDLL(-1),temp = head,nextPtr=null;
		while(temp!=null) {
			nextPtr = temp.next;
			newHead = insertAtBeg(newHead,temp);
			temp = nextPtr;
		}
		temp = newHead;
		while(temp.next.next!=null) {
			temp = temp.next;
		}
		temp.next = null;
		return newHead;
	}
	
	public static NodeDLL insertAtBeg(NodeDLL head,NodeDLL temp) {
		temp.next = head;
		temp.prev = null;
		head.prev = temp;
		return temp;
	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n/k) = O(n)
	 * 
	 * Each recursive call returns the reversed-Head 
	 * And, If the size of last group is less than K then reverse it and return it
	 * 
	 */
	public static NodeDLL reverseInKgroupRecursively(NodeDLL head,int k) {
		if(head==null || head.next==null)
			return head;
		NodeDLL prevPtr = null,curr=head,nextPtr=head.next;
		int counter = 0;
		while(curr!=null && counter<k) {
			curr.next = prevPtr;
			curr.prev = nextPtr;
			prevPtr = curr;
			curr = nextPtr;
			if(nextPtr!=null) {
				nextPtr = nextPtr.next;
			}
			counter++;
		}
		if (counter >= k) {
            NodeDLL tempHead = reverseInKgroupRecursively(curr, k);
            head.next = tempHead;
            if (tempHead != null)
            	tempHead.prev = head;
		}else {
			prevPtr = reverse(prevPtr);
		}

		return prevPtr;
	}

	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(1)
	 * 
	 * Reverse the list in a group of K size 
	 * And, if size of last group is less than K then maintain its previous state
	 * 
	 */
	public static NodeDLL reverseInKgroupIteratively(NodeDLL head,int k) {
		if(head==null || head.next==null)
			return head;
		NodeDLL prevPtr = null,curr=head,nextPtr=head.next;
		NodeDLL newHead = null,prevHead=null;
		int counter = 0;
		while(curr!=null) {
			if(counter<k) {
				curr.next = prevPtr;
				curr.prev = nextPtr;
				prevPtr = curr;
				curr = nextPtr;
				if(nextPtr!=null) {
					nextPtr = nextPtr.next;
				}
				counter++;
			}else {
				if(newHead==null) {
					newHead = prevPtr;
					prevHead = head;
					head = curr;
				}else {
					prevHead.next = prevPtr;
					prevPtr.prev = prevHead;
					prevHead = head;
					head = curr;
				}
				prevPtr = null;
				counter = 0;
			}
		}
		if(counter<k) {
			prevHead.next = reverse(prevPtr);
		}else {
			if(prevHead!=null)
				prevHead.next = prevPtr;
			else
				newHead = prevPtr;
		}
		return newHead;
	}
}
