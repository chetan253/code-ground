class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int ptr1 = 0;
        int ptr2 = A.length - 1;
        
        while(ptr1 < ptr2){
            if(A[ptr1] > A[ptr2]){
                ptr2--;
            }
            else if(A[ptr1] < A[ptr2]){
                ptr1++;
            }
            else{
                ptr1++;
                ptr2--;
            }
        }
        return ptr1;
    }
}
