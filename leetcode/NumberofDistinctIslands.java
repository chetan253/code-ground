class Solution {
    int[] rowMask = new int[]{0, 0, 1, -1};
    int[] colMask = new int[]{1, -1, 0, 0};
    
    public boolean isValid(int[][] grid, int i, int j, int r, int c){
        return 
            (i >= 0 && i < r &&
            j >= 0 && j < c &&
            grid[i][j] == 1);
    }
    
    public List<Integer> dfs(int[][] grid, int i, int j, int r, int c, List<Integer> list){
        grid[i][j] = 0;
        for(int k = 0; k < 4; k++){
            if(isValid(grid, i+rowMask[k], j+colMask[k], r, c)){
                list.add(k);
                dfs(grid, i+rowMask[k], j+colMask[k], r, c, list);
            }
        }
        list.add(5);
        return list;
    }
    
    public int numDistinctIslands(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == 1){
                    set.add(dfs(grid, i, j, r, c, new ArrayList<Integer>()));
                }   
            }
        }
        return set.size();
    }
}
