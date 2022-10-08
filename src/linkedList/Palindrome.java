package linkedList;

public class Palindrome {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.insertAtBeg(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(2);
		list.insertAtEnd(1);
		list.printList();
		System.out.println("Is Palindrome :- " + isPalindrome(list.head));
	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(1)
	 * 
	 * Reverse the first half of the list & compare it with the second half.
	 * 
	 */
	public static boolean isPalindrome(Node head) 
    {
        Node prev = null;
        Node curr = head;
        Node slowPtr = head;
        Node fastPtr = head;
        while(fastPtr!=null && fastPtr.next!=null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            curr.next = prev;
            prev = curr;
            curr = slowPtr;
        }
        if(fastPtr!=null){     // i.e No of nodes in the list is odd
            curr = curr.next;
        }
        while(curr!=null){
            if(curr.data!=prev.data){
                return false;
            }
            curr = curr.next;
            prev = prev.next;
        }
        return true;
    }  
	

}
