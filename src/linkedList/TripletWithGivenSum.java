package linkedList;

import java.util.List;
import java.util.LinkedList;

public class TripletWithGivenSum {

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

		int resultantSum = 12;
		System.out.println("Triplet sum in case List is sorted :- ");
		List<Triplet> triplets = getTripletWithSum(resultantSum, list.head);
		for(Triplet p : triplets) {
			System.out.println(p);
		}
	}
	
	/***
	 * 
	 * Time Complexity :- O(n2)
	 * Space Complexity :- O(1)
	 * @return
	 */
	public static List<Triplet> getTripletWithSum(int sum,NodeDLL head){
		List<Triplet> resList = new LinkedList<>();
		NodeDLL temp=head;
		while(temp.next!=null) {
			temp = temp.next;
		}
		NodeDLL tail = temp;
		temp = head;
		while(temp.next!=null) {
			int target = sum - temp.data;
			NodeDLL temp1 = temp.next;
			NodeDLL temp2 = tail;
			while(temp1!=temp2 && temp2.next!=temp1) {
				if(temp1.data+temp2.data==target) {
					Triplet t = new Triplet(temp.data,temp1.data,temp2.data);
					resList.add(t);
					temp1 = temp1.next;
					temp2 = temp2.prev;
				}else {
					if(temp1.data+temp2.data>target) {
						temp2 = temp2.prev;
					}else {
						temp1 = temp1.next;
					}
				}
			}
			temp = temp.next;
		}
		return resList;
	}

}


class Triplet{
	int first;
	int second;
	int third;
	
	
	public Triplet(int first, int second, int third) {
		super();
		this.first = first;
		this.second = second;
		this.third = third;
	}


	@Override
	public String toString() {
		return "Triplet [first=" + first + ", second=" + second + ", third=" + third + "]";
	}
}