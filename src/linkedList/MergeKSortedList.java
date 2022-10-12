package linkedList;

public class MergeKSortedList {
//	{{1,2,3},{4 5},{5 6},{7,8}}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList list1 = new SinglyLinkedList();
		list1.insertAtBeg(1);
		list1.insertAtEnd(2);
		list1.insertAtEnd(3);
		list1.printList();
		
		SinglyLinkedList list2 = new SinglyLinkedList();
		list2.insertAtBeg(4);
		list2.insertAtEnd(5);
		list2.printList();
		
		SinglyLinkedList list3 = new SinglyLinkedList();
		list3.insertAtBeg(5);
		list3.insertAtEnd(6);
		list3.printList();
		
		SinglyLinkedList list4 = new SinglyLinkedList();
		list4.insertAtBeg(7);
		list4.insertAtEnd(8);
		list4.printList();
		
		Node[] arr = new Node[] {list1.head,list2.head,list3.head,list4.head};
		SinglyLinkedList list = new SinglyLinkedList();
		list.head = mergeKList(arr);
		list.printList();
	}
	
    public static Node mergeKList(Node[]arr)
    {
        Node head=null,tail = null;
        while(true){
            int small=Integer.MAX_VALUE,index=-1;
            for(int i=0;i<arr.length;i++){
                if(arr[i]!=null && arr[i].data<=small){
                    small = arr[i].data;
                    index = i;
                }
            }
            if(index!=-1){
                if(head==null){
                    head = arr[index];
                    tail = head;
                    arr[index] = arr[index].next;
                }else{
                    tail.next = arr[index];
                    tail = tail.next;
                    arr[index] = arr[index].next;
                }
            }else{
                break;
            }
        }
        return head;

    }

}
