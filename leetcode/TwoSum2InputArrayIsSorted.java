class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers.length < 2){
            return null;
        }
        int i = 0, i2 = 0;
        for(i = 0; i < numbers.length - 1; i++){
            int complement = target - numbers[i];
            i2 = binSearch(numbers, i+1, numbers.length - 1, complement);
            if(i2 != -1){
                break;
            }
        }
        return new int[]{i+1, i2+1};
    }
    
    public int binSearch(int nums[], int start, int end, int target){
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(target < nums[mid]){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return -1;
    }
}
