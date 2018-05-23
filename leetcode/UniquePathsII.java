class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = 0, n = 0;
        try{
            m = obstacleGrid.length;
            n = obstacleGrid[0].length;
        }
        catch(Exception e){
            return 0;
        }
        
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1)
            return 0;
        
        if(m == 1 && n == 1)
            return 1;
        
        boolean obs = false;
        for(int j = 1; j < n; j++){
            if(obstacleGrid[0][j] == 1){
                obstacleGrid[0][j] = -1;
                obs = true;
                continue;
            }
            obstacleGrid[0][j] = (obs == true) ? 0 : 1;
        }
        
        obs = false;
        for(int i = 1; i < m; i++){
            if(obstacleGrid[i][0] == 1){
                obstacleGrid[i][0] = -1;
                obs = true;
                continue;
            }
            obstacleGrid[i][0] = (obs == true) ? 0 : 1;
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                    obstacleGrid[i][j] = -1;
                    continue;
                }
                if(obstacleGrid[i-1][j] < 0 && obstacleGrid[i][j-1] < 0)
                    obstacleGrid[i][j] = 0;
                else if(obstacleGrid[i-1][j] < 0 && obstacleGrid[i][j-1] >= 0)  //if left block is obstacle
                    obstacleGrid[i][j] = obstacleGrid[i][j-1];
                else if(obstacleGrid[i-1][j] >= 0 && obstacleGrid[i][j-1] < 0)  //if upper block is obstacle
                    obstacleGrid[i][j] = obstacleGrid[i-1][j];
                else
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];   //if left and upper are not obstacles
            }
        }
        return obstacleGrid[m-1][n-1];
    }
}<Paste>
