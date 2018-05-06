class Solution {
    public boolean isAlpha(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
    public boolean isPalindrome(String s) {
        s = s.trim();
        int i = 0;
        int j = s.length()-1;
        while(i < j){
            while(!isAlpha(s.charAt(i)))
                if(i < j)
                    i++; 
                else
                    break;

            while(!isAlpha(s.charAt(j)))
                if(j > i)
                    j--;
                else
                    break;

            if(Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))){
                i++;
                j--;
                continue;
            }
            return false;
        }
        return true;
    }
}
