class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int lMax = 0, rMax = 0, ctr = 0;
        while(l < r){
            if(height[l] < height[r]){
                if(height[l] >= lMax){
                    lMax = Math.max(lMax, height[l]);
                }
                else{
                    ctr += lMax - height[l];    
                }
                l++;
            }
            else {
                if(height[r] >= rMax){
                    rMax = Math.max(rMax, height[r]);
                }
                else{
                    ctr += rMax - height[r];    
                }
                r--;
            }
        }
        return ctr;
    }
}
