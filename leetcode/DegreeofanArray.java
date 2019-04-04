class Solution {
    public int findShortestSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> mapper = new HashMap<Integer, Integer>();
        
        for(int i : nums){
            mapper.put(i, mapper.getOrDefault(i, 0) + 1);
            max = Math.max(max, mapper.get(i));
        }
        
        HashMap<Integer, Integer> left, right;
        left = new HashMap<Integer, Integer>();
        right = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++){
            if(!left.containsKey(nums[i])){
                left.put(nums[i], i);
            }
            right.put(nums[i], i);
        }
        
        int min = Integer.MAX_VALUE;
        
        for(Map.Entry<Integer, Integer> entry : mapper.entrySet()){
            int num = entry.getKey();
            if(entry.getValue() == max){
                min = Math.min(min, right.get(num) - left.get(num) + 1);
            }
        }
        return min;
    }
}
