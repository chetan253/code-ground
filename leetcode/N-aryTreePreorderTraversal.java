class Solution {
    
    public List<Integer> preorder(Node root) {
        List<Integer> preOrder = new ArrayList<Integer>();
        if(root == null)
            return preOrder;
        
        Deque<Node> queue = new ArrayDeque<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            preOrder.add(node.val);
            
            Stack<Node> tempStack = new Stack<Node>();
            for(Node n : node.children){
                tempStack.push(n);
            }
            
            while(!tempStack.empty()){
                queue.addFirst(tempStack.pop());
            }
        }
        return preOrder;
    }
}
