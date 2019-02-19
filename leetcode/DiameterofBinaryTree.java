class Solution {
    int maxDiameter;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        if(root == null){
            return maxDiameter;
        }
        getDiameter(root);
        return maxDiameter - 1;
    }
    
    public int getDiameter(TreeNode node){
        if(node == null){
            return 0;
        }
        
        int leftHeight = getDiameter(node.left);
        int rightHeight = getDiameter(node.right);
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight + 1);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
