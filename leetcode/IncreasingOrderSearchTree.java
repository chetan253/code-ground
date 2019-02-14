class Solution {
    Queue<Integer> queue;
    public TreeNode increasingBST(TreeNode root) {
        queue = new ArrayDeque<Integer>();
        dfs(root);
        
        TreeNode parent = new TreeNode(queue.poll());
        TreeNode head = parent;
        while(!queue.isEmpty()){
            TreeNode node = new TreeNode(queue.poll());
            parent.right = node;
            parent = node;
        }
        
        return head;
    }
    
    public void dfs(TreeNode node){
        if(node == null){
            return;
        }
        
        dfs(node.left);
        queue.add(node.val);
        dfs(node.right);
    }
}
