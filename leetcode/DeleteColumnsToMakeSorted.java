class Solution {
    public int minDeletionSize(String[] A) {
        int ctr = 0;
        HashSet<Integer> colSet = new HashSet<>();
        
        for(int i = 1; i < A.length; i++){
            for(int j = 0; j < A[i].length(); j++){
                if(A[i].charAt(j) < A[i-1].charAt(j) && !colSet.contains(j)){
                    ctr++;
                    colSet.add(j);
                }
            }
        }
        
        return ctr;
    }
}
