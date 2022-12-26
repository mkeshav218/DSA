package stack;

import java.util.Stack;

/***
 * 
 * Find the largest rectangular area possible in a given histogram.
 * Time Complexity : O(N)
 * Space Complexity: O(N)
 *
 */
public class MaxAreaInHistogram {

	public static void main(String[] args) {
		long N = 7;
		long arr[] = {6,2,5,4,5,1,6};
		System.out.println("Max Area = " + getMaxArea(arr, N));
	}

	public static long getMaxArea(long hist[], long n) 
    {
        long[] prev = prevMin(hist,(int)n);
        long[] next = nextMin(hist,(int)n);
        // System.out.println(Arrays.toString(prev));
        // System.out.println(Arrays.toString(next));
        long maxArea = Integer.MIN_VALUE;
        for(int i=0;i<(int)n;i++){
            long l = hist[i];
            long b = next[i] - prev[i] - 1;
            maxArea = Math.max(maxArea,(l*b));
        }
        return maxArea;
    }
        
    private static long[] nextMin(long[] hist, int n){
        Stack<Integer> st = new Stack<>();
        long[] res = new long[n];
        st.push(-1);
        for(int i=n-1;i>=0;i--){
            if(st.peek()==-1){
                st.push(i);
                res[i] = n;
            }else if(hist[st.peek()]<=hist[i]){
                res[i] = st.peek();
                st.push(i);
            }else{
                while(st.peek()!=-1 && hist[st.peek()]>=hist[i]){
                    st.pop();
                }
                if(st.peek()==-1){
                    st.push(i);
                    res[i] = n;
                }else{
                    res[i] = st.peek();
                    st.push(i);
                }
            }
        }
        return res;
    }    
    
    private static long[] prevMin(long[] hist, int n){
        Stack<Integer> st = new Stack<>();
        long[] res = new long[n];
        st.push(-1);
        for(int i=0;i<n;i++){
            if(st.peek()==-1){
                st.push(i);
                res[i] = -1;
            }else if(hist[st.peek()]<=hist[i]){
                res[i] = st.peek();
                st.push(i);
            }else{
                while(st.peek()!=-1 && hist[st.peek()]>=hist[i]){
                    st.pop();
                }
                if(st.peek()==-1){
                    st.push(i);
                    res[i] = -1;
                }else{
                    res[i] = st.peek();
                    st.push(i);
                }
            }
        }
        return res;
    } 
}
