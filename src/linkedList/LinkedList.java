package linkedList;

public class LinkedList {
	Node head;
	Node tail;
	int length;
	public LinkedList() {
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
