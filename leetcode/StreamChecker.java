class StreamChecker {
    Trie trie = new Trie();
    TrieNode ptr;
    ArrayList<Character> list;
    public class TrieNode{
        TrieNode[] childs;
        boolean isEnd;
        public TrieNode(){
            this.childs = new TrieNode[26];
            this.isEnd = false;
        }
    }
    
    public class Trie{
        TrieNode root;
        
        public Trie(){
            root = new TrieNode();
        }
        
        public void insertWord(String word){
            String st = new StringBuilder(word).reverse().toString();
            TrieNode temp = root;
            for(char ch : st.toCharArray()){
                if(temp.childs[ch - 'a'] == null){
                    temp.childs[ch - 'a'] = new TrieNode();
                }
                temp = temp.childs[ch - 'a'];
            }
            
            temp.isEnd = true;
        }
    }
    
    public StreamChecker(String[] words) {
        list = new ArrayList<Character>();
        for(String word : words){
            trie.insertWord(word);
        }
    }
    
    public boolean query(char letter) {
        list.add(letter);
        ptr = trie.root;
        for(int i = list.size()-1; i >= 0; i--){
            if(ptr.childs[list.get(i) - 'a'] == null){
                return false;
            }
            ptr = ptr.childs[list.get(i) - 'a'];
            if(ptr.isEnd){
                return true;
            }
        }
        
        return ptr.isEnd;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
