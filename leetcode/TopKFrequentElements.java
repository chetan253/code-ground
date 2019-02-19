class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<Integer>();
        
        if(nums.length == 0){
            return ans;
        }
        
        HashMap<Integer, Integer> countMapper = new HashMap<>();
        
        for(int num : nums){
            countMapper.put(num, countMapper.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Element> queue = new PriorityQueue<>(countMapper.size(), new ElementComparator());
        
        for(Map.Entry<Integer, Integer> entry : countMapper.entrySet()){
            queue.add(new Element(entry.getKey(), entry.getValue()));
        }
        
        for(int i = 0; i < k; i++){
            ans.add(queue.poll().num);
        }
        
        return ans;
    }
}

class Element{
    public int num;
    public int count;
    
    public Element(int num, int count){
        this.num = num;
        this.count = count;
    }
}

class ElementComparator implements Comparator<Element>{
    public int compare(Element e1, Element e2){
        if(e1.count <= e2.count){
            return 1;
        }
        return -1;
    }
}
