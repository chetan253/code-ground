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
    public int minDepth1(TreeNode node){
        if(node == null)
            return 0;
        if(node.left == null && node.right == null)
            return 1;
        if(node.left == null)
            return minDepth1(node.right) + 1;
        if(node.right == null)
            return minDepth1(node.left) + 1;
        return Math.min(minDepth1(node.left), minDepth1(node.right)) + 1;
    }
    public int minDepth(TreeNode root) {
        return minDepth1(root);
    }
}
