class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] prodLtoR = new int[l], prodRtoL = new int[l];
        
        prodLtoR[0] = nums[0];
        for(int i = 1; i < l; i++){
            prodLtoR[i] = nums[i] * prodLtoR[i-1];
        }
        
        prodRtoL[l - 1] = nums[l - 1];
        for(int i = l - 2; i >= 0; i--){
            prodRtoL[i] = nums[i] * prodRtoL[i+1];
        }
        
        nums[0] = prodRtoL[1];
        nums[l-1] = prodLtoR[l-2];
        
        for(int i = 1; i < l-1; i++){
            nums[i] = prodLtoR[i-1] * prodRtoL[i+1];
        }
        
        return nums;
    }
}
