class Solution {
    public boolean isVowel(char c){
        if(c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U')
            return true;
        return false;
    }
    public String toGoatLatin(String S) {
        String[] str = S.split(" ");
        String a = "a";
        String ans = new String();        
        for(String s : str){
            StringBuffer sb = new StringBuffer(s);
            if(isVowel(sb.charAt(0)))
                sb.append("ma");
            else{
                sb.append(sb.charAt(0));
                sb.append("ma");
                sb.replace(0,1,"");
            }
            sb.append(a);
            ans += sb.toString() + " ";
            a += "a";
        }
        return ans.trim();
    }
}
