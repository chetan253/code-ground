class Solution {
    
    String ans;
    
    public String smallestFromLeaf(TreeNode root) {
        ans = null;
        dfs(root, "");
        return ans;
    }
    
    public void dfs(TreeNode node, String temp){
        char ch = (char)(node.val + 97);
        
        if(node.left == null && node.right == null){
            String s = ch+temp;
            
            if(ans == null || s.compareTo(ans) < 0){
                ans = s;
            }
            return;
        }
        if(node.left != null){
            dfs(node.left, ch+temp);
        }
        if(node.right != null){
            dfs(node.right, ch+temp);
        }
    }
}
