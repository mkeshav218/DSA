package linkedList;

public class ReverseNodeInEvenLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub [5,2,6,3,9,1,7,3,8,4]
		SinglyLinkedList list = new SinglyLinkedList();
		list.insertAtBeg(5);
		list.insertAtEnd(2);
		list.insertAtEnd(6);
		list.insertAtEnd(3);
		list.insertAtEnd(9);
		list.insertAtEnd(1);
		list.insertAtEnd(7);
		list.insertAtEnd(3);
		list.insertAtEnd(8);
		list.insertAtEnd(4);
		list.printList();
		
		System.out.println("\n********");
		list.head = get(list.head);
		list.printList();
		
		SinglyLinkedList list1 = new SinglyLinkedList();
		list1.insertAtBeg(1);
		list1.insertAtEnd(2);
		list1.insertAtEnd(3);
		list1.insertAtEnd(4);
		list1.insertAtEnd(5);
		list1.insertAtEnd(6);
		list1.insertAtEnd(7);
		list1.insertAtEnd(8);
		list1.insertAtEnd(9);

		list1.printList();
		list1.head = get(list1.head);
		list1.printList();

	}
	
	public static Node get(Node head) {
	    Node prevTail = null,currHead = head;
        int length = 1;
        while(currHead!=null){
            if(length%2==1){
                int currLength = 0;
            	Node tempTail = prevTail;
                Node tempHead = currHead;
                for(int i=0;i<length;i++){
                	if(prevTail!=null) {
                        prevTail.next = currHead;
                	}
                    prevTail = currHead;
                    currHead = currHead.next;
                    currLength++;
                    if(currHead==null)
                        break;
                }
                if(currLength!=length && currLength%2==0){
                    tempTail.next = reverse(tempHead);
                }
            }else{
                if(currHead!=null && currHead.next!=null){
                    int counter = 0;
                    int currLength = 0;
                	Node tempTail = prevTail;
                    Node tempHead = currHead;
                    Node prev=null,curr = currHead,nextPtr = currHead.next;
                    while(curr!=null && counter<length){
                        curr.next = prev;
                        prev = curr;
                        curr = nextPtr;
                        if(nextPtr!=null)
                            nextPtr = nextPtr.next;
                        counter++;
                        currLength++;
                    }
                    if(counter==length || currLength%2==0){
                        prevTail.next = prev;
                        prevTail = currHead;
                        currHead = curr;
                    }else {
                    	if(currLength%2==1) {
                    		tempTail.next = reverse(prev);
                    	}
                    }
                }

            }
            length++;
        }
        return head;
	}
	
	public static void printNodes(Node head) {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
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
