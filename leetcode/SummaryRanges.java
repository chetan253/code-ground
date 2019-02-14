class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        
        for(int i = 0; i < nums.length; i++){
            int start = nums[i];
            
            while(i+1 < nums.length && Math.abs(nums[i+1] - nums[i]) == 1){
                i++;
            }
            
            if(start != nums[i]){
                int end = nums[i];
                list.add(new String(start+"->"+end));                
            }
            else{
                list.add(String.valueOf(start));
            }
        }
        
        return list;
    }
}
