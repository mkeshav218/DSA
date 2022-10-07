package linkedList;

import java.util.HashSet;

public class RemoveDuplicatesinLinkedList {

	public static void main(String[] args) {
		SinglyLinkedList sortedList = new SinglyLinkedList();
		sortedList.insertAtBeg(1);
		sortedList.insertAtBeg(1);
		sortedList.insertAtEnd(3);
		sortedList.insertAtEnd(4);
		System.out.println("List before removal of duplicates :- ");
		sortedList.printList();
		System.out.println("List after removal of duplicates :- ");
		removeFromSortedList(sortedList.getHead());
		sortedList.printList();
		
		SinglyLinkedList unSortedList = new SinglyLinkedList();
		unSortedList.insertAtBeg(1);
		unSortedList.insertAtBeg(4);
		unSortedList.insertAtEnd(3);
		unSortedList.insertAtEnd(4);
		System.out.println("List before removal of duplicates :- ");
		unSortedList.printList();
		System.out.println("List after removal of duplicates :- ");
		removeFromUnSortedList(unSortedList.getHead());
		unSortedList.printList();
	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(1)
	 * 
	 */
	public static void removeFromSortedList(Node head) {
        Node temp = head;
        while(temp!=null && temp.next!=null){
            while(temp.next!=null && temp.data==temp.next.data){
                temp.next=temp.next.next;
            }
            temp=temp.next;
        }
	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 * 
	 */
	public static void removeFromUnSortedList(Node head) {
        Node temp = head;
        HashSet<Integer> nodes = new HashSet<>();
        nodes.add(temp.data);
        while(temp.next!=null){
            if(!nodes.contains(temp.next.data)){
                nodes.add(temp.next.data);
                temp=temp.next;
            }else{
                temp.next = temp.next.next; 
            }
        }
	}

}
