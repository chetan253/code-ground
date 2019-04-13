class Solution {
    public int findPivot(int[] arr, int l, int h){
        if(arr[l] < arr[h]){
            return 0;
        }
        while(l <= h){
            int mid = (l + h) / 2;
            if(arr[mid] > arr[mid + 1]){
                return mid + 1;
            }
            else if(arr[mid] < arr[l]){
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return 0;
    }
    
    public int binSearch(int[] arr, int l, int  h, int target){
        while(l <= h){
            int mid = (l + h) / 2;
            if(target == arr[mid]){
                return mid;
            }
            else if(target < arr[mid]){
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        
        return -1;
    }
    
    public int search(int[] nums, int target) {
        if(nums.length== 0){
            return -1;
        }
        if(nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }
        int pivot = findPivot(nums, 0, nums.length - 1);
        if(pivot == 0){
            return binSearch(nums,0, nums.length - 1, target);
        }
        else if(target < nums[0]){
            return binSearch(nums, pivot, nums.length -1, target);
        }
        return binSearch(nums, 0, pivot, target);
    }
}
