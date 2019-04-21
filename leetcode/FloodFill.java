class Solution {
    int rowMask[] = new int[]{0,0,1,-1};
    int colMask[] = new int[]{1,-1,0,0};
    
    public boolean isValid(int[][] image, int i, int j, int oldColor){
        return
            i >= 0 && i < image.length &&
            j >= 0 && j < image[0].length &&
            image[i][j] == oldColor;
    }
    
    public void dfs(int[][] image, int i, int j, int oldColor, int newColor){
        image[i][j] = newColor;
        for(int k = 0; k < 4; k++){
            if(isValid(image, i+rowMask[k], j+colMask[k], oldColor)){
                dfs(image, i+rowMask[k], j+colMask[k], oldColor, newColor);
            }
        }
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] != newColor){
            dfs(image, sr, sc, image[sr][sc], newColor);
        }    
        return image;
    }
}
