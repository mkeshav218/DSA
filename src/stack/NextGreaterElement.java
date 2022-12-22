package stack;

import java.util.Arrays;
import java.util.Stack;

/***
 * 
 * find the next greater element for each element of the array.
 * Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
 * If there does not exist next greater of current element, then next greater element for current element is -1.
 *
 */
public class NextGreaterElement {

	public static void main(String[] args) {
		int[] input = {8,1,3,2,4};
		int[] result = nextLargerElement(input);
		System.out.println(Arrays.toString(result));
	}

	public static int[] nextLargerElement(int[] arr)
    {
		int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(st.isEmpty()){
                res[n-i-1] = -1;
                st.push(arr[n-i-1]);
            }else{
                while(!st.isEmpty()){
                    if(st.peek()>arr[n-i-1]){
                        res[n-i-1] = st.peek();
                        st.push(arr[n-i-1]);
                        break;
                    }else{
                        st.pop();
                    }
                }
                if(st.isEmpty()){
                    res[n-i-1] = -1;
                    st.push(arr[n-i-1]);
                }
            }
        }
        return res;
    }
}
