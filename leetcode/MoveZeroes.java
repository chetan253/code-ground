class Solution {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void moveZeroes(int[] nums) {
        int lastZeroPos = 0;
        int i = 0;
        if(nums.length <= 1)
            return;
        for(i = 0; i < nums.length; i++){
            if(nums[i] != 0 ){
                swap(nums, i ,lastZeroPos);
                lastZeroPos++;
            }
        }
    }
}
