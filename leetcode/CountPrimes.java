class Solution {
    public int countPrimes(int n) {
        boolean[] m = new boolean[n];
        int ctr = 0;
        for(int i = 2; i < n; i++){
            if (m[i])
                continue;
             
            ctr++;
            for (int j=i; j < n; j+=i)
                m[j] = true;
        }
        return ctr;
    }
}
