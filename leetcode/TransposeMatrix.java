class Solution {
    public int[][] transpose(int[][] A) {
        int[][] transpose = new int[A[0].length][A.length];
        for(int i = 0, col = 0; i < A.length; i++, col++){
            for(int j = 0, row = 0; j < A[i].length; j++, row++){
                transpose[row][col] = A[i][j];
            }
        }
        return transpose;
    }
}
