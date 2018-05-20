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
    List<List<Integer>> arrList = new ArrayList<List<Integer>>();
    public void traverse(TreeNode node, int level){
        if(node == null)
            return;
        if(level >= arrList.size()){
            arrList.add(new ArrayList<Integer>());
        }
        arrList.get(level).add(node.val);
        traverse(node.left, level+1);
        traverse(node.right, level+1);
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return arrList;
        traverse(root, 0);
        return arrList;
    }
}
