class Solution {

    public class CharFreq{
        char ch;
        int freq;
        
        public CharFreq(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }

    public String frequencySort(String s) {
        if(s.length() <= 1 || s == null){
            return s;
        }
        
        HashMap<Character, Integer> mapper = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()){
            mapper.put(c, mapper.getOrDefault(c, 0) + 1);
        }
        
        List<CharFreq> freqs = new ArrayList<CharFreq>();
        for(Map.Entry<Character, Integer> entry : mapper.entrySet()){
            freqs.add(new CharFreq(entry.getKey(), entry.getValue()));
        }
        
        Collections.sort(freqs, (a, b) -> b.freq - a.freq);
        
        StringBuilder builder = new StringBuilder();
        Iterator<CharFreq> itr = freqs.listIterator(); 
        while(itr.hasNext()){
            CharFreq cf = itr.next();
            for(int i = 0; i < cf.freq; i++){
                builder.append(cf.ch);
            }
        }return builder.toString();
        
        
    }
}
