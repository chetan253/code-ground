class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] indeg = new int[N+1];
        int[] outdeg = new int[N+1];
        
        for(int i = 0; i < trust.length; i++){
            indeg[trust[i][1]]++;
            outdeg[trust[i][0]]++;
        }
        
        for(int i = 1; i < N+1; i++){
            if(indeg[i] == N-1 && outdeg[i] == 0){
                return i;
            }
        }
        
        return -1;
    }
}
