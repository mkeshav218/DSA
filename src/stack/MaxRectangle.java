package stack;

import java.util.Stack;

/***
 * 
 * Given a rows x cols binary matrix filled with 0's and 1's. 
 * Find the largest rectangle containing only 1's and return its area.
 * 
 * Time Complexity :- O(n * m)
 * Space Complexity :- O(n)
 *
 */
public class MaxRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		int[] nums = new int[matrix[0].length];
        int area = Integer.MIN_VALUE;
        for(int i=0;i<matrix[0].length;i++){
            nums[i] = matrix[0][i] - '0';
        }
        int tempArea = maxArea(nums);
        // System.out.println("Temp = " + tempArea+", " + Arrays.toString(nums));
        area = Math.max(area,tempArea);
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]!='0'){
                    int num = (matrix[i][j]-'0')+nums[j];
                    nums[j] = num;
                }else{
                    nums[j] = 0;
                }
            }
            tempArea = maxArea(nums);
            // System.out.println("Temp = " + tempArea+", " + Arrays.toString(nums));
            area = Math.max(area,tempArea);
        }
        System.out.println("Maximum area = " + area);
	}
	
	private static int maxArea(int[] nums){
        int[] next = nextMin(nums);
        int[] prev = prevMin(nums);
        // System.out.println(Arrays.toString(next));
        // System.out.println(Arrays.toString(prev));
        int area = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int a = nums[i];
            int b = next[i] - prev[i] -1;
            area = Math.max(area,(a*b));
        }
        return area;
    }

    private static int[] nextMin(int[] nums){
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int n = nums.length;
        int[] res = new int[n];
        for(int i=n-1;i>=0;i--){
            if(st.peek()==-1){
                res[i] = n;
                st.push(i);
            }else if(nums[st.peek()]<nums[i]){
                res[i] = st.peek();
                st.push(i);
            }else{
                while(st.peek()!=-1 && nums[st.peek()]>=nums[i]){
                    st.pop();
                }
                if(st.peek()==-1){
                    res[i] = n;
                    st.push(i);
                }else{
                    res[i] = st.peek();
                    st.push(i);
                }
            }
        }
        return res;
    }

    private static int[] prevMin(int[] nums){
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int n = nums.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            if(st.peek()==-1){
                res[i] = -1;
                st.push(i);
            }else if(nums[st.peek()]<nums[i]){
                res[i] = st.peek();
                st.push(i);
            }else{
                while(st.peek()!=-1 && nums[st.peek()]>=nums[i]){
                    st.pop();
                }
                if(st.peek()==-1){
                    res[i] = -1;
                    st.push(i);
                }else{
                    res[i] = st.peek();
                    st.push(i);
                }
            }
        }
        return res;
    }

}
