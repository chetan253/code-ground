class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] arr = new int[A.length];
        int ctr = 0;
        for(int num : A){
            if(num % 2 == 0)
                arr[ctr++] = num;
        }
        for(int num : A){
            if(num % 2 != 0)
                arr[ctr++] = num;
        }
        return arr;
    }
}
