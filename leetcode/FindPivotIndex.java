class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int tempSum = 0;
        for(int i = 0; i < nums.length; i++){
            if(tempSum == sum - nums[i] - tempSum){
                return i;
            }
            tempSum += nums[i];
        }
        
        return -1;
    }
}
