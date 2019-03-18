class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        int[] lastIdx = new int[26];
        int i = 0;
        
        for(char c : s.toCharArray()){
            count[c - 'a']++;
            lastIdx[c - 'a'] = i;
            i++;
        }
        
        int minIdx = s.length() - 1;
        boolean flag = false;
        for(i = 0; i < count.length; i++){
            if(count[i] == 1){
                if(!flag){
                    flag = true;
                }
                minIdx = Math.min(minIdx, lastIdx[i]);
            }
        }
        
        return flag ? minIdx : -1;
    }
}
