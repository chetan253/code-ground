class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;
        Integer carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0){
            Integer n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            Integer n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            Integer sum = n1+n2+carry;
            carry = sum / 10;
            sum %= 10;
            
            sb.insert(0, sum.toString());
            i--;
            j--;
        }
        if(carry > 0){
            sb.insert(0, carry.toString());   
        }
        
        return sb.toString();
    }
}
