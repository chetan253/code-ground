class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int num : nums){
            set.add(num);
        }
        
        int count = 0, maxCount = 0;
        
        for(int num : set){
            count++;
            int temp = num;
            while(set.contains(temp - 1)){
                count++;
                temp--;
            }
            temp = num;
            while(set.contains(temp + 1)){
                count++;
                temp++;
            }
            maxCount = Math.max(count, maxCount);
            count = 0;
        }
        return maxCount;
    }
}
