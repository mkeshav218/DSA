package linkedList;

public class ReverseSinglyLinkedList {
	Node head;
	Node tail;
	int length;
	public ReverseSinglyLinkedList() {
		super();
		this.head = null;
		this.tail = null;
		this.length = 0;
	}


	/***
	 * Reversing a linkedList Iteratively
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(1)
	 * 
	 */
	public void reverseListIteratively() {
		if(head==tail) {
			return;
		}
		Node prev = null;
		Node curr = head;
		Node nextPtr = head.next;
		while(curr!=null) {
			curr.next = prev;
			prev = curr;
			curr = nextPtr;
			if(nextPtr!=null)
				nextPtr = nextPtr.next;
		}
		tail = head;
		head = prev;
	}

	/***
	 * Reversing a linkedList recursively(Method -1)
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 * 
	 */
	public void reverse(Node prev,Node curr,Node nextPtr) {
		if(curr==null) {
			tail=head;
			head=prev;
			return;
		}
		curr.next = prev;
		prev = curr;
		curr = nextPtr;
		if(nextPtr!=null)
			nextPtr = nextPtr.next;
		reverse(prev, curr, nextPtr);
	}
	
	/***
	 * Reversing a linkedList recursively(Method-2)
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 * 
	 */
	public void reverse() {
		tail=head;
		head = reverse(head);
	}

	public Node reverse(Node head) {
		if (head == null || head.next == null)
			return head;

		Node rest = reverse(head.next);
		head.next.next = head;

		head.next = null;
		return rest;
	}
	
	public void createList(SinglyLinkedList list) {
		Node temp = list.getHead();
		while(temp!=null) {
			insertAtEnd(temp.getData());
			temp = temp.next;
		}
	}
	
	public void insertAtEnd(int data) {
		Node newNode = new Node(data);
		if(this.tail==null) {
			this.head = newNode;
		}else {
			this.tail.next = newNode;
		}
		this.tail = newNode;
		this.length++;
	}
	
	public void printList() {
		System.out.println("Elements of the List :- ");
		Node temp = this.head;
		while(temp!=null) {
			System.out.print(temp.getData()+" ");
			temp = temp.getNext();
		}
		System.out.println();
	}
}
