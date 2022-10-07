package linkedList;

import java.util.HashSet;

public class LoopDetectionandDeletion {

	/***
	 * 
	 * Floyd’s Cycle Detection Algorithm
	 * This approach uses a two-pointer – a fast pointer and a slow pointer to determine if there exists a cycle in the loop.
	 *  The slow pointer moves one node ahead at a time, while the fast pointer moves two nodes ahead at a time.
	 *  If a loop exists in the linked list, the fast and slow pointers are bound to meet at some point.
	 * 
	 *  Time Complexity :- O(n)
	 *  Space Complexity :- O(1)
	 *  
	 */
	public static boolean isLoopPresent(Node head) {
        if(head==null || head.next==null) {
			return false;
		}
		Node slowPtr = head;
		Node fastPtr = head.next;
		while(fastPtr!=null && slowPtr!=fastPtr) {
			fastPtr = fastPtr.next;
			if(fastPtr!=null)
				fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
		}
        if(fastPtr!=null)
            return true;
		return false;
	}
	
	/***
	 * 
	 * Using HashSet to detect loop
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 * 
	 */
	public static boolean isLoopPresenti(Node head) {
        if(head==null || head.next==null) {
			return false;
		}
        HashSet<Node> allNodes = new HashSet<>();
        Node temp = head;
		while(temp!=null) {
			if(allNodes.add(temp)) {
				temp = temp.next;
			}else {
				return true;
			}
		}
		return false;
	}
}
