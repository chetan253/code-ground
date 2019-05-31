class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        
        int[] ans = new int[A.length];
        HashMap<Integer, Integer> locs = new HashMap();
        
        for (int i = 0; i < B.length; ++i)
            locs.put(B[i], i);
        
        int pos = 0;
        for (int i = 0; i < A.length; i++)
            ans[i] = locs.get(A[i]);
        
        return ans;
    }
}
