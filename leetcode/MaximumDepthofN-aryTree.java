class Solution {
    int maxDepth = 0;
    public int maxDepth(Node root) {
        if(root == null){
            return maxDepth;
        }
        getMaxDepth(root, 0);
        return maxDepth + 1;
    }
    
    public void getMaxDepth(Node node, int depth){
        if(node == null){
            return;
        }
        for(Node child : node.children){
            getMaxDepth(child, depth + 1);
        }
        maxDepth = Math.max(maxDepth, depth);
    }
}
