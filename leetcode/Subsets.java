class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return backtrack(new ArrayList(), new ArrayList<Integer>(), nums, 0);
    }
    
    public List<List<Integer>> backtrack(List<List<Integer>> list, List<Integer> tempList, int nums[], int start){
        list.add(new ArrayList<Integer>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList,  nums, i+1);
            tempList.remove(tempList.size()-1);
        }
        return list;
    }
}
