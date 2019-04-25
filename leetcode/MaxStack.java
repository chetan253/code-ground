class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> maxStack;
    
    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<Integer>();
        maxStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        int max = maxStack.isEmpty() ? x : maxStack.peek();
        maxStack.push(max > x ? max : x);
        stack.push(x);
    }
    
    public int pop() {
        maxStack.pop();
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        
        Stack<Integer> buffer = new Stack<Integer>();
        while(stack.peek() != peekMax()){
            buffer.push(pop());
        }
        int m = pop();
        while(!buffer.isEmpty()){
            push(buffer.pop());
        }
        return m;
    }
}
