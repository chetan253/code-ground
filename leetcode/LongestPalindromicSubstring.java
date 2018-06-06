class Solution {
    public String longestPalindrome(String s) {
        
        
        if(s.length() == 0 || s.length() == 1){
            return s;
        }
        
        int[][] arr = new int[s.length()][s.length()];
        
        for(int i = 0; i < s.length(); i++){
                arr[i][i] = 1;
        }
        
        int max_i = 0, max_j = 0, max = 1;
        
        //Check each substring of each length
        for(int len = 1; len < s.length(); len++){
            for(int i = 0; i < s.length() - len; i++){
                int j = len + i;
                
                //Check if first and last characters are same or not
                if(s.charAt(i) == s.charAt(i+len))
                    if(len == 1)
                        arr[i][j] = arr[i+1][j-1] + 2;
                    else if(len > 1 && arr[i+1][j-1] != 0)
                        arr[i][j] = arr[i+1][j-1] + 2;
                else
                    arr[i][j] = 0;
                
                if(arr[i][j] > max){
                        max = arr[i][j];
                        max_i = i;
                        max_j = j;
                }
            }
        }
        
        //Backtracking - once we found the position of max len (i.e j) 
        //just decrement to reconstruct the string
        StringBuilder sb = new StringBuilder("");
        while(max != 0){
            sb.insert(0, s.charAt(max_j--));
            max--;
        }
        
        //print ref
        /*for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < s.length(); j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }*/
        
        return sb.toString();
    }
}
