class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if(root == null)
            return true;
        return isUnivalued(root, root.val);
    }
    
    public boolean isUnivalued(TreeNode node, int val){
        if(node == null){
            return true;
        }
        if(node.val != val){
            return false;
        }
        return isUnivalued(node.left, val) && isUnivalued(node.right, val);
    }
}
