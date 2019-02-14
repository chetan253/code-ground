class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> counter = new HashMap<String, Integer>();
        List<String> uncommonWords = new ArrayList<String>();
        
        for(String str : A.split(" ")){
            checkStr(str, counter);
        }
        for(String str : B.split(" ")){
            checkStr(str, counter);
        }
        for(Map.Entry<String, Integer> entry : counter.entrySet()){
            String key = entry.getKey();
            Integer count = entry.getValue();
            if(count == 1){
                uncommonWords.add(key);   
            }
        }
        
        return uncommonWords.toArray(new String[0]);
    }
    
    public void checkStr(String str, Map<String, Integer> counter){
        if(counter.containsKey(str)){
            int count = counter.get(str);
            counter.put(str, count + 1);
        }
        else{
            counter.put(str, 1);
        }
    }
}
