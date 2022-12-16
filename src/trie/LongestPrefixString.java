package trie;

public class LongestPrefixString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"flower","flow","flight"};
		TrieP trieP = new TrieP();
        for(String s:strs){
        	trieP.insert(s);
        }
        StringBuffer sb = new StringBuffer();
        trieP.longestPrefix(strs[0],sb);
        System.out.println("Longest Common Prefix :- " + sb);
	}
}

class TrieP{
	TrieNodeP root;

    public TrieP(){
        root = new TrieNodeP('\0');
    }

    public void insert(String word){
        insertUtil(root,word,0);
    }

    private void insertUtil(TrieNodeP root,String word,int index){
        if(word.length()==0 || index>=word.length()){
            root.isTerminal = true;
            return;
        }

        int i = word.charAt(index)-'a';
        if(root.children[i]==null){
            root.children[i] = new TrieNodeP(word.charAt(index));
            root.childCount++;
        }
        root = root.children[i];
        index++;
        insertUtil(root,word,index);
    }

    public void longestPrefix(String word,StringBuffer sb){
    	TrieNodeP temp = root;
        for(int i=0;i<word.length();i++){
            if(temp.isTerminal){
                break;
            }
            char ch = word.charAt(i);
            if(temp!=null && temp.childCount==1){
                sb.append(ch);
                temp = temp.children[ch-'a'];
            }else{
                break;
            }

        }
    }
}


class TrieNodeP{
    char data;
    TrieNodeP[] children;
    int childCount;
    boolean isTerminal;

    public TrieNodeP(char data){
        this.data = data;
        this.children = new TrieNodeP[26];
        this.childCount = 0;
        this.isTerminal = false;
    }
}