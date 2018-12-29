class Solution {
    public boolean isMonotonic(int[] A) {
        if(A == null || A.length == 0 || A.length ==1)
            return true;
        boolean increase = false;
        boolean decrease = false;
        int i = 1;
        while(i < A.length){
            if(A[i] <= A[i-1]){
                increase = true;
                i++;
                continue;
            }
            increase = false;
            break;
        }
        if(increase)
            return true;
        i = A.length - 2;
        while(i >= 0){
            if(A[i] <= A[i+1]){
                decrease = true;
                i--;
                continue;
            }
            decrease = false;
            break;
        }
        if(decrease)
            return true;
        return false;
    }
}
