class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList();
        findPair(candidates, target, 0, new ArrayList<Integer>(), combinations);
        return combinations;
    }
    
    public void findPair(int[] candidates, int rem, int start, List<Integer> temp, List<List<Integer>> combinations){
        if(rem < 0)
            return;
        if(rem == 0){
            combinations.add(new ArrayList(temp));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            temp.add(candidates[i]);
            findPair(candidates, rem - candidates[i], i, temp, combinations);
            temp.remove(temp.size()-1);
        }
    }
}
