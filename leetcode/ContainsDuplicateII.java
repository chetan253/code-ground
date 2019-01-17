class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length <= 1){
            return false;
        }
        
        for(int i = 0; i < nums.length; i++){
            int ptr =  i+1;
            while(ptr < nums.length && ptr - i <= k){
                if(nums[i] == nums[ptr]){
                    return true;
                }
                ptr++;
            }
        }
        
        return false;
    }
}
