class Solution {
    public int countSubstrings(String s) {
        int ctr = 0;
        boolean[][] arr = new boolean[s.length()][s.length()];
        
        for(boolean[] row : arr){
            Arrays.fill(row, false);
        }
        
        //Make diagonals true as all characters to itself are palindrome
        for(int i = 0; i < arr.length; i++ ){
            arr[i][i] = true;
            ctr++;
        }        
        
        //Check for first and last char depending on length and 
        //sub-solution is palindromic substring or not 
        for(int len = 1; len < s.length(); len++){
            for(int i = 0; i < s.length() - len; i++){
                int j = i + len;
                if((s.charAt(i) == s.charAt(j)) && arr[i+1][j-1]){
                    arr[i][j] = true;
                    ctr++;
                }
                else if((s.charAt(i) == s.charAt(j)) && len == 1){
                    arr[i][j] = true;
                    ctr++;
                }
            }
        }
        return ctr;
    }
}
