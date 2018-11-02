class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int[] arr = new int[A.length];
        int even = 0;
        int odd = 1;
        for(int i = 0; i < A.length; i++){
            if(A[i] % 2 == 0){
                arr[even] = A[i];
                even += 2;
            }
            else{
                arr[odd] = A[i];
                odd += 2;
            }
        }
        return arr;
    }
}
