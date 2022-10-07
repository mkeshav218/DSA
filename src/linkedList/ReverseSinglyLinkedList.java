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
	public void reverseRecursively(Node prev,Node curr,Node nextPtr) {
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
		reverseRecursively(prev, curr, nextPtr);
	}
	
	/***
	 * Reversing a linkedList recursively(Method-2)
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 * 
	 */
	public void reverseRecursively() {
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
	
	/***
	 * Reversing a linkedList in K group recursively
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 * 
	 */
	public void reverseInKgroupRecursively(int k) {
		head = reverseK(head, k);
		updateTail(head);
	}
	
	public Node reverseK(Node head,int k) {
		if(head==null || head.next==null)
			return head;
		Node prev = null;
		Node curr = head;
		Node nextPtr = head.next;
		int counter= 0;
		while(curr!=null && counter<k) {
			curr.next = prev;
			prev = curr;
			curr = nextPtr;
			if(nextPtr!=null)
				nextPtr = nextPtr.next;
			counter++;
		}
		head.next = reverseK(curr, k);
		if(counter!=k) {
			return reverse(prev);
		}
		return prev;
	}
	
	/***
	 * Reversing a linkedList in K group Iteratively
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(1)
	 * 
	 */
	public void reverseInKgroupIteratively(int k) {
		if(k>0 && k<=length)
			head = reverseK(k);
	}
	
	public Node reverseK(int k) {
		if(head==null || head.next==null)
			return head;
		Node newHead = null;
		Node prev = null;
		Node curr = head;
		Node nextPtr = head.next;
		int counter= 0;
		while(curr!=null) {
			curr.next = prev;
			prev = curr;
			curr = nextPtr;
			if(nextPtr!=null)
				nextPtr = nextPtr.next;
			counter++;
			if(counter==k) {
				counter = 0;
				if(newHead==null) {
					newHead = prev;
				}else {
					head.next = prev;
					while(head.next!=null) {
						head = head.next;
					}
					tail = head;
				}
				prev = null;
			}
		}
		if(counter!=0) {
			head.next = reverse(prev);
			while(head.next!=null) {
				head = head.next;
			}
			tail = head;
		}
		return newHead;
	}
	
	public void insertAtBeg(int data) {
		Node newNode = new Node(data);
		if(this.head==null) {
			this.tail = newNode;
		}else {
			newNode.next = this.head;
		}
		this.head = newNode;
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
	
	public void updateTail(Node head) {
		if(head==null || head.next==null) {
			tail = head;
		}
		Node temp = head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		tail = temp;
	}
}
