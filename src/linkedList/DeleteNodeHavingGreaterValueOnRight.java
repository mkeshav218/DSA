package linkedList;

import java.util.Scanner;

public class DeleteNodeHavingGreaterValueOnRight {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.insertAtBeg(12);
		list.insertAtEnd(15);
		list.insertAtEnd(10);
		list.insertAtEnd(11);
		list.insertAtEnd(5);
		list.insertAtEnd(6);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.printList();
		
		list.head = computeWithOutReversing(list.head);
		list.printList();
		
		list.head = computeWithReversing(list.head);
		list.printList();
	}
    /***
     * 
     * Time Complexity :- O(n2)
     * Space Complexity :- O(1)
     */
    public static Node computeWithOutReversing(Node head)
    {
        Node newHead = new Node(0);
        newHead.next = head;
        if(head.next==null)
            return head;
        Node curr = head.next;
        while(curr!=null){
            Node prev = newHead,temp = newHead.next;
            while(temp!=curr){
                if(temp.data<curr.data){
                    temp = temp.next;
                    prev.next = temp;
                }else{
                    prev = temp;
                    temp = temp.next;
                }
            }
            curr = curr.next;
        }
        return newHead.next;
    }
    
    /***
     * 
     * Time Complexity :- O(n)
     * Space Complexity :- O(1)
     */
    public static Node computeWithReversing(Node head) {
        Node rev = reverse(head);
        int max = rev.data;
        Node prev = rev;
        Node temp = rev.next;
        while(temp!=null){
            if(temp.data<max){
                temp = temp.next;
                prev.next = temp;
            }else{
                max = temp.data;
                prev = temp;
                temp = temp.next;
            }
        }
        return reverse(rev);
    }
    
    public static Node reverse(Node head){
        if(head==null || head.next==null)
            return head;
        Node prev=null,curr=head,nextPtr=head.next;
        while(curr!=null){
            curr.next = prev;
            prev = curr;
            curr = nextPtr;
            if(nextPtr!=null)
                nextPtr = nextPtr.next;
        }
        return prev;
    }

}
