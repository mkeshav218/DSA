package linkedList;

public class SinglyLinkedListTest {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList list = new SinglyLinkedList();
		list.insertAtBeg(1);
		list.insertAtEnd(2);
		list.insertAtBeg(0);
		list.printList();
		System.out.println("Head :- " + list.getHead().getData() + ", Tail :- " + list.getTail().getData()+", Length :- " + list.getLength()+"\n");

		list.insertAtIndex(-1, 0);
		list.printList();
		System.out.println("Head :- " + list.getHead().getData() + ", Tail :- " + list.getTail().getData()+", Length :- " + list.getLength()+"\n");

		list.insertAtIndex(3, 4);
		list.printList();
		System.out.println("Head :- " + list.getHead().getData() + ", Tail :- " + list.getTail().getData()+", Length :- " + list.getLength()+"\n");

		list.insertAtIndex(10, 2);
		list.printList();
		System.out.println("Head :- " + list.getHead().getData() + ", Tail :- " + list.getTail().getData()+", Length :- " + list.getLength()+"\n");

		list.deleteFromBeg();
		list.printList();
		System.out.println("Head :- " + list.getHead().getData() + ", Tail :- " + list.getTail().getData()+", Length :- " + list.getLength()+"\n");

		list.deleteFromEnd();
		list.printList();
		System.out.println("Head :- " + list.getHead().getData() + ", Tail :- " + list.getTail().getData()+", Length :- " + list.getLength()+"\n");

		list.deleteAtIndex(0);
		list.printList();
		System.out.println("Head :- " + list.getHead().getData() + ", Tail :- " + list.getTail().getData()+", Length :- " + list.getLength()+"\n");

		list.deleteAtIndex(2);
		list.printList();
		System.out.println("Head :- " + list.getHead().getData() + ", Tail :- " + list.getTail().getData()+", Length :- " + list.getLength()+"\n");

		list.insertAtBeg(5);
		list.insertAtBeg(4);
		list.insertAtBeg(3);
		list.insertAtBeg(2);
		list.printList();
		System.out.println("Head :- " + list.getHead().getData() + ", Tail :- " + list.getTail().getData()+", Length :- " + list.getLength()+"\n");

		list.deleteAtIndex(2);
		list.printList();
		System.out.println("Head :- " + list.getHead().getData() + ", Tail :- " + list.getTail().getData()+", Length :- " + list.getLength()+"\n");

		list.reverse();
		list.printList();
		System.out.println("Head :- " + list.getHead().getData() + ", Tail :- " + list.getTail().getData()+", Length :- " + list.getLength()+"\n");

	}
	

}
