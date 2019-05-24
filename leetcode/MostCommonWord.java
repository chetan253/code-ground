class Solution {
    
    public class WordFreq{
        int freq;
        String word;
        public WordFreq(int freq, String word){
            this.freq = freq;
            this.word = word;
        }
    }
    
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> banSet = new HashSet<String>();
        paragraph = paragraph.toLowerCase();
        for(String str : banned){
            banSet.add(str.toLowerCase());    //O(1)
        }
        
        String[] arr = paragraph.split("\\W+");
        HashMap<String,Integer> freqMap = new HashMap();
        for(String str : arr){
            int len = str.length();
            str = str.charAt(len-1) >= 'a' && str.charAt(len-1) <= 'z' ? str : str.substring(0, len-1);
            if(!banSet.contains(str)){
                freqMap.put(str, freqMap.getOrDefault(str, 0) + 1);
            }
        }
        
        PriorityQueue<WordFreq> pq = new PriorityQueue<WordFreq>(
            (WordFreq w1, WordFreq w2) -> (w2.freq - w1.freq)
        );
        
        for(Map.Entry<String, Integer> entry : freqMap.entrySet()){
            pq.add(new WordFreq(entry.getValue(), entry.getKey()));
        }
        
        return pq.peek().word;
    }
}
