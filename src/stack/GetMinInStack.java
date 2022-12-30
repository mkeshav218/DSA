package stack;

import java.util.Stack;
/***
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * Method-1
 * Use 2 stack, one to store data & other to store min-element-so-far.
 * 
 * Method-2
 * Use 1 stack, insert data in such a way that while fetching min can be get in O(1) time.
 * 
 * Method-3
 * Use doubly-linked-list, 
 *
 */
public class GetMinInStack {

	public static void main(String[] args) {
		SpecialStack spStack = new SpecialStack();
		spStack.push(5);
		spStack.push(3);
		spStack.push(8);
		spStack.push(2);
		spStack.push(4);
		
		System.out.println("Method - 1");
		for(int i=0;i<5;i++) {
			System.out.println("Min element = " + spStack.getMIn());
			spStack.pop();
		}
		System.out.println("\n");
		
		SpecialStack1 spStack1 = new SpecialStack1();
		spStack1.push(5);
		spStack1.push(3);
		spStack1.push(8);
		spStack1.push(2);
		spStack1.push(4);
		
		System.out.println("Method - 2");
		for(int i=0;i<5;i++) {
			System.out.println("Min element = " + spStack1.getMin());
			spStack1.pop();
		}
		System.out.println("\n");
		
		SpecialStack2 spStack2 = new SpecialStack2();
		spStack2.push(5);
		spStack2.push(3);
		spStack2.push(8);
		spStack2.push(2);
		spStack2.push(4);
		
		System.out.println("Method - 3");
		for(int i=0;i<5;i++) {
			System.out.println("Min element = " + spStack2.getMin());
			spStack2.pop();
		}
		System.out.println("\n");

	}

}

class SpecialStack{
	Stack<Integer> st1;
	Stack<Integer> st2;
	
	public SpecialStack() {
		st1 = new Stack<Integer>();
		st2 = new Stack<Integer>();
	}
	
	public void push(int data) {
		if(st1.isEmpty()) {
			st2.push(data);
		}else {
			st2.push(Math.min(st2.peek(), data));
		}
		st1.push(data);
	}
	
	public int pop() {
		if(st1.isEmpty())
			return -1;
		st2.pop();
		return st1.pop();
	}
	
	public int getMIn() {
		if(st2.isEmpty())
			return -1;
		return st2.peek();
	}
}

class SpecialStack1 {
    Stack<Long> st;
    long min;
    public SpecialStack1() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push((long)val);
            min = (long)val;
        }else{
            if(val>=min){
                st.push((long)val);
            }else{
                long num = ((2 * (long)val) - min);
                st.push(num);
                min = (long)val;
            }
        }
    }
    
    public void pop() {
        if(!st.isEmpty()){
            if(st.peek()>=min){
                st.pop();
            }else{
                min = ((2*min) - st.pop());
            }
        }
    }
    
    public int top() {
        if(!st.isEmpty()){
            if(st.peek()>=min){
                long num = st.peek();
                return (int)num;
            }else{
                return (int)min;
            }
        }
        return -1;
    }
    
    public int getMin() {
        if(st.isEmpty())
            return -1;
        return (int)min;
    }
}

/***
 * 
 * Using doubly-linkedList
 *
 */
class SpecialStack2 {

    Node head,tail;

    public SpecialStack2() {
        head = null;
        tail = null;
    }
    
    public void push(int val) {
        if(head==null){
            head = new Node(val,val);
            tail = head;
        }else{
            int minData = tail.min;
            minData = Math.min(minData,val);
            Node newNode = new Node(val,minData);
            tail.next = newNode;
            newNode.prev = tail;
            tail = tail.next;
        }
    }
    
    public void pop() {
        if(tail!=null){
            if(head==tail){
                head = null;
                tail = null;
            }else{
                tail = tail.prev;
                tail.next = null;
            }
        }
    }
    
    public int top() {
        return tail.data;
    }
    
    public int getMin() {
        return tail.min;
    }
}

class Node{
    int data;
    int min;
    Node next;
    Node prev;

    public Node(int data,int min){
        this.data = data;
        this.min = min;
        this.next = null;
        this.prev = null;
    }
}

