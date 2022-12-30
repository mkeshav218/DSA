package stack;

import java.util.Stack;

public class GetMinInStack {

	public static void main(String[] args) {
		SpecialStack spStack = new SpecialStack();
		spStack.push(5);
		spStack.push(3);
		spStack.push(8);
		spStack.push(2);
		spStack.push(4);
		
		for(int i=0;i<5;i++) {
			System.out.println("Min element = " + spStack.getMIn());
			spStack.pop();
		}
	}

}

/***
 * 
 * Time Complexity :- O(n)
 * Space Complexity :- O(n)
 *
 */
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
