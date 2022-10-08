package linkedList;

public class IntersectionOf2List {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.insertAtBeg(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		Node intersectPoint = list.tail;
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		list.insertAtEnd(6);
		
		SinglyLinkedList list1 = new SinglyLinkedList();
		list1.insertAtBeg(10);
		list1.insertAtEnd(20);
		list1.insertAtEnd(30);
		list1.insertAtEnd(40);
		list1.tail.next = intersectPoint;
		list1.tail = list.tail;
		
		list.printList();
		list1.printList();
		
//		Node commonNode = getIntersectionNode(list.head, list1.head);
//		System.out.println("Common Node :- "+ commonNode.getData());
		
//		Node commonNode = getIntersectionNode1(list.head, list1.head);
//		System.out.println("Common Node :- "+ commonNode.getData());
		
		Node commonNode = getIntersectionNode2(list.head, list1.head);
		System.out.println("Common Node :- "+ commonNode.getData());
	}
	
	/***
	 * 
	 * Time Complexity :- O(m+n)
	 * Space Complexity :- O(1)
	 * 
	 * Add preceeding zero to make the size of both list equal.
	 * Start traversing from head of both the list & compare node one by one.
	 * Return when node matches.
	 * 
	 */
	public static Node getIntersectionNode(Node headA, Node headB) {
        Node t1 = headA,t2 = headB;
        while(t1.next!=null && t2.next!=null){
            t1 = t1.next;
            t2 = t2.next;
        }
        if(t1!=null){
            while(t1!=null){
                t1 = t1.next;
                Node newNode = new Node(-1001);
                newNode.next = headB;
                headB = newNode;
            }
        }
        if(t2!=null){
            while(t2!=null){
                t2 = t2.next;
                Node newNode = new Node(-1001);
                newNode.next = headA;
                headA = newNode;
            }
        }
        t1 = headA;
        t2 = headB;
        while(t1!=null){
            if(t1==t2){
                return t1;
            }
            t1 = t1.next;
            t2 = t2.next;
        }
        return null;
    }

	/***
	 * 
	 * Time Complexity :- O(m+n)
	 * Space Complexity :- O(1)
	 * 
	 * Find length of both list.
	 * Take 2 ptr & assign it to head of both list.
	 * Move the ptr of bigger list by absolute difference of length of both the list.
	 * Start traversing both the list & compare node one by one.
	 * Return when node matches.
	 * 
	 */
	public static Node getIntersectionNode1(Node headA, Node headB) {
		Node t1 = headA,t2 = headB;
        int count1 = 0,count2 = 0;
        while(t1!=null && t2!=null){
            t1 = t1.next;
            t2 = t2.next;
            count1++;
            count2++;
        }
        while(t1!=null){
            t1 = t1.next;
            count1++;
        }
        while(t2!=null){
            t2 = t2.next;
            count2++;
        }
        t1 = headA;
        t2 = headB;
        if(count1>count2){
            int diff = count1-count2;
            while(diff>0){
                diff--;
                t1 = t1.next;
            }
        }else{
            int diff = count2-count1;
            while(diff>0){
                diff--;
                t2 = t2.next;
            }
        }
                
        while(t1!=null){
            if(t1==t2){
                return t1;
            }
            t1 = t1.next;
            t2 = t2.next;
        }
        return null;
    }

	/***
	 * 
	 * Time Complexity :- O(m+n)
	 * Space Complexity :- O(1)
	 * 
	 * Two Pointer approach :- 
	 * 
	 * Initialize two pointers ptr1 and ptr2  at head1 and  head2.
	 * Traverse through the lists, one node at a time.
	 * When ptr1 reaches the end of a list, then redirect it to head2.
	 * similarly, when ptr2 reaches the end of a list, redirect it to the head1.
	 * Once both of them go through reassigning, they will be equidistant from the collision point.
	 * If at any node ptr1 meets ptr2, then it is the intersection node.
	 * After the second iteration if there is no intersection node it returns NULL.
	 */
	public static Node getIntersectionNode2(Node headA, Node headB) {
		Node t1 = headA,t2 = headB;
        while(t1.next!=null && t2.next!=null){
            t1 = t1.next;
            t2 = t2.next;
        }
        if(t1.next==null){
            t1 = headB;
            while(t2.next!=null){
                t2 = t2.next;
                t1 = t1.next;
            }
            t2 = headA;
        }else{
            t2 = headA;
            while(t1.next!=null){
                t2 = t2.next;
                t1 = t1.next;
            }
            t1 = headB;
        }
        while(t1!=null && t2!=null){
            if(t1==t2){
                return t1;
            }
            t1 = t1.next;
            t2 = t2.next;
        }
        return null;
    }


}
