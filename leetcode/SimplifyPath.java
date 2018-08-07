class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String s : arr){
            if(s.equals(".")||s.equals(""))
                continue;
            else if(s.equals(".."))
                if(!stack.empty()){
                    stack.pop();
                }
                else
                    continue;
            else{
                String dir = "/";
                dir+=s;
                stack.push(dir);
            }
        }
        if(stack.empty())
            stack.push("/");
        StringBuilder simplified = new StringBuilder("");
        while(!stack.empty()){
            simplified.insert(0,stack.pop());
        }
        return simplified.toString();
    }
}
