class Solution {
    public int heightChecker(int[] heights) {
        int[] hc = heights.clone();
        Arrays.sort(hc);
        
        int ctr = 0, i = 0;
        for(int height : hc){
            if(heights[i++] != height){
                ctr++;
            }
        }
        return ctr;
    }
}
