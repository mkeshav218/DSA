package linkedList;

public class NthNodeFromEndOfList {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.insertAtBeg(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		list.printList();
		
		for(int i=6;i>=1;i--) {
			System.out.println(i+"th Node from last = " + getNthFromLast(list.head, i));
		}
		System.out.println();
		for(int i=6;i>=1;i--) {
			System.out.println(i+"th Node from last = " + getNthFromLastInSingleTraversal(list.head, i));
		}
	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(1)
	 * 
	 */
	public static int getNthFromLast(Node head,int n) {
		if(head.next==null){
            if(n==1)
                return head.data;
            else
                return -1;
        }
    	Node fast=head.next;
    	int count = 2;
    	while(fast!=null && fast.next!=null){
    	    fast = fast.next.next;
    	    count+=2;
    	}
    	if(fast==null)
    	    count--;
    	fast = head;
    	int counter = count-n;
    	if(counter<0)
    	    return -1;
    	while(counter>0){
    	    fast = fast.next;
    	    counter--;
    	}
    	return fast.data;
	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(1)
	 * 
	 */
    public static int getNthFromLastInSingleTraversal(Node head, int n)
    {
        Node p1 = head,p2=head;
        int count=0;
        while(count<n && p2!=null){
            p2 = p2.next;
            count++;
        }
        if(p2==null && count<n){
            return -1;
        }
        while(p2!=null){
            p2 = p2.next;
            p1 = p1.next;
        }
        return p1.data;
    }

}
