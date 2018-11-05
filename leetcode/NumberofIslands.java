class Solution {
    int[] adjRow = new int[]{0, 0, 1, -1};
    int[] adjCol = new int[]{1, -1, 0, 0};
    
    public boolean isIsland(char[][] grid, int i, int j, boolean[][] visited){
        return (i >= 0 && i < grid.length && 
                j >= 0 && j < grid[i].length &&
                (grid[i][j] == '1' && visited[i][j] == false));
    }
    
    public void dfs(char[][] grid, int i, int j, boolean[][] visited){
        visited[i][j] = true;
        
        for(int k = 0; k < adjRow.length; k++){
            if(isIsland(grid, i + adjRow[k], j + adjCol[k], visited))
                dfs(grid, i + adjRow[k], j + adjCol[k], visited);
        }
    }
    
    public int numIslands(char[][] grid) {
        if(grid.length == 0)
            return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
}
