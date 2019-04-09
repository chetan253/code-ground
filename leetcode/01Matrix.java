class Solution {
    public class Location{
        int x, y;
        public Location(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix.length == 0){
            return matrix;
        }
        Queue<Location> queue = new ArrayDeque<Location>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 1){
                    matrix[i][j] = -1;
                }
                else{
                    queue.add(new Location(i,j));
                }
            }
        }
        
        int[] rowMask = new int[]{0,0,1,-1};
        int[] colMask = new int[]{1,-1,0,0};
        
        while(!queue.isEmpty()){
            Location loc = queue.poll();
            
            for(int d = 0; d < rowMask.length; d++){
                int newX = loc.x + rowMask[d];
                int newY = loc.y + colMask[d];
                
                if(newX < 0 || newY < 0 || newX >= matrix.length || newY >= matrix[0].length){
                    continue;
                }
                if(matrix[newX][newY] == -1){
                    matrix[newX][newY] = matrix[loc.x][loc.y] + 1;
                    queue.add(new Location(newX, newY));
                }
            } 
        }
        
        return matrix;
    }
}
