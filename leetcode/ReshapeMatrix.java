class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums.length == 0){
            return nums;
        }
        int elemCount = nums.length * nums[0].length;
        boolean flag = (elemCount >= (r * c)) ? true : false;
        if(!flag){
            return nums;
        }
        
        int[][] reshaped = new int[r][c];
        int row = 0, col = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                reshaped[i][j] = nums[row][col++];
                if(col == nums[0].length){
                    row++;
                    col = 0;
                }
            }
        }
        return reshaped;
    }
}
