 class Solution {
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<String>();
        if(root == null){
            return ans;
        }
        dfs(root, "", ans);
        return ans;
    }
    
    public void dfs(TreeNode node, String temp, List<String> ans){
        if(node.left == null && node.right == null){
            ans.add(temp+node.val);
            return;
        }
        if(node.left != null){
            dfs(node.left, temp+String.valueOf(node.val)+"->", ans);
        }
        if(node.right != null){
            dfs(node.right, temp+String.valueOf(node.val)+"->", ans);
        }
    }
    
}
