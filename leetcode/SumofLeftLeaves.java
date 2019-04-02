iclass Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, -1);
    }
    
    public int dfs(TreeNode node, int dir) {
        if(node == null){
            return 0;
        }
        if(dir == 0 && node.left == null && node.right == null){
            return node.val;
        }
        return dfs(node.left, 0) + dfs(node.right, 1);
    }   
}
