package linkedList;

public class Node {
	int data;
	Node next;
	
	public Node() {
	}

	public Node(int data) {
		super();
		this.data = data;
		this.next = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
}

//
//public static Node reverseDLL(Node  head)
//{
//    Node prev = null;
//    Node curr = head;
//    Node nextPtr = head.next;
//    while(curr!=null){
//        curr.next = prev;
//        curr.prev = nextPtr;
//        prev = curr;
//        curr = nextPtr;
//        if(nextPtr!=null){
//            nextPtr = nextPtr.next;
//        }
//    }
//    return prev;
//}
