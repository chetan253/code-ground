class Solution {
    public void swap(int[] nums, int pos1, int pos2){
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }
    
    public void sortColors(int[] nums) {
        if(nums.length <= 1){
            return;
        }
        int i = 1;
        int j;
        while(i < nums.length){
            j = i;
            while(j > 0){
                if(nums[j] < nums[j-1]){
                    swap(nums, j, j-1);
                    j--;
                }
                else
                    break;
            }
            i++;
        }
    }
}
