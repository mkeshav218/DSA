package linkedList;

public class DoublyLinkedList {
	NodeDLL head;
	NodeDLL tail;
	int length;
	
	public DoublyLinkedList() {
		super();
		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	
	public int getAtIndex(int index) {
		if(index<0 || index>=this.length) {
			return -1;
		}
		NodeDLL temp = head;
		while(index>0) {
			temp = temp.next;
			index--;
		}
		return temp.data;
	}
	
	public void insertAtBeg(int data) {
		NodeDLL node = new NodeDLL(data);
		if(head==null) {
			head = node;
			tail = node;
		}else {
			node.next = head;
			head.prev = node;
			head = node;
		}
		this.length++;
	}
	
	public void insertAtEnd(int data) {
		NodeDLL node = new NodeDLL(data);
		if(tail==null) {
			head = node;
			tail = node;
		}else {
			tail.next = node;
			node.prev = tail;
			tail = node;
		}
		this.length++;
	}
	
	public void printList() {
		NodeDLL temp = head;
		System.out.println("Elements of the DLL :- ");
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	
}
