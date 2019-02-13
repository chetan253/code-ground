class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] leftSkyline = new int[grid.length];
        int[] topSkyline = new int[grid[0].length];
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                leftSkyline[i] = Math.max(leftSkyline[i], grid[i][j]);
                topSkyline[j] = Math.max(topSkyline[j], grid[i][j]);
            }
        }
        
        int counter = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                int offset = Math.min(leftSkyline[i], topSkyline[j]) - grid[i][j];
                counter += offset;
            }
        }
        
        return counter;
    }
}
