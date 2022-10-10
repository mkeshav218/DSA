package linkedList;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class PairWithGivenSumInDLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList list = new DoublyLinkedList();
		list.insertAtBeg(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		list.insertAtEnd(6);
		list.insertAtEnd(7);

		list.printList();
		
		int resultSum = 7;
		System.out.println("Pair sum in case List is sorted :- ");
		List<Pair> pairs = getPairsWithSum(resultSum, list.head, list.tail);
		for(Pair p : pairs) {
			System.out.println(p);
		}
		
		
		System.out.println("\nPair sum using Hashing :- ");
		List<Pair> pairSum = getPairsWithSumUsingHashing(resultSum, list.head);
		for(Pair p : pairs) {
			System.out.println(p);
		}
	}

	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(1)
	 * 
	 */
	public static List<Pair> getPairsWithSum(int sum,NodeDLL head,NodeDLL tail){
		List<Pair> lists = new LinkedList<>();
		NodeDLL temp1 = head,temp2 = tail;
		while(temp1!=temp2 && temp2.next!=temp1) {
			if(temp1.data+temp2.data>sum) {
				temp2 = temp2.prev;
			}else if(temp1.data+temp2.data<sum) {
				temp1 = temp1.next;
			}else {
				Pair p = new Pair();
				p.first = temp1.data;
				p.second = temp2.data;
				lists.add(p);
				temp1 = temp1.next;
				temp2 = temp2.prev;
			}
		}
		return lists;
	}
	
	/***
	 * 
	 * Time Complexity :- O(nlogn)
	 * Space Complexity :- O(n)
	 * 
	 */
	public static List<Pair> getPairsWithSumUsingHashing(int sum,NodeDLL head){
		List<Pair> lists = new LinkedList<>();
		NodeDLL temp1 = head;
		HashSet<Integer> hashSet = new HashSet<>();
		while(temp1!=null) {
			int target = sum - temp1.data;
			if(hashSet.contains(target)) {
				Pair p = new Pair();
				p.first = temp1.data;
				p.second = target;
				lists.add(p);
			}else {
				hashSet.add(temp1.data);
			}
			temp1 = temp1.next;
		}
		return lists;
	}
}

class Pair{
	int first;
	int second;
	@Override
	public String toString() {
		return "Pair [first=" + first + ", second=" + second + "]";
	}
	
}