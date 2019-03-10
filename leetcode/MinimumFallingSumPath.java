class Solution {
    public int minFallingPathSum(int[][] A) {
        int min = Integer.MAX_VALUE;
        if(A.length == 0){
            return 0;
        }
        if(A.length == 1){
            for(int num : A[0]){
                min = Math.min(num, min);
            }
        }
        
        for(int i = 1; i < A.length; i++){
            for(int j = 0; j < A[i].length; j++){
                int minimal = A[i-1][j];
                if(j > 0){
                    minimal = Math.min(minimal, A[i-1][j-1]);
                }
                if(j < A.length - 1){
                    minimal = Math.min(minimal, A[i-1][j+1]);
                }
                A[i][j] += minimal;
                if(i == A.length - 1){
                    min = Math.min(min, A[i][j]);   
                }
            }
        }
        
        return min;
    }
}
