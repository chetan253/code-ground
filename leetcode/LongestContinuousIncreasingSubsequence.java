class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        
        int max = 1,  tempMax = 1;
        
        for(int i = 1 ; i <  nums.length; i++){
            
            if(nums[i] > nums[i-1]){
                max++;
            }
            else{
                max = 1;
            }
            
            tempMax = Math.max(max, tempMax);
        }
        return tempMax;
    }
}
