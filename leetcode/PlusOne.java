class Solution {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int carry = 1;
        int num = 0;
        for(int i = digits.length - 1; i >= 0; i--){
            if(carry == 0 && (digits[i] / 10) == 0)
                arr.add(0, digits[i]);
            else if((carry / 10) == 0 && carry > 0 && digits[i] == 0){
                arr.add(0, carry);
                carry = 0;
            }
            else{
                carry = digits[i] + carry;
                arr.add(0, carry % 10);
                carry /= 10;
            }
        }
        while(carry != 0){
            arr.add(0, carry % 10);
            carry /= 10;
        }
        int[] result = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++)
            result[i] = arr.get(i);
        return result;
    }
}
