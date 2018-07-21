class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i = 0; i < A.length; i++){
            int jstart = 0;
            int jend = A[i].length - 1;
            
            while(jstart <= jend){
                if(A[i][jstart] == 1 && A[i][jend] == 1){
                    A[i][jstart] = 0;
                    A[i][jend] = 0;
                }
                else if((A[i][jstart] == 1 && A[i][jend] == 0) || (A[i][jstart] == 0 && A[i][jend] == 1)){
                    jstart++;
                    jend--;
                    continue;
                }
                else if(A[i][jstart] == 0 && A[i][jend] == 0){
                    A[i][jstart] = 1;
                    A[i][jend] = 1;
                }
                else if(jstart == jend && A[i][jstart] == 0)
                    A[i][jstart] = 1;
                else if(jstart == jend && A[i][jstart] == 1)
                    A[i][jstart] = 0;
                jstart++;
                jend--;
            }
        }
        return A;
    }
}
