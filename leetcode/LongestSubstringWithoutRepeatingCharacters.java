class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> mapper =  new HashMap<Character, Integer>();
        int len = 1, maxlen = 0, startpos = 0, ctr = 0;
        if(s.length() == 0 || s.length() == 1)
            return s.length();
        char[] arr = s.toCharArray();
        mapper.put(arr[0], 0);
        for(int i = 1; i < arr.length; i++){
           if(mapper.containsKey(arr[i])){                
                if(arr[i] == arr[i-1]){
                    mapper.clear();
                    mapper.put(arr[i], i);
                    len = 1;
                    startpos = i;
                }
                else{
                    startpos = mapper.get(arr[i]) >= startpos ? mapper.get(arr[i]) + 1: startpos;
                    len = mapper.get(arr[i]) >= startpos ? Math.abs(i - startpos): Math.abs(i - startpos)+1;
                    mapper.put(arr[i], i);
                }
            }
            else{
                mapper.put(arr[i],i);
                len++;
            }
            if(len > maxlen)
                maxlen = len;
        }
        return maxlen;
    }
}
