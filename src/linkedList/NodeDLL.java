package linkedList;

public class NodeDLL {
	int data;
	NodeDLL prev;
	NodeDLL next;
	
	public NodeDLL() {
	}

	public NodeDLL(int data) {
		super();
		this.data = data;
		this.prev = null;
		this.next = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public NodeDLL getPrev() {
		return prev;
	}

	public void setPrev(NodeDLL prev) {
		this.prev = prev;
	}

	public NodeDLL getNext() {
		return next;
	}

	public void setNext(NodeDLL next) {
		this.next = next;
	}	
}
