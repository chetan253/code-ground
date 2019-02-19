class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();
        
        for(char c : T.toCharArray()){
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(char c : S.toCharArray()){
            if(!countMap.containsKey(c)){
                continue;
            }
            while(countMap.get(c) != 0){
                sb.append(c);
                countMap.put(c, countMap.get(c) - 1);
            }
            countMap.remove(c);
        }
        
        for(Map.Entry<Character, Integer> entry : countMap.entrySet()){
            int i = 0;
            while(i < entry.getValue()){
                sb.append(entry.getKey());
                i++;
            }
        }
        
        return sb.toString().trim();
    }
}
