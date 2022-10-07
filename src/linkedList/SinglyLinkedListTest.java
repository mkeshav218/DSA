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


		System.out.println("\nList2 details :- ");
		ReverseSinglyLinkedList list2 = new ReverseSinglyLinkedList();
		list2.insertAtBeg(1);
		list2.insertAtBeg(2);
		list2.insertAtBeg(3);
		list2.insertAtBeg(4);
		list2.insertAtBeg(5);
		list2.insertAtBeg(6);

		list2.printList();
		System.out.println("Head :- " + list2.head.getData() + ", Tail :- " + list2.tail.getData()+", Length :- " + list2.length+"\n");

		
		list2.reverseListIteratively();
		list2.printList();
		System.out.println("Head :- " + list2.head.getData() + ", Tail :- " + list2.tail.getData()+", Length :- " + list2.length+"\n");

		list2.reverseRecursively();
		list2.printList();
		System.out.println("Head :- " + list2.head.getData() + ", Tail :- " + list2.tail.getData()+", Length :- " + list2.length+"\n");

		System.out.println("Reversing in K group Recursively :- ");
		list2.reverseInKgroupRecursively(3);
		list2.printList();
		System.out.println("Head :- " + list2.head.getData() + ", Tail :- " + list2.tail.getData()+", Length :- " + list2.length+"\n");

		list2.reverseInKgroupRecursively(4);
		list2.printList();
		System.out.println("Head :- " + list2.head.getData() + ", Tail :- " + list2.tail.getData()+", Length :- " + list2.length+"\n");
		
		System.out.println("Reversing in K group Iteratively :- ");
		list2.reverseInKgroupIteratively(3);
		list2.printList();
		System.out.println("Head :- " + list2.head.getData() + ", Tail :- " + list2.tail.getData()+", Length :- " + list2.length+"\n");

		list2.reverseInKgroupIteratively(4);
		list2.printList();
		System.out.println("Head :- " + list2.head.getData() + ", Tail :- " + list2.tail.getData()+", Length :- " + list2.length+"\n");
	}
	

}
