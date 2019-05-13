class Trie {
    TrieNode root;
    public class TrieNode{
        boolean isEnd;
        TrieNode[] childs = new TrieNode[26];
    }
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(char ch : word.toCharArray()){
            if(cur.childs[ch - 'a'] == null){
                cur.childs[ch - 'a'] = new TrieNode();
            }
            cur = cur.childs[ch - 'a'];
        }
        cur.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(char ch : word.toCharArray()){
            if(cur.childs[ch - 'a'] == null){
                return false;
            }
            cur = cur.childs[ch - 'a'];
        }
        return cur.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char ch : prefix.toCharArray()){
            if(cur.childs[ch - 'a'] == null){
                return false;
            }
            cur = cur.childs[ch - 'a'];
        }
        return true;
    }
}
