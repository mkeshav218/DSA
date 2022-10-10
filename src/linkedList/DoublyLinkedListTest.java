package linkedList;

public class DoublyLinkedListTest {

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.insertAtBeg(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		
		list.printList();
		System.out.println("Head = " + list.head.data + ", Tail = " + list.tail.data + ", Length = " + list.length);

	}

}
