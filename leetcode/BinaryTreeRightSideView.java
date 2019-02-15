class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans =  new ArrayList<Integer>();
        if(root == null){
            return ans;
        }
        TreeNode nullNode = new TreeNode(-1);
        ArrayDeque<TreeNode> queue = new ArrayDeque();
        queue.addLast(root);
        queue.addLast(nullNode);
        
        while(!queue.isEmpty()){
            TreeNode node = queue.pollFirst();
            if(node != null){
                if(node.left != null){
                    queue.addLast(node.left);
                }
                if(node.right != null){
                    queue.addLast(node.right);
                }
                if(queue.peekFirst() == nullNode){
                    queue.pollFirst();
                    ans.add(node.val);
                    queue.addLast(nullNode);
                }
            }
        }
        
        return ans;
    }
}
