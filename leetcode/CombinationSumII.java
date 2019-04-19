class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList(); 
        dfs(candidates, new ArrayList<Integer>(), 0, ans, target);
        return ans;
    }
    
    public void dfs(int[] candidates, List<Integer> tempList, int start, List<List<Integer>> ans, int k){
        if(k == 0){
            ans.add(new ArrayList<Integer>(tempList));
            return;
        }
        if(k < 0){
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(i > start && candidates[i] == candidates[i-1])
                continue;
            tempList.add(candidates[i]);
            dfs(candidates, tempList, i+1, ans, k - candidates[i]);
            tempList.remove(tempList.size()-1);
        }
    }
}
