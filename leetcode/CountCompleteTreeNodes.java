class Solution {
    int count = 0;
    public int countNodes(TreeNode root) {
        if(root == null){
            return count;
        }
        count++;
        countNodes(root.left);
        countNodes(root.right);
        return count;
    }
}
