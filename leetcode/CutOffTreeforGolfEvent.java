class Solution {
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    
    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0) 
            return 0;
        
        int br = forest.size();
        int bc = forest.get(0).size();
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
        int[] start = new int[]{0,0};
        
        for(int i = 0; i < forest.size(); i++){
            for(int j = 0; j < forest.get(i).size(); j++){
                if(forest.get(i).get(j) > 1)
                    q.add(new int[]{i, j, forest.get(i).get(j)});
            }
        }
        int minStep = 0;
        while(!q.isEmpty()){
            int[] dest = q.poll();
            int step = bfs(forest, start, dest, br, bc);
            if(step < 0){
                return -1;
            }
            minStep+=step;
            start[0] = dest[0];
            start[1] = dest[1];
        }
        return minStep;
    }
    
    public int bfs(List<List<Integer>> forest, int[] start, int[] dest, int br, int  bc){
        boolean[][] visited = new boolean[br][bc];
        Queue<int[]> q = new ArrayDeque<int[]>();
        q.add(start);
        visited[start[0]][start[1]] = true;
        int dist = 0;
        while(!q.isEmpty()){
            int s = q.size();
            for(int i = 0; i < s; i++){
                int[] c = q.poll();

                if(c[0] == dest[0] && c[1] == dest[1]){
                    return dist;
                }
                for(int[] d : dirs){
                    int row = c[0] + d[0];
                    int col = c[1] + d[1];

                    if(row < 0 || col < 0 || row >= br || col >= bc || forest.get(row).get(col) == 0 || visited[row][col]){
                        continue;
                    }

                    visited[row][col] = true;
                    q.add(new int[]{row, col});
                }
            }
            dist++;
        }
        return -1;
    }
}
