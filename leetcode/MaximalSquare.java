class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0)
            return 0;
        for(char[] row : matrix){
            if(row.length == 0)
                return 0;
        }
        int[][] arr = new int[matrix.length+1][matrix[0].length+1];
        int max = 0;
        for(int i = 1; i < arr.length; i++){
            for(int j = 1; j < arr[i].length; j++){
                if(matrix[i-1][j-1] == '0'){
                    arr[i][j] = 0;
                }
                else if(matrix[i-1][j-1] == '1'){
                    arr[i][j] = Math.min(arr[i-1][j-1], Math.min(arr[i-1][j], arr[i][j-1])) + 1;
                }
                max = (max > arr[i][j]) ? max : arr[i][j]; 
            }
        }
        
        return max*max;
    }
}
