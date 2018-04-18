class Solution {
    public int lengthOfLastWord(String s){
        if(s.length() == 0)
            return 0;
        int counter = 0;
        int i = s.length()-1;
        while(s.charAt(i) == ' ')
            if(i > 0)
                i--;
            else
                break;
        
        for(; i >= 0; i--){
            char c = s.charAt(i);
            if(c != ' ')
                counter++;
            else
                break;
        }
        return counter;
    }
}
