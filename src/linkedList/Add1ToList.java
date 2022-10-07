package linkedList;

public class Add1ToList {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.insertAtBeg(9);
		list.insertAtBeg(9);
		list.insertAtEnd(9);
		list.insertAtEnd(9);
		int res = add(list.getHead());
        if(res==1){
        	list.getHead().data=0;
            Node newNode = new Node(1);
            newNode.next=list.getHead();
            list.head = newNode;
        }
		list.printList();
	}
	
    public static int add(Node head){
        if(head==null){
            return 1;
        }
        int carry = add(head.next);
        int res = head.data + carry;
        if(res<10){
            head.data = res;
            return 0;
        }else{
            head.data = 0;
            return 1;
        }
    }
	


}
