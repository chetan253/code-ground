class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        List<Integer> seq1 = new ArrayList();
        List<Integer> seq2 = new ArrayList();
        
        helper(root1, seq1);
        helper(root2, seq2);
        
        if(seq1.size() != seq2.size()){
            return false;
        }
        
        for(int i = 0; i < seq1.size(); i++){
            if(seq1.get(i) != seq2.get(i)){
                return false;
            }
        }
        return true;
    }
    
    public void helper(TreeNode n, List<Integer> seq){
        if(n == null){
            return;
        }
        if(n.left == null && n.right == null){
            seq.add(n.val);
        }
        helper(n.left, seq);
        helper(n.right, seq);
        return;
    }
}
