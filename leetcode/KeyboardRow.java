class Solution {
    public String[] findWords(String[] words) {
        if(words.length == 0){
            return new String[0];
        }
        
        HashSet<Character> row1 = new HashSet<Character>(Arrays.asList('q','w','e','r','t','y','u','i','o','p'));
        HashSet<Character> row2 = new HashSet<Character>(Arrays.asList('a','s','d','f','g','h','j','k','l'));
        HashSet<Character> row3 = new HashSet<Character>(Arrays.asList('z','x','c','v','b','n','m'));
        
        String s = "";
        for(String str : words){
            String temp = str.toLowerCase();
            if(row1.contains(temp.charAt(0))){
                if(checkChar(temp, row1)){
                    s += str+","; 
                    continue;
                }
            }
            if(row2.contains(temp.charAt(0))){
                if(checkChar(temp, row2)){
                    s += str+","; 
                    continue;
                }
            }
            if(row3.contains(temp.charAt(0))){
                if(checkChar(temp, row3)){
                    s += str+","; 
                    continue;
                }
            }
        }
        return s.length() != 0 ? s.split(",") : new String[0];
    }
    
    public boolean checkChar(String str, HashSet<Character> set){
        for(char c : str.toCharArray()){
            if(!set.contains(c)){
                return false;
            }
        }
        
        return true;
    }
}
