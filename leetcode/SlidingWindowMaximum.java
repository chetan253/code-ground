class Solution {
    
    public class Element{
        int pos, val;
        public Element(int pos, int val){
            this.pos = pos;
            this.val = val;
        }
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        
        if(k == 0 || k > nums.length || nums.length == 0){
            return new int[]{};
        }
        
        List<Integer> ans = new ArrayList<Integer>();
        
        PriorityQueue<Element> pq = new PriorityQueue<Element>(
            (Element a, Element b) -> (
                b.val - a.val
            )
        );
        
        int i = 0, j = 0;
        while(j < k){
            pq.add(new Element(j, nums[j]));
            j++;
        }
        i++;
        
        ans.add(pq.peek().val);
        
        while(j < nums.length){
            pq.add(new Element(j, nums[j]));
            while(pq.peek().pos < i){
                pq.poll();
            }
            ans.add(pq.peek().val);
            i++;
            j++;
        }
        
        int arr[] = new int[ans.size()];
        
        for(i = 0; i < ans.size(); i++){
            arr[i] = ans.get(i);
        }
        
        return arr;
    }
}
