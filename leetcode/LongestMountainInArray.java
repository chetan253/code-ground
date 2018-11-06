class Solution {
    public int longestMountain(int[] A) {
        if(A.length < 3){
            return 0;
        }
        int tempMax = 0;
        int max = 0;
        
        for(int i = 1; i < A.length - 1; i++){
            if(A[i-1] < A[i] && A[i] > A[i+1] ){
                tempMax++;
                int ptr1 = i-1;
                int ptr2 = i+1;
                while(ptr1 >= 0 && A[ptr1] < A[ptr1 + 1]){
                    ptr1--;
                    tempMax++;
                }
                while(ptr2 < A.length && A[ptr2 - 1] > A[ptr2]){
                    ptr2++;
                    tempMax++;
                }
                max = Math.max(max, tempMax);
                tempMax = 0;
            }
        }
        
        return max;
    }
}
