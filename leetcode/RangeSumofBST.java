class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(L <= node.val && node.val <= R){
                sum += node.val;
            }
            if(L < node.val && node.left != null){
                stack.push(node.left);
            }
            if(node.val < R && node.right != null){
                stack.push(node.right);
            }
        }
        
        return sum;
    }
}
