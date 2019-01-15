class Solution {
    public int repeatedNTimes(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : A){
            if(set.contains(num))
                return num;
            set.add(num);
        }
        
        throw null;
    }
}
