class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s = new Stack<Character>();
        Stack<Character> t = new Stack<Character>();
        
        for(char c : S.toCharArray()){
            if(c == '#'){
                if(!s.isEmpty()) s.pop();
                continue;
            }
            s.push(c);
        }
        
        for(char c : T.toCharArray()){
            if(c == '#'){
                if(!t.isEmpty()) t.pop();
                continue;
            }
            t.push(c);
        }
        
        while(!s.isEmpty() && !t.isEmpty()){
            if(s.pop() != t.pop()){
                return false;
            }
        }
        
        return s.isEmpty() && t.isEmpty() ? true : false;
    }
}
