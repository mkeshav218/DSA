package linkedList;

public class SinglyLinkedList {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		list.insertAtBeg(1);
		list.insertAtEnd(2);
		list.printList();
		System.out.println("Head :- " + list.getHead().getData() + ", Tail :- " + list.getTail().getData()+", Length :- " + list.getLength());
		list.insertAtBeg(0);
		System.out.println("Head :- " + list.getHead().getData() + ", Tail :- " + list.getTail().getData()+", Length :- " + list.getLength());
		list.printList();

	}
	

}
