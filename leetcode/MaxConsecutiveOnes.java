class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxStreak = 0;
        int i = 0;
        while(i < nums.length){
            if(nums[i] == 1){
                int start = i;
                while(i < nums.length && nums[i] == 1)
                    i++;
                int end = i-1;
                maxStreak = Math.max(maxStreak, end - start + 1);
            }
            else
                i++;
        }
        return maxStreak;
    }
}
