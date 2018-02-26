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
    public int getMaxDepth(TreeNode node){
        if(node == null)
            return 0;
        if(node.left == null && node.right == null)
            return 1;
        if(node.left == null)
            return getMaxDepth(node.right)+1;
        if(node.right == null)
            return getMaxDepth(node.left)+1;
        return Math.max(getMaxDepth(node.left), getMaxDepth(node.right))+1;
    }
    public boolean checkBalanced(TreeNode node){
        if(node == null)
            return true;
        int rightDepth = getMaxDepth(node.right);
        int leftDepth = getMaxDepth(node.left);
        if(Math.abs(rightDepth - leftDepth) > 1)
            return false;
        return checkBalanced(node.left) && checkBalanced(node.right);
    }
    public boolean isBalanced(TreeNode root) {
        return checkBalanced(root);
    }
}
