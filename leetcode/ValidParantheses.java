import java.util.*;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        if(s.length() % 2 != 0)
            return false;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{')
                stack.push(c);
            else if(!stack.empty()){
                char comp = stack.pop();
                if(c == ')' && comp == '(')
                    continue;
                else if(c == '}' && comp == '{')
                    continue;
                else if(c == ']' && comp == '[')
                    continue;
                else
                    return false;
            }
            else
                return false;
        }
        return stack.empty() ? true : false;
    }
}
