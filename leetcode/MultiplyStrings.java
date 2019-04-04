class Solution {
    public String multiply(String num1, String num2) {
        
        if(num1.length() == 0 || num2.length() == 0 || num1.charAt(0) == '0' || num2.charAt(0) == '0'){
            return "0";
        }
        String sign = "";
        if(num1.charAt(0) == '-' && num2.charAt(0) == '-'){
            sign = "";
        }
        else if(num1.charAt(0) == '-' || num2.charAt(0) == '-'){
            sign = "-";
            if(num1.charAt(0) == '-'){
                num1 = num1.substring(1, num1.length());
            }
            else{
                num2 = num2.substring(1, num2.length());
            }
        }
        
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        
        int[] n = new int[num1.length() + num2.length() + 1];
        Arrays.fill(n, 0);
        
        for(int i = 0; i < num1.length(); i++){
            for(int j = 0; j < num2.length(); j++){
                n[i+j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        
        int carry = 0;
        for(int i = 0; i < n.length; i++){
            n[i] += carry;
            carry = n[i]/10;
            n[i] = n[i]%10;
        }
        
        String result = "";
        
        for(int num : n){
            result += num;
        }
        
        result = new StringBuilder(result).reverse().toString();
        
        //remove leading zeores
        for(int i = 0; i < result.length(); i++){
            if(result.charAt(i) != '0'){
                result = result.substring(i, result.length());
                break;
            }
        }
        
        return sign+result;
    }
}
