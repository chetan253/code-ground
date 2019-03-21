class Solution {
    public int getNumber(char ch){
        switch(ch){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
    public int romanToInt(String s) {
        int num = 0;
        char[] arr = s.toCharArray();
        for(int i = arr.length-1; i >= 0; i--){
            if(i < arr.length-1 && getNumber(arr[i]) < getNumber(arr[i+1])){
                num -= getNumber(arr[i]);
            }
            else{
                num += getNumber(arr[i]);   
            }
        }
        return num;
    }
}
