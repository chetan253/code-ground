class Solution {
    public class TrieNode{
        TrieNode[] chars;
        boolean isComplete;
        public TrieNode(){
            chars = new TrieNode[26];
            isComplete = false;
        }
    }
    public class Trie{
        TrieNode root;
        
        public Trie(){
            root = new TrieNode();
        }
        
        public void addWord(String word){
            TrieNode temp = root;
            for(char ch : word.toCharArray()){
                if(temp.chars[ch - 'a'] == null)
                    temp.chars[ch - 'a'] = new TrieNode();
                temp = temp.chars[ch - 'a'];
            }
            temp.isComplete = true;
        }
        
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0){
            return true;
        }
        
        Trie trie = new Trie();
        boolean reached[] = new boolean[s.length()];
        for(String word : wordDict){
            trie.addWord(word);
        }
        for(int i = 0; i < s.length(); i++){
            if(i == 0 || reached[i-1]){
                traverseTrie(trie, s, i, reached);
            }
        }
        return reached[s.length() - 1];
    }
    
    public void traverseTrie(Trie trie, String word, int start, boolean[] reached){
        TrieNode temp = trie.root;
        while(temp != null && start < word.length()){
            temp = temp.chars[word.charAt(start) - 'a'];
            if(temp != null && temp.isComplete){
                reached[start] = true;
            }
            start++;
        }
    }
}
