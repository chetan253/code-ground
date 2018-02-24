class Solution {
    public boolean check(String haystack, String needle, int hayCounter){
        for(int j = 0, k = hayCounter; j < needle.length(); j++, k++){
            if(haystack.charAt(k) != needle.charAt(j)){
                return false;
            }
            continue;
        }
        return true;
    }
    public int strStr(String haystack, String needle) {
        boolean flag = false;
        if(haystack.equals(needle) || needle.equals(""))
            return 0;
        if(haystack.length() < needle.length() || needle.length() == 0 || haystack.length() == 0)
            return -1;
        for(int i = 0; i <= haystack.length() - needle.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                flag = check(haystack, needle, i);
                if(flag == true)
                    return i;
            }
        }
        return -1;
    }
}
