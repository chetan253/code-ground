class Solution {
    public void rotate(int[] nums, int k) {
        int[] nums1 = Arrays.copyOf(nums, nums.length);

        for(int i = 0; i < nums.length; i++){
            nums[(i+k)%nums1.length] = nums1[i];
        }
    }
}
