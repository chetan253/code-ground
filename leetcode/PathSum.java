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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        else{
            int currSum = sum - root.val;
            boolean subAns = false;
            if(root.left == null && root.right == null && currSum == 0)
                return true;
            if(root.left != null)
                subAns = subAns || hasPathSum(root.left, currSum);
            if(root.right != null)
                subAns = subAns || hasPathSum(root.right, currSum);
            return subAns;
        }
    }
}
