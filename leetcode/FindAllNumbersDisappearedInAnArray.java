class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappeared = new ArrayList<Integer>();
        
        if(nums.length == 0){
            return disappeared;
        }
        
        int[] arr = new int[nums.length + 1];
        Arrays.fill(arr, -1);
        
        for(int i = 0; i < nums.length; i++){
            arr[nums[i]] = 1;
        }
        
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == -1){
                disappeared.add(i);
            }
        }
        
        return disappeared;
    }
}
