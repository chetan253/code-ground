class Solution {
    
    public int evaluate(int num1, int num2, String exp){
        switch(exp){
            case "+" : {
                return num1 + num2;
            }
            case "-" : {
                return num1 - num2;
            }
            case "*" : {
                return num1 * num2;
            }
            case "/" : {
                if(num2 != 0)
                    return num1 / num2;
            }
        }
        return 0;
    }
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<Integer>();
        for(String token : tokens){
            try{
                int num = Integer.parseInt(token);
                s.push(num);
            }
            catch(Exception e){
                int num2 = s.isEmpty() ? 0 : s.pop();
                int num1 = s.isEmpty() ? 0 : s.pop();
                s.push(evaluate(num1, num2, token));
            }
        }
        return s.pop();
    }
}


