package stack;

import java.util.Stack;

public class Sort {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		st.push(5);
		st.push(-2);
		st.push(9);
		st.push(-7);
		st.push(3);
		
		traverse(st);
		System.out.println(st);
	}
	
	private static void traverse(Stack<Integer> st) {
		if(st.isEmpty())
			return;
		int num = st.pop();
		traverse(st);
		insert(num, st);
	}
	
	private static void insert(int data,Stack<Integer> st) {
		if(st.isEmpty()) {
			st.push(data);
			return;
		}
		if(st.peek()<=data) {
			st.push(data);
		}else {
			int num = st.pop();
			insert(data, st);
			insert(num, st);
		}
	}

}
