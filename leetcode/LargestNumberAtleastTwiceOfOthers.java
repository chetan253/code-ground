class Solution {
    public int dominantIndex(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int pos = -1, i = 0;
        for(int number : nums){
            if(number > largest){
                largest = number;
                pos = i;
            }
            i++;
        }
        i = 0;
        for(int number : nums){
            if(i != pos && 2 * number > nums[pos]){
                return -1;
            }
            i++;
        }
        
        return pos;
    }
}
