package linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

/***
 * 
 * Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
 * (i) a next pointer to the next node,
 * (ii) a bottom pointer to a linked list where this node is head.
 * Each of the sub-linked-list is in sorted order.
 * Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order. 
 * 
 * The flattened list will be printed using the bottom pointer instead of next pointer.
 */
public class FlatteningLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FNode head = null;
		head = insertAtBeg(head, 28);
		head = insertAtBottom(head, 35);
		head = insertAtBottom(head, 40);
		head = insertAtBottom(head, 45);
		
		head = insertAtBeg(head, 19);
		head = insertAtBottom(head, 22);
		head = insertAtBottom(head, 50);
		
		head = insertAtBeg(head, 10);
		head = insertAtBottom(head, 20);

		head = insertAtBeg(head, 5);
		head = insertAtBottom(head, 7);
		head = insertAtBottom(head, 8);
		head = insertAtBottom(head, 30);

		print(head);
		
//		System.out.println("After flattening :- ");
//		head = flatten(head);
//		print(head);
		
		System.out.println("After flattening :- ");
		head = flattenUsingPQ(head);
		print(head);
	}
	
	/***
	 * 
	 * Time Complexity :- O(N * M * log(N))
	 * Space Complexity :- O(N)
	 */
	public static FNode flattenUsingPQ(FNode head) {
		PriorityQueue<FNode> pq = new PriorityQueue<>(new NodeComparator());
		FNode temp  =head;
		while(temp!=null) {
			pq.add(temp);
			temp = temp.next;
		}
		temp = new FNode(0);
		FNode tail = temp;
		while(!pq.isEmpty()) {
		    FNode curr = pq.poll();
		    if(curr.bottom!=null)
		        pq.add(curr.bottom);
			tail.bottom = curr;
			tail = tail.bottom;
			tail.next = null;
		}
		return temp.bottom;
	}
	
	/***
	 * 
	 * Time Complexity :- O(N * N * M)
	 * Space Complexity :- O(N*M)
	 */
	public static FNode flatten(FNode head) {
		if(head==null) {
			return head;
		}
		FNode list1 = flatten(head.next);
		FNode ans = mergeTwoSortedList(head, list1);
		ans.next = null;
		return ans;
	}
	
	public static FNode mergeTwoSortedList(FNode list1,FNode list2) {
		if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        FNode head = new FNode(0);
        FNode t1 = list1,t2  = list2, tail = head;
        while(t1!=null && t2!=null){
            if(t1.data<t2.data){
                tail.bottom = t1;
                t1 = t1.bottom;
            }else{
                tail.bottom = t2;
                t2 = t2.bottom;
            }
            tail = tail.bottom;
        }
        if(t1!=null){
            tail.bottom = t1;
        }
        if(t2!=null){
            tail.bottom = t2;
        }
        return head.bottom;
	}
	
	public static void print(FNode head) {
		FNode temp = head;
		while(temp!=null) {
			FNode curr = temp;
			while(curr!=null) {
				System.out.print(curr.data+" ");
				curr = curr.bottom;
			}
			System.out.println();
			temp = temp.next;
		}
	}
	
	public static FNode insertAtBeg(FNode head,int data) {
		FNode node = new FNode(data);
		if(head==null)
			return node;
		else {
			node.next = head;
			return node;
		}
	}
	
	public static FNode insertAtBottom(FNode head,int data) {
		FNode node = new FNode(data);
		FNode temp = head;
		while(temp.bottom!=null)
			temp = temp.bottom;
		temp.bottom = node;
		return head;
	}

}

class NodeComparator implements Comparator<FNode>{
	public int compare(FNode o1, FNode o2) {
		return Integer.compare(o1.data, o2.data);
	}
}

class FNode{
	int data;
	FNode next;
	FNode bottom;
	
	FNode(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}