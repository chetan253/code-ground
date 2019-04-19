import javafx.util.Pair; 

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap();
        for(String word : words){
            map.put(word, map.getOrDefault(word,0) + 1);
        }
        
        PriorityQueue<Pair<String, Integer>> pq = new PriorityQueue<Pair<String, Integer>>(
            (a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : 
            b.getValue() - a.getValue()
        );
        
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            pq.add(new Pair<String, Integer>(entry.getKey(), entry.getValue()));
        }
        
        List<String> ans = new ArrayList<String>();
        
        while(k > 0 && pq.size() != 0){
            --k;
            ans.add(pq.poll().getKey());
        }
                
        return ans;
    }
    
}
