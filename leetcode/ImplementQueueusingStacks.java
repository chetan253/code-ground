class MyQueue {
    Stack<Integer> pushS, popS;
    public enum Type{
        PUSH, POP;
    }
    Type active;
    /** Initialize your data structure here. */
    public MyQueue() {
        pushS = new Stack<Integer>();
        popS = new Stack<Integer>();
        active = Type.PUSH;
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(active != Type.PUSH){
            while(!popS.isEmpty()){
                pushS.push(popS.pop());
            }
            active = Type.PUSH;
        }
        pushS.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(active != Type.POP){
            while(!pushS.isEmpty()){
                popS.push(pushS.pop());
            }
            active = Type.POP;
        }
        return popS.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(active != Type.POP){
            while(!pushS.isEmpty()){
                popS.push(pushS.pop());
            }
            active = Type.POP;
        }
        return popS.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return pushS.size() == 0 && popS.size() == 0 ;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
