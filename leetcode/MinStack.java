class MinStack {

    Stack<Number> stack;
    
    class Number{
        int num, min;
        public Number(int num, int min){
            this.num = num;
            this.min = min;
        }
    }
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Number>();
    }
    
    public void push(int x) {
        if(stack.size() == 0){
            stack.push(new Number(x, x));
            return;
        }
        stack.push(new Number(x, Math.min(x, stack.peek().min)));
    }
    
    public void pop() {
        if(stack.size() > 0){
            stack.pop();
        }
    }
    
    public int top() {
        if(stack.size() > 0){
            return stack.peek().num;
        }
        return -1;
    }
    
    public int getMin() {
        if(stack.size() > 0){
            return stack.peek().min;
        }
        return 0;
    }
}

