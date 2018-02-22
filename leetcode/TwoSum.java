import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mapper = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            mapper.put(nums[i], i);
        }
        int firstIndice = 0;
        int secondNum = 0;
        for(int i = 0; i < nums.length; i++){
            firstIndice = i;
            secondNum = target - nums[i];
            if(mapper.containsKey(secondNum) && mapper.get(secondNum) != i){
                break;
            }
        }
        return new int[]{firstIndice, mapper.get(secondNum)};
    }
}
