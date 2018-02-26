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
    public boolean checkBST(TreeNode node, Integer min, Integer max){
        if(node == null){
			return true;
		}
		if((min != null && node.val <= min) || (max != null && node.val >= max)){
			return false;
		}
		if( !checkBST(node.left, min, node.val) || !checkBST(node.right, node.val, max)){
			return false;
		}
		return true;
    }
    public boolean isValidBST(TreeNode root) {
        return checkBST(root, null, null);
    }
}
