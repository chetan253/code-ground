/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int ans;
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        getMax(root);
        return ans;
    }
    
    public int getMax(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = Math.max(getMax(root.left),0);
        int right = Math.max(getMax(root.right),0);
        ans = Math.max(ans, left+right+root.val);
        return Math.max(left, right)+root.val;
    }
}
