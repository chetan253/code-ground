class Solution {
    
    int[] rowMask = new int[]{0, 1, 0, -1};
    int[] colMask = new int[]{1, 0, -1, 0};
    int ctr = 0;
    public boolean isIsland(int[][] grid, int i, int j, boolean[][] visited){
        return (i >= 0 && i < grid.length &&
               j >= 0 && j < grid[i].length &&
               (grid[i][j] == 1 && visited[i][j] == false));
    }
    
    public int dfs(int[][] grid, int i, int j, boolean[][] visited){
        visited[i][j] = true;
        
        for(int k = 0; k < rowMask.length; k++){
            if(isIsland(grid, i + rowMask[k], j + colMask[k], visited)){
                dfs(grid, i + rowMask[k], j + colMask[k], visited);
                ctr++;
            }
        }
        
        return ctr;
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0 || grid == null){
            return 0;
        }
        int maxArea = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1 && visited[i][j] == false){
                    ctr = 1;
                    int tempArea = dfs(grid, i, j, visited);
                    maxArea = tempArea > maxArea ? tempArea : maxArea;
                }
            }
        }
        return maxArea;
    }
}
