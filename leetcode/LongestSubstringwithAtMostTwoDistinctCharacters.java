class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int i = 0, j = 0;
        int maxCount = Integer.MIN_VALUE;
        while(j < s.length()){
            char ch = s.charAt(j);
            
            map.put(ch, j);
            
            if(map.size() == 3){
                int chI = Collections.min(map.values());
                i = map.get(s.charAt(chI)) + 1;
                map.remove(s.charAt(chI));
            }
            
            maxCount = Math.max(maxCount, j-i+1);
            j++;
        }
        
        return maxCount == Integer.MIN_VALUE ? 0 : maxCount;
    }
}
