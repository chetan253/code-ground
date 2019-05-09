class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for(String word : wordDict){
            trie.insertWord(word);
        }
        
        ArrayList<String>[] ans = new ArrayList<String>[];
        
    }
}

public List<String> getWords(String word, int start, List<String> ans, Trie trie){
    
    StringBuilder sb = new StringBuilder();
    List<String> temp = new ArrayList<String>();
    for(int i = start; i < word.length; i++){
        
    }
}

public class Trie{
    Trie root;

    private class TrieNode{
        TrieNode childs[];
        boolean isEnd;
        public TrieNode(){
            childs[] = new TrieNode[26];
        }
    }
    
    public Trie(){
        root = new TrieNode();
    }
    
    public void insertWord(String word){
        TrieNode temp = root;
        for(char ch : word.toCharArray()){
            if(temp.childs[ch - 'a'] == null){
                temp.childs[ch - 'a'] = new TrieNode();
            }
            temp = temp.childs[ch - 'a'];
        }
        temp.isEnd = true;
    }
    
}
