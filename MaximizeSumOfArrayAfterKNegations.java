class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        int sum = 0, min = Integer.MAX_VALUE, minIdx = A.length;
        Arrays.sort(A);
        for(int i = 0; i < A.length; i++){
            if(K > 0 && A[i] < 0){
                A[i] = -A[i];
                K--;
            }
            if(A[i] < min){
                min = A[i];
                minIdx = i;
            }
        }
        
        if(min > 0){
            A[minIdx] = K % 2 == 1 ? -A[minIdx] : A[minIdx];
        }
        else{
            A[minIdx] = K % 2 == 0 ? A[minIdx] : -A[minIdx];
        }
        
        for(int i = 0; i < A.length; i++){
            sum += A[i];
        }
        
        return sum;
    }
}
