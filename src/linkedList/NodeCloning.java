package linkedList;

import java.util.HashMap;
/***
 * 
 * Clone a list having next & random pointer
 *
 */
public class NodeCloning {

	public static void main(String[] args) {
		RNode head = null;
		head = insertAtBeg(head, 5);
		RNode fifth = head;
		head = insertAtBeg(head, 4);
		RNode fourth = head;
		head = insertAtBeg(head, 3);
		RNode third = head;
		head = insertAtBeg(head, 2);
		RNode second = head;
		head = insertAtBeg(head, 1);
		RNode first = head;

		first.arb = third;
		second.arb = first;
		third.arb = fifth;
		fourth.arb = third;
		fifth.arb = second;
		
		RNode temp = head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println("\n*******************\n");
		
		RNode clone = copyRandomList(head);
		temp = clone;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		
		System.out.println("\n*******************\n");
		
		RNode cloneHead = copyList(head);
		temp = cloneHead;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}

	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n) 
	 * 
	 */
	public static RNode copyRandomList(RNode head) {
		RNode cloneHead = new RNode(-1);
		RNode cloneTail = cloneHead;
		RNode temp = head;
       HashMap<RNode,RNode> map = new HashMap<>();
       while(temp!=null){
    	   RNode newNode = new RNode(temp.data);
           cloneTail.next = newNode;
           cloneTail = cloneTail.next;
           map.put(temp,newNode);
           temp = temp.next;
       }
       temp = head;
       RNode cloneTemp = cloneHead.next;
       while(temp!=null){
           if(temp.arb!=null){
               cloneTemp.arb = map.get(temp.arb);
           }
           temp = temp.next;
           cloneTemp = cloneTemp.next;
       }
       return cloneHead.next;
    }
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(1) 
	 * 
	 */
	public static RNode copyList(RNode head) {
        if(head==null)
            return head;
		RNode cloneHead = new RNode(-1);
		RNode cloneTail = cloneHead;
		RNode temp = head;
        while(temp!=null){
        	RNode newNode = new RNode(temp.data);
           cloneTail.next = newNode;
           cloneTail = cloneTail.next;
           temp = temp.next;
        }
        RNode t1 = head;
        RNode t2 = t1.next;
        RNode c1 = cloneHead.next;
        RNode c2 = c1.next;
        while(t1!=null){
            t1.next = c1;
            c1.next = t2;
            t1 = t2;
            c1 = c2;
            if(t2!=null)
                t2 = t2.next;
            if(c2!=null)
                c2 = c2.next;
        }
        t1 = head;
        while(t1!=null){
            if(t1.arb!=null){
                t1.next.arb = t1.arb.next;
            }
            t1 = t1.next.next;
        }
        t1 = head;
        t2 = t1.next.next;
        c1 = t1.next;
        if(t2!=null)
            c2 = t2.next;
        else
            c2 = null;
        while(t1!=null){
            t1.next = t2;
            c1.next = c2;
            t1 = t2;
            c1 = c2;
            if(t2!=null)
                t2 = c2.next;
            if(t2!=null)
                c2 = t2.next;
        }
        if(c2!=null)
            c2.next = null;
        return cloneHead.next;
    }
	
	
	public static RNode insertAtBeg(RNode head,int data) {
		RNode newNode = new RNode(data);
		if(head==null) {
			return newNode;
		}else {
			newNode.next = head;
			return newNode;
		}
	}

}


class RNode{
	int data;
	RNode next;
	RNode arb;
	public RNode(int data) {
		this.data = data;
		this.next = null;
		this.arb = null;
	}
}
