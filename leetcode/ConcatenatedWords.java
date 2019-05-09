class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        ArrayList<String> ans = new ArrayList<String>();
        HashSet<String> set = new HashSet<String>();
        Arrays.sort(words, (w1, w2) -> w1.length() - w2.length());
        for(int i = 0; i < words.length; i++){
            if(canForm(words[i], set)){
                ans.add(words[i]);
            }
            set.add(words[i]);
        }
        return ans;
    }
    
    public boolean canForm(String word, HashSet<String> wordDict){
        if(wordDict.isEmpty()){
            return false;
        }
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= word.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && wordDict.contains(word.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[word.length()];
    }
}
