class Solution {
    public void reverseWords(char[] s) {
        if(s.length == 0 || s == null){
            return;
        }
        
        reverse(s, 0, s.length - 1);
        
        int i = 0;
        for(int j = 0; j < s.length; j++){
            if(j+1 == s.length || s[j+1] == ' '){
                reverse(s, i, j);
                i = j+2;
            }
        }
    }
    
    public void reverse(char[] s, int start, int end){
        int i = start, j = end;
        while(i < j){
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }
}
