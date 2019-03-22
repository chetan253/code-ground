class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode lNode = invertTree(root.left);
        TreeNode rNode = invertTree(root.right);
        root.left = rNode;
        root.right = lNode;
        
        return root;
    }
}
