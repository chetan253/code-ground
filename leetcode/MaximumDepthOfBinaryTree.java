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
    public int maxDepth1(TreeNode node){
        if(node == null)
            return 0;
        if(node.left == null && node.right == null)
            return 1;
        if(node.left == null)
            return maxDepth1(node.right) + 1;
        if(node.right == null)
            return maxDepth1(node.left) + 1;
        return Math.max(maxDepth1(node.left), maxDepth1(node.right)) + 1;
    }
    public int maxDepth(TreeNode root) {
        return maxDepth1(root);
    }
}
