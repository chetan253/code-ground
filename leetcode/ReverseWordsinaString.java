public class Solution {
    public String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");
        Stack<String> stack = new Stack<String>();
        for(String str : arr){
            stack.push(str);
        }
        
        StringBuilder builder = new StringBuilder();
        
        while(!stack.isEmpty()){
            builder.append(stack.pop());
            builder.append(" ");
        }
        
        return builder.toString().trim();
    }
}
