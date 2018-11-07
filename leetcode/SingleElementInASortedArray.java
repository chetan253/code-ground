class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int ptr1 = 1;
        int ptr2 = nums.length - 2;
        
        while(ptr1 < ptr2){
            if(nums[ptr1] == nums[ptr1 - 1])
                ptr1+=2;
            else
                break;
            if(nums[ptr2] == nums[ptr2 + 1])
                ptr2-=2;
            else
                break;
        }
        
        if(nums[ptr1] != nums[ptr1 - 1]){
            return nums[ptr1] == nums[ptr1 + 1] ? nums[ptr1 - 1] : nums[ptr1];
        }
        return nums[ptr2] == nums[ptr2 - 1] ? nums[ptr2 + 1] : nums[ptr2];
    }
}
