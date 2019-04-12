class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        boolean neg = false;
        int i = 0;
        
        if(str == null || str.length() < 1){
            return 0;
        }
        if(str.charAt(0) == '-'){
            neg = true;
            i++;
        }
        else if(str.charAt(0) == '+'){
            i++;
        }
        
        double num = 0;
        
        while(i < str.length() && Character.isDigit(str.charAt(i))){
            num = num*10 + (str.charAt(i) - '0');
            i++;
        }
        
        if(neg){
            num = -num;
        }
        
        if(num > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(num < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        
        return (int)num;
    }
}
