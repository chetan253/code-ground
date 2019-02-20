class Solution {
    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        int sum = (nums.length*(nums.length + 1))/2;
        int missing = -1, duplicate = -1;
        int arrSum = 0;
        
        for(int num : nums){
            arrSum += num;
            if(set.contains(num)){
                duplicate = num;
            }
            set.add(num);
        }
        
        missing = sum - (arrSum - duplicate);
        
        return new int[]{duplicate, missing};
    }
}
