class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() > t.length() || s.length() < t.length())
            return false;
        
        if(s.length() == 0)
            return true;    //both have length 0 hence result is true
        
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        
        HashMap<Character, Character> mapper = new HashMap<Character, Character>();
        HashSet<Character> mapped = new HashSet<Character>();
        for(int i = 0; i < sArr.length; i++){
            char sCh = sArr[i];
            char tCh = tArr[i];
            if(mapper.containsKey(tCh)){
                if(!mapper.get(tCh).equals(sCh))
                    return false;
                sArr[i] = tArr[i];
            }
            else{
                if(!mapped.contains(sCh)){
                    mapper.put(tCh, sCh);
                    mapped.add(sCh);
                }
                else
                    return false;
            }
        }
        return true;
    }
}
