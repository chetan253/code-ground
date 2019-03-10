class Solution {
    public int numRookCaptures(char[][] board) {
        int row = 0, col = 0;
        outer:
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    if(board[i][j] == 'R'){
                        row = i;
                        col = j;
                        break outer;
                    }
                }
            }
        int ctr = 0;
        for(int i = row + 1; i < 8; i++){
            if(board[i][col] != '.'){
                if(board[i][col] == 'p'){
                    ctr++;
                }
                break;
            }
        } 
        
        for(int i = row - 1; i >= 0; i--){
            if(board[i][col] != '.'){
                if(board[i][col] == 'p'){
                    ctr++;
                }
                break;
            }
        } 
        
        for(int i = col + 1; i < 8; i++){
            if(board[row][i] != '.'){
                if(board[row][i] == 'p'){
                    ctr++;
                }
                break;
            }
        } 
        
        for(int i = col - 1; i >= 0; i--){
            if(board[row][i] != '.'){
                if(board[row][i] == 'p'){
                    ctr++;
                }
                break;
            }
        }
        
        return ctr;
    }
}
