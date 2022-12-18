package stack;

import java.util.Stack;

/***
 * 
 * A celebrity is a person who is known to all but does not know anyone at a party.
 * find if there is a celebrity in the party or not.
 * A square NxN matrix M[][] is used to represent people at the party such that if an element of row i and column j  is set to 1,
 * it means ith person knows jth person. Here M[i][i] will always be 0.
 *
 */
public class CelebrityProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int	M[][] = {{0,1,0},{0,0,0},{0,1,0}};
		int celeb = celebrity(M);
		System.out.println("Celebrity = " + celeb);
	}
	
	/***
	 * 
	 * Time Complexity :- O(n)
	 * Space Complexity :- O(n)
	 * 
	 * If A knows B, then A can't be a celebrity. Discard A, and B may be celebrity.
	 * If A doesn't know B, then B can't be a celebrity. Discard B, and A may be celebrity.
	 * Repeat above two steps till there is only one person.
     * Ensure the remained person is a celebrity.
	 * 
	 */
	private static int celebrity(int M[][])
    {
		int n = M.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            st.push(i);
        }
        while(st.size()>1){
            int n1 = st.pop();
            int n2 = st.pop();
            if(M[n1][n2]==0 && M[n2][n1]==1){
                st.push(n1);
            }
            if(M[n2][n1]==0 && M[n1][n2]==1){
                st.push(n2);
            }
        }
        if(st.isEmpty())
            return -1;
        int num = st.pop();
        for(int i=0;i<n;i++){
            if(i!=num && (M[i][num]==0 || M[num][i]==1)){
                return -1;
            }
        }
        return num;
    }

}
