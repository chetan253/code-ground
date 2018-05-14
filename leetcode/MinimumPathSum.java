class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cost[][] = new int[m][n];
        cost[0][0] = grid[0][0];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0)
                    continue;
                if(i == 0)
                    cost[i][j] = grid[i][j] + cost[i][j-1];
                if(j == 0)
                    cost[i][j] = grid[i][j] + cost[i-1][j];
            }
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                cost[i][j] = Math.min(cost[i][j-1], cost[i-1][j]) + grid[i][j];
            }
        }
        
        return cost[m-1][n-1];
    }
}
