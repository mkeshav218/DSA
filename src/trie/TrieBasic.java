package trie;

/***
 * 
 * Time Complexity (Insertion) :- O(length of word)
 * Time Complexity (Searching) :- O(length of word)
 * Time Complexity (Deletion) :- O(length of word)
 *
 */
public class TrieBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie t = new Trie();
		t.insert("ASDF");
		
		System.out.println("Is Present :- " + t.searchWord("ASDF"));
		System.out.println("Is Present :- " + t.searchWord("ASDFGH"));
		System.out.println("Is Present :- " + t.searchWord("AS"));
		System.out.println("Is Present :- " + t.searchWord("BDFGHJ"));
		
		t.removeWord("ASDF");
		System.out.println();
		System.out.println("Is Present :- " + t.searchWord("ASDF"));
		System.out.println("Is Present :- " + t.searchWord("ASDFGH"));
		System.out.println("Is Present :- " + t.searchWord("AS"));
		System.out.println("Is Present :- " + t.searchWord("BDFGHJ"));
	}
	

}

class Trie{
	TrieNode root;
	 
	public Trie() {
		root = new TrieNode('\0');
	}
	
	public void insert(String word) {
		insertUtil(root, word, 0);
	}
	
	private void insertUtil(TrieNode root,String word,int index) {
		if(index>=word.length()) {
			root.isTerminal = true;
			return;
		}
		int i = word.charAt(index) - 'A';
		System.out.println("Index = " + i);
		if(root.children[i]==null) {
			TrieNode node = new TrieNode(word.charAt(index));
			root.children[i] = node;
		}
		root = root.children[i];
		index++;
		insertUtil(root, word, index);
	}
	
	public boolean searchWord(String word) {
		return searchWordUtil(root, word, 0);
	}
	
	private boolean searchWordUtil(TrieNode root, String word,int index) {
		if(index>=word.length()) {
			return root.isTerminal;
		}
		
		int i = word.charAt(index) - 'A';
		if(root.children[i]!=null) {
			root = root.children[i];
			index++;
			return searchWordUtil(root, word, index);
		}else {
			return false;
		}
	}
	
	public void removeWord(String word) {
		removeWordUtil(root,word,0);
	}
	
	private void removeWordUtil(TrieNode root, String word,int index) {
		if(index>=word.length()) {
			root.isTerminal = false;
			return;
		}
		int i = word.charAt(index) - 'A';
		if(root.children[i]==null) {
			return;
		}else {
			root = root.children[i];
			index++;
			removeWordUtil(root, word, index);
		}
	}
}


class TrieNode{
	char data;
	TrieNode[] children;
	boolean isTerminal;
	
	public TrieNode(char data) {
		this.data = data;
		children = new TrieNode[26];
		isTerminal = false;
	}
}