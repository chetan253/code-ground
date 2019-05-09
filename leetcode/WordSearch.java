class Solution {
    
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    
    public boolean isValid(char[][] b, int r, int c, String s, int si){
        return 
            (r >= 0 && c >= 0 &&
             r < b.length && c < b[0].length &&
             b[r][c] != '#' && s.charAt(si) == b[r][c]
            );
    }
    
    public boolean dfs(char[][] b, int i, int j, int si, String s){
        if(si == s.length()){
            return true;
        }

        if(!isValid(b, i, j, s, si)){
            return false;
        }
        
        char ch = b[i][j];
        b[i][j] = '#';
        
        if(
            dfs(b, i+1, j, si+1, s) || dfs(b, i-1, j, si+1, s) ||
            dfs(b, i, j+1, si+1, s) || dfs(b, i, j-1, si+1, s)
            ){
            return true;
        }
        
        b[i][j] = ch;
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(word.charAt(0) == board[i][j] && dfs(board, i, j, 0, word)){
                    return true;
                }
            }
        }
        return false;
        
    }
}
