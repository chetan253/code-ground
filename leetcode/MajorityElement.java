class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> mapper = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(mapper.containsKey(nums[i])){
                mapper.put(nums[i], mapper.get(nums[i])+1);
            }
            else{
                mapper.put(nums[i], 1);
            }
        }
        
        for(Map.Entry<Integer, Integer> entry : mapper.entrySet()){
            if(entry.getValue() > (nums.length/2)){
                return entry.getKey();
            }
        }
        return -1;
    }
}
