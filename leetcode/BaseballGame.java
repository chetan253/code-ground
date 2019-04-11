class Solution {
    public int calPoints(String[] ops) {
        int sum = 0;
        Stack<Integer> s =  new Stack();
        
        for(int i = 0; i < ops.length; i++){
            switch(ops[i]){
                case "C":{
                    if(s.isEmpty()){
                        continue;
                    }
                    sum -= s.pop();
                    continue;
                }
                case "D":{
                    int last = s.isEmpty() ? 0 : s.peek();
                    last *= 2;
                    sum += last;
                    s.push(last);
                    continue;
                }
                case "+":{
                    int first = s.isEmpty() ? 0 : s.pop();
                    int second = s.isEmpty() ? 0 : s.pop();
                    int last2Sum = first + second;
                    sum += last2Sum;
                    s.push(second);
                    s.push(first);
                    s.push(last2Sum);
                    continue;
                }
                default:{
                    int num = Integer.parseInt(ops[i]);
                    sum += num;
                    s.push(num);
                }
            }
        }
        return sum;
    }
}
