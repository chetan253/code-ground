class Solution {
    public int[] diStringMatch(String S) {
        int low = 0;
        int high = S.length();
        int[] arr = new int[S.length()+1];

        for(int i = 0; i < arr.length - 1; i++){
            if(S.charAt(i) == 'I'){
                arr[i] = low++;
            }else{
                arr[i] = high--;
            }
        }
        
        arr[arr.length - 1] = low;
        return arr;
    }
}
