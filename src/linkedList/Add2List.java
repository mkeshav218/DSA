package linkedList;

public class Add2List {

	public static void main(String[] args) {
		SinglyLinkedList list1 = new SinglyLinkedList();
		list1.insertAtBeg(9);
		list1.insertAtEnd(9);
		list1.insertAtEnd(9);
		list1.insertAtEnd(9);
		
		SinglyLinkedList list2 = new SinglyLinkedList();
		list2.insertAtBeg(9);
		list2.insertAtBeg(9);

//		list1.head = addTwoLists(list1.getHead(), list2.getHead());
//		list1.printList();

//		list1.head = addTwoLists1(list1.head, list2.head);
//		list1.printList();
		
		list1.head = addTwoLists2(list1.head, list2.head);
		list1.printList();

	}
	
	public static Node addTwoLists(Node first, Node second){
	        first = reverse(first);
	        second = reverse(second);
	        Node temp1=first,temp2=second;
	        int carry = 0;
	        while(temp1.next!=null && temp2.next!=null){
	            int data = temp1.data + temp2.data + carry;
	            temp1.data = data%10;
	            carry = data/10;
	            temp1 = temp1.next;
	            temp2 = temp2.next;
	        }
	        while(temp1!=null){
	            int data = 0;
	            if(temp2!=null){
	                data = temp1.data + temp2.data +carry;
	                temp2 = temp2.next;
	            }else {
	                data = temp1.data + carry;
	            }
	            temp1.data = data%10;
	            carry = data/10;
	            temp1 = temp1.next;
	        }
	        if(temp2!=null){
	            temp1 = first;
	            while(temp1.next!=null){
	                temp1 = temp1.next;
	            }
	            temp1.next = temp2;
	            temp1 = temp2;
	            while(temp1!=null){
	                int data = temp1.data + carry;
	                temp1.data = data%10;
	                carry = data/10;
	                temp1 = temp1.next;
	            }
	        }
	        if(carry==1){
	            temp1 = first;
	            while(temp1.next!=null){
	                temp1 = temp1.next;
	            }
	            temp1.next = new Node(1);
	        }
	        first = reverse(first);
			return first;
	    }
	    
	public static Node addTwoLists1(Node first, Node second){
	        Node temp1 = reverse(first);
	        Node temp2 = reverse(second);
	        Node head1 = temp1;
	        Node head2 = temp2;
	        while(temp1.next!=null && temp2.next!=null){
	            temp1 = temp1.next;
	            temp2 = temp2.next;
	        }
	        while(temp1.next!=null){
	            temp2.next = new Node(0);
	            temp1 = temp1.next;
	            temp2 = temp2.next;
	        }
	        while(temp2.next!=null){
	            temp1.next = new Node(0);
	            temp1 = temp1.next;
	            temp2 = temp2.next;
	        }
	        temp1 = reverse(head1);
	        temp2 = reverse(head2);
	        int ans = add(temp1,temp2);
	        if(ans==1){
	            Node newNode = new Node(1);
	            newNode.next = temp1;
	            return newNode;
	        }else{
	            return temp1;
	        }
	    }
	    
    /***
     * 
     *  Time Complexity :- O(max(m,n))
     *  Space Complexity :- O(max(m,n))
     * 
     *  Add preceeding zeroes to make length of both linked-list equal.
     * 	This approach use recursion to add elements.
     */
    public static Node addTwoLists2(Node first, Node second){
        Node temp1 = first;
        Node temp2 = second;
        while(temp1!=null && temp2!=null){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        if(temp1==null){
            while(temp2!=null){
                temp2 = temp2.next;
                Node newNode = new Node(0);
                newNode.next = first;
                first = newNode;
            }
        }
        if(temp2==null){
            while(temp1!=null){
                temp1 = temp1.next;
                Node newNode = new Node(0);
                newNode.next = second;
                second = newNode;
            }
        }
        int carry = add(first,second);
        if(carry==1){
            Node newNode = new Node(1);
            newNode.next = first;
            return newNode;
        }
        return first;
    }
    
    public static int add(Node first,Node second){
        if(first==null)
            return 0;
        int carry = add(first.next,second.next);
        int res = first.data + second.data + carry;
        first.data = res%10;
        return res/10;
    }

    
    public static Node reverse(Node head){
        if(head==null || head.next==null)
            return head;
        Node prev = null;
        Node curr = head;
        Node nextPtr = head.next;
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
