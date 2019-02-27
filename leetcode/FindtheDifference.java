class Solution {
    public char findTheDifference(String s, String t) {
        int[] chars = new int[26];
        int i = 0;
        while(i < s.length()){
            chars[s.charAt(i) - 'a']++;
            chars[t.charAt(i) - 'a']--;
            i++;
        }
        chars[t.charAt(i) - 'a']--;
        
        for(i = 0; i < chars.length; i++){
            if(chars[i] < 0){
                return (char)('a' + i);
            }
        }
        
        throw null;
    }
}
