class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0;
        
        for(int i : A){
            sumA += i;
        }
        for(int i :  B){
            sumB += i;
        }
        
        int difference = (sumB - sumA) / 2;
        
        HashSet<Integer> setB = new HashSet<>();
        for(int i : B){
            setB.add(i);
        }
        
        for(int i : A){
            if(setB.contains(i + difference))
                return new int[]{i, i + difference};
        }
        
        return new int[]{};
    }
}
