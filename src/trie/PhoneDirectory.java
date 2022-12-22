package trie;

import java.util.ArrayList;

/***
 * 
 * Time Complexity (Insertion) :- O(length of word)
 * Time Complexity (Searching) :- O(length of word)
 * Time Complexity (Deletion) :- O(length of word)
 *
 */
public class PhoneDirectory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] input ={"geeksforgeeks","geeikistest","geeksfortest"};// {"cod","coding","codding","code","coly"};
		String pre = "geeips";//"coding";
		TriePhone t = new TriePhone();
		for(String s:input) {
			t.insert(s);
		}
		ArrayList<ArrayList<String>> result = t.getSuggestions(pre);
		for(ArrayList<String> list:result)
			System.out.println(list);
		
	}
	

}

class TriePhone{
	TrieNodePhone root;
	 
	public TriePhone() {
		root = new TrieNodePhone('\0');
	}
	
	public void insert(String word) {
		insertUtil(root, word, 0);
	}
	
	private void insertUtil(TrieNodePhone root,String word,int index) {
		if(index>=word.length()) {
			root.isTerminal = true;
			return;
		}
		int i = word.charAt(index) - 'a';
		if(root.children[i]==null) {
			TrieNodePhone node = new TrieNodePhone(word.charAt(index));
			root.children[i] = node;
		}
		root = root.children[i];
		index++;
		insertUtil(root, word, index);
	}
	
	public boolean searchWord(String word) {
		return searchWordUtil(root, word, 0);
	}
	
	private boolean searchWordUtil(TrieNodePhone root, String word,int index) {
		if(index>=word.length()) {
			return root.isTerminal;
		}
		
		int i = word.charAt(index) - 'a';
		if(root.children[i]!=null) {
			root = root.children[i];
			index++;
			return searchWordUtil(root, word, index);
		}else {
			return false;
		}
	}
	
	public ArrayList<ArrayList<String>> getSuggestions(String pre) {
		TrieNodePhone prev = root;
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		StringBuffer prefix = new StringBuffer();
		for(int i=0;i<pre.length();i++) {
			char ch = pre.charAt(i);
			System.out.println("ch = " + ch);
			prefix.append(ch);
			TrieNodePhone curr = prev.children[ch-'a'];
			ArrayList<String> currResult = new ArrayList<>();
			if(curr!=null) {
				printSuggestion(curr,currResult,prefix);
				result.add(currResult);
				prev = curr;
			}else {
				break;
			}
		}
		return result;
	}
	
	public void printSuggestion(TrieNodePhone curr,ArrayList<String> currResult,StringBuffer res) {
		if(curr.isTerminal) {
			currResult.add(res.toString());
		}
		
		for(char ch = 'a';ch<='z';ch++) {
			if(curr.children[ch-'a']!=null) {
				res.append(ch);
				printSuggestion(curr.children[ch-'a'], currResult, res);
				res.deleteCharAt(res.length()-1);
			}
		}
	}
}


class TrieNodePhone{
	char data;
	TrieNodePhone[] children;
	boolean isTerminal;
	
	public TrieNodePhone(char data) {
		this.data = data;
		children = new TrieNodePhone[26];
		isTerminal = false;
	}
}
