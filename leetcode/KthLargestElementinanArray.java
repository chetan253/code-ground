class Solution {
    public int findKthLargest(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new ValComparator());
        
        for(int num : nums){
            pq.add(num);
        }
        
        for(int i = 0; i < k-1; i++){
            pq.poll();
        }
        
        return pq.poll();
    }
}

class ValComparator implements Comparator<Integer>{
    public int compare(Integer num1, Integer num2){
        if(num1 < num2){
            return 1;
        }
        return -1;
    }
}
