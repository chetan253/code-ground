class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int res1 = nums[0] * nums[1] * nums[nums.length-1];
        int res2 = nums[nums.length - 3] * nums[nums.length - 2] * nums[nums.length - 1];
        return res1 > res2 ? res1 : res2;
    }
}
