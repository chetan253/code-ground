class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, maxLen = 0;
        
        if(s.length() <= 1){
            return s.length();
        }
        
        char[] ch = s.toCharArray();
        
        HashMap<Character, Integer> idxMap = new HashMap<Character, Integer>();
        while(j < ch.length && !idxMap.containsKey(ch[j])){
            idxMap.put(ch[j], j);
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        
        while(j < ch.length){
            if(idxMap.containsKey(ch[j])){
                int lastIdx = idxMap.get(ch[j]);
                while(i <= lastIdx){
                    idxMap.remove(ch[i]);
                    i++;
                }
            }
            idxMap.put(ch[j], j);
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        return maxLen;
    }
}
