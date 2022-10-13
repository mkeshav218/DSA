package linkedList;
/***
 * 
 * modify the list such that all the even numbers appear before all the odd numbers in the modified list.
 * e.g :- Input :- 17 -> 15 -> 8 -> 9 -> 2 -> 4 -> 6 -> NULL
 * 		  output :- 8 2 4 6 17 15 9
 */
public class SegregateEvenOddNode {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.insertAtBeg(17);
		list.insertAtEnd(15);
		list.insertAtEnd(8);
		list.insertAtEnd(9);
		list.insertAtEnd(2);
		list.insertAtEnd(4);
		list.insertAtEnd(6);
		list.printList();
		
		System.out.println("After segregation :- ");
		list.head = segregate(list.head);
		list.printList();
	}

	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(1)
	 */
    public static Node segregate(Node head){
        Node even = new Node(0);
        Node tail1 = even;
        Node odd = new Node(0);
        Node tail2 = odd;
        Node temp = head;
        while(temp!=null){
            if(temp.data%2==0){
                tail1.next=temp;
                tail1 = tail1.next;
            }else{
                tail2.next=temp;
                tail2 = tail2.next;
            }
            temp = temp.next;
        }
        tail1.next = odd.next;
        tail2.next = null;
        return even.next;
    }
}
