class Solution {
    public int minAddToMakeValid(String S) {
        int i = 0;
        int left = 0, right = 0;
        while(i < S.length()){
            if(S.charAt(i) == '('){
                left++;
            }
            else{
                if(left > 0)
                    left--;
                else
                    right++;
            }
            i++;
        }
        
        return Math.abs(left + right);
    }
}
