package linkedList;

public class SinglyLinkedList {
	Node head;
	Node tail;
	int length;
	public SinglyLinkedList() {
		super();
		this.head = null;
		this.tail = null;
		this.length = 0;
	}

	public int getAtIndex(int index) {
		if(index<0 || index>=length) {
			return -1;
		}
		Node temp = head;
		int counter= 0;
		while(counter!=index) {
			temp = temp.next;
			counter++;
		}
		return temp.getData();
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
	
	public void insertAtIndex(int data,int index) {
		if(index<0 || index>this.length) {
			return;
		}
		if(index==0) {
			insertAtBeg(data);
		}else if(index==this.length) {
			insertAtEnd(data);
		}else {
			Node newNode = new Node(data);
			Node temp = this.head;
			int counter = 1;
			while(counter!=index) {
				temp = temp.next;
				counter++;
			}
			newNode.next = temp.next;
			temp.next = newNode;
			this.length++;
		}
	}
	
	public void deleteFromBeg() {
		if(this.head!=null) {
			this.head = this.head.next;
			if(this.head==null)
				this.tail = null;
			this.length--;
		}
	}
	
	public void deleteFromEnd() {
		if(this.tail!=null) {
			Node temp = head;
			while(temp!=null && temp.next!=tail) {
				temp = temp.next;
			}
			tail = temp;
			if(tail!=null) {
				tail.next = null;
			}else {
				head = null;
			}
			this.length--;
		}
	}
	
	public void deleteAtIndex(int index) {
		if(index<0 || index>=this.length) {
			return;
		}
		if(index==0) {
			deleteFromBeg();
		}else if(index==this.length-1) {
			deleteFromEnd();
		}else {
			int counter = 1;
			Node temp = this.head;
			while(counter!=index) {
				temp =temp.next;
				counter++;
			}
			temp.next = temp.next.next;
			this.length--;
		}
	}
	
	public void reverse() {
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
	
	
	public Node getHead() {
		return head;
	}

	public Node getTail() {
		return tail;
	}

	public int getLength() {
		return length;
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
