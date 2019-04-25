class Solution {
    List<Integer> list;
    public void leftBoundary(TreeNode node){
        if(node == null || (node.left == null && node.right == null)){
            return;
        }
        list.add(node.val);
        if(node.left == null) leftBoundary(node.right);
        leftBoundary(node.left);
    }
    
    public void rightBoundary(TreeNode node){
        if(node == null || (node.left == null && node.right == null)){
            return;
        }
        if(node.right == null) rightBoundary(node.left);
        rightBoundary(node.right);
        list.add(node.val);
    }
    
    public void leaves(TreeNode node){
        if(node != null && node.left == null && node.right == null){
            list.add(node.val);
            return;
        }
        if(node == null){
            return;
        }
        leaves(node.left);
        leaves(node.right);
    }
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        list = new ArrayList<Integer>();
        if(root == null){
            return list;
        }
        list.add(root.val);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);
        
        return list;
    }
}
