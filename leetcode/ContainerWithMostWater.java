class Solution {
    public int maxArea(int[] height){
        int max = 0;
        
        if(height.length < 2)
            return max;
        
        int i = 0, j = height.length - 1;
        while(i < j){
            int dist = j - i;
            int tempmax = dist * Math.min(height[i], height[j]);
            if(tempmax > max)
                max = tempmax;
            
            if(height[i] <= height[j]){
                i++;
                continue;
            }
            if(height[j] < height[i]){
                j--;
                continue;
            }
        }
        return max;
    }
}
