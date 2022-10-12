package linkedList;

public class Sort_0_1_2 {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.insertAtBeg(1);
		list.insertAtEnd(0);
		list.insertAtEnd(1);
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(2);
		list.insertAtEnd(0);
		list.insertAtEnd(2);
		list.printList();
		
		System.out.println("\nAfter rearranging links of 0, 1 & 2 :-");
		list.head = rearrangeLinks(list.head);
		list.printList();
		
		System.out.println("\nAfter rearranging data of list :-");
		list.head = rearrangeData(list.head);
		list.printList();
	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(1)
	 * 
	 */
	public static Node rearrangeLinks(Node head)
    {
        Node headA = new Node(-1);
        Node headB = new Node(-1);
        Node headC = new Node(-1);
        Node temp = head,tempA=headA,tempB=headB,tempC=headC;
        while(temp!=null){
            if(temp.data==0){
                tempA.next = temp;
                tempA = temp;
            }else if(temp.data==1){
                tempB.next = temp;
                tempB = temp;
            }else{
                tempC.next = temp;
                tempC = temp;
            }
            temp = temp.next;
        }
        if(headB.next!=null){
            tempA.next = headB.next;
        }else{
            tempA.next = headC.next;
        }
        tempB.next = headC.next;
        tempC.next = null;
        head = headA.next;
        
        return head;
    }

	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(1)
	 * 
	 */
	public static Node rearrangeData(Node head)
    {
        int countA=0,countB=0,countC=0;
        Node temp=head;
        while(temp!=null){
            if(temp.data==0){
                countA++;
            }else if(temp.data==1){
                countB++;
            }else{
                countC++;
            }
            temp =temp.next;
        }
        temp = head;
        while(countA>0){
            temp.data = 0;
            countA--;
            temp = temp.next;
        }
        while(countB>0){
            temp.data = 1;
            countB--;
            temp = temp.next;
        }
        while(countC>0){
            temp.data = 2;
            countC--;
            temp = temp.next;
        }
        return head;
    }
}
