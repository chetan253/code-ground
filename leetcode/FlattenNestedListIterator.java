public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<NestedInteger>();
        for(int i = nestedList.size() - 1; i >= 0; i--){
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()){
            NestedInteger ni = stack.peek();
            if(ni.isInteger()){
                return true;
            }
            stack.pop();
            List<NestedInteger> list = ni.getList();
            for(int i = list.size() - 1; i >= 0; i--){
                stack.push(list.get(i));
            }
        }
        
        return false;
    }
}
