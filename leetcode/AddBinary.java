class Solution {
    public String addBinary(String a, String b) {
        if(a.length() == 0 || b.length() == 0)
            return a.length() == 0 ? b : a;

        boolean carry = false;
        String result = ""; 
        int i = a.length() - 1, j = b.length() - 1;
        while(i >= 0 && j >= 0){
            char ac = a.charAt(i);
            char bc = b.charAt(j);
            
            if((ac == '0' && bc == '1') || (ac == '1' && bc == '0')){
                if(carry){
                    result = "0" + result;
                    carry = true;
                }
                else{
                    result = "1" + result;
                    carry  = false;
                }
            }
            else if(ac == '1' && bc == '1'){
                if(carry)
                    result = "1" + result;
                else
                    result = "0" + result;
                carry = true;
            }
            else{
                if(carry){
                    result = "1" + result;
                    carry = false;
                }
                else
                    result = "0" + result;
            }
            i--;
            j--;
        }
        
        while(i >= 0){
            if(carry && a.charAt(i) == '1' )
                result = "0" + result;
            else if(carry && a.charAt(i) == '0'){
                result = "1" + result;
                carry = false;
            }
            else
                result = a.charAt(i) + result;
            i--;
        }
                
        
        while(j >= 0){
            if(carry && b.charAt(j) == '1' )
                result = "0" + result;
            else if(carry && b.charAt(j) == '0'){
                result = "1" + result;
                carry = false;
            }
            else
                result = b.charAt(j) + result;
            j--;
        }        
        if(carry)
            result = "1"+ result;
        return result;
    }
}
