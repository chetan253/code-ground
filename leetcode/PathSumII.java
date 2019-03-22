class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ans = new ArrayList();
        List<Integer> list = new ArrayList();
        pathSum(root, sum, 0, list);
        return ans;
    }
    
    public void pathSum(TreeNode node, int target, int sum, List<Integer> list){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null && (sum + node.val) == target){
            list.add(node.val);
            ans.add(new ArrayList(list));
            return;
        }
        list.add(node.val);
        if(node.left != null){
            pathSum(node.left, target, sum + node.val, list);
            list.remove(list.size() - 1);
        }
        if(node.right != null){
            pathSum(node.right, target, sum + node.val, list);
            list.remove(list.size() - 1);
        }
    }
}
