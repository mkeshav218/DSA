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
		list.insertAtBeg(0);

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

}
