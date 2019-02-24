class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int val = -1;
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        TreeNode nullNode = new TreeNode(-1);
        queue.addLast(nullNode);
        queue.addLast(root);
	
        while(!queue.isEmpty()){
            TreeNode node = queue.pollFirst();
            if(node == nullNode){
                if(!queue.isEmpty()){
                    val = queue.peekFirst().val;
                    queue.addLast(node);    
                }
                continue;
            }
            if(node.left != null){
                queue.addLast(node.left);
            }
            if(node.right != null){
                queue.addLast(node.right);
            }
        }
	    
        return val;
    }
}
