class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return makeTree(nums, 0, nums.length);
    }
    
    public TreeNode makeTree(int[] nums, int start, int end){
        if(start >= end){
            return null;
        }
        int maxId = getMaxId(nums, start, end);
        TreeNode root = new TreeNode(nums[maxId]);
        root.left = makeTree(nums, start, maxId);
        root.right = makeTree(nums, maxId + 1, end);
        return root;
    }
    
    public int getMaxId(int[] nums, int start, int end){
        int maxIdx = Integer.MIN_VALUE;
        int maxNum = Integer.MIN_VALUE;
        for(int i = start; i < end; i++){
            if(maxNum < nums[i]){
                maxNum = nums[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}

