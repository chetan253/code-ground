class Solution {
    
    HashMap<Integer, Integer> freqMap;
    int maxCtr;
    
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        if(root.left == null && root.right == null){
            return new int[]{root.val};
        }
        maxCtr = 0;
        
        freqMap = new HashMap<Integer, Integer>();
        dfs(root);
        List<Integer> ansList = new ArrayList<Integer>();
        for(Integer num : freqMap.keySet()){
            if(freqMap.get(num) == maxCtr){
                ansList.add(num);
            }
        }
        int[] ans = new int[ansList.size()];
        for(int i = 0; i < ans.length; i++){
            ans[i] = ansList.get(i);
        }
        
        return ans;
    }
    
    public int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftSum = dfs(node.left);
        int rightSum = dfs(node.right);
        int sum = node.val + leftSum + rightSum;
        freqMap.put(sum, freqMap.getOrDefault(sum, 1)+1);
        maxCtr = Math.max(maxCtr, freqMap.get(sum));
        return sum;
    }
}
