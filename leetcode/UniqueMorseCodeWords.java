class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String codes[] = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<String>();
        
        for(String str : words){
            String morse = "";
            for(char c : str.toCharArray()){
                morse += codes[c - 'a'];
            }
            set.add(morse);
        }
        
        return set.size();
    }
}
