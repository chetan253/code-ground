class Solution {
    int[] rowMask = new int[]{0,0,1,-1};
    int[] colMask = new int[]{1,-1,0,0};
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0){
            return 0;
        }
        
        int maxPath = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                maxPath = Math.max(maxPath, 
                                   dfs(matrix, i, j, dp));
            }
        }
        
        return maxPath;
    }
    
    public boolean isValid(int[][] matrix, int i, int j, int num){
        return 
            i >= 0 && i < matrix.length &&
            j >= 0 && j < matrix[0].length &&
            matrix[i][j] > num;
    }
    
    public int dfs(int[][] matrix, int i, int j, int[][] dp){
        if (dp[i][j] != 0){
            return dp[i][j];
        }
        
        for(int d = 0; d < rowMask.length ; d++){
            if(isValid(matrix,i+rowMask[d],j+colMask[d], matrix[i][j])){
                dp[i][j] = Math.max(dp[i][j], dfs(matrix, i+rowMask[d], j+colMask[d], dp));
            }
        }
        
        return ++dp[i][j];
    }
}
