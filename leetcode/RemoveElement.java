class Solution {
    
    public void swap(int[] nums, int i, int pos){
        int temp = nums[i];
        nums[i] = nums[pos];
        nums[pos] = temp;
    }
    
    public int removeElement(int[] nums, int val) {
        int ctr = nums.length -1, count = 0;
        boolean flag = false;
        if(nums.length == 0){
            return 0;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val){
                while(ctr > i && !flag){
                    if(nums[ctr] != val){
                        swap(nums, i, ctr);
                        flag = true;
                    }
                    ctr--;
                }
                flag = false;
            }
            if(nums[i] == val)
                count++;
        }
        return nums.length - count;
    }
}
