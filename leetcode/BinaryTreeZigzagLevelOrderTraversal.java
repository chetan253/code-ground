class Solution {
    
    List<List<Integer>> arrList = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return arrList;
        dfs(root, 0);
        return arrList;
    }
    
    public void dfs(TreeNode node, int level){
        if(node == null)
            return;
        if(level >= arrList.size()){
            arrList.add(new ArrayList<Integer>());
        }
        if(level % 2 == 0){
            arrList.get(level).add(node.val);
        }
        else{
            arrList.get(level).add(0, node.val);
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
