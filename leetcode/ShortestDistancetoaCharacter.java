class Solution {
    public int[] shortestToChar(String S, char C) {
        int[] arr = new int[S.length()];
        
        for(int i = 0; i < arr.length; i++){
            if(S.charAt(i) != C){
                continue;
            }
            arr[i] = 0;
            int l = i-1, r = i+1;
            while(l >= 0 && (arr[l] > i-l || arr[l] == 0) && S.charAt(l) != C){
                arr[l] = i-l;
                l--;
            }
            while(r < arr.length && arr[r] < r-i && S.charAt(r) != C){
                arr[r] = r-i;
                r++;
            }
        }
        
        return arr;
    }
}
