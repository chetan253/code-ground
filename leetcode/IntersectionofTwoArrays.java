class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> ansSet = new HashSet<>();
        
        for(int i : nums1){
            set.add(i);
        }
        
        for(int i : nums2){
            if(set.contains(i))
                ansSet.add(i);
        }
        
        int arr[] = new int[ansSet.size()];
        int i = 0;
        
        for(int num : ansSet){
            arr[i++] = num;
        }
        
        return arr;
    }
}
