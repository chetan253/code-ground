class Solution {
    
    int[][] dirs = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    
    public boolean isValid(int[][] maze, int r, int c){
        return 
            r >= 0 && r < maze.length &&  
            c >= 0 && c < maze[0].length && 
            maze[r][c] == 0;
    }
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int rLen = maze.length;
        int cLen = maze[0].length;
        boolean[][] visited = new boolean[rLen][cLen];
        Queue<int[]> q = new LinkedList<int[]>();
        
        q.add(start);
        visited[start[0]][start[1]] = true;
        
        while(!q.isEmpty()){
            int[] p = q.poll();
            
            if(p[0] == destination[0] && p[1] == destination[1]){
                return true;
            }
            
            for(int[] d : dirs){
                int x = p[0]+d[0];
                int y = p[1]+d[1];
                
                while(isValid(maze, x, y)){
                    x += d[0];
                    y += d[1];
                }
                
                if(!visited[x - d[0]][y - d[1]]){
                    q.add(new int[]{x-d[0], y - d[1]});
                    visited[x - d[0]][y - d[1]] = true;
                }
            }
        }
        
        return false;
    }
}
