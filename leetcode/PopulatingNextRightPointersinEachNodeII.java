class Solution {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        ArrayDeque<Node> queue = new ArrayDeque<Node>();
        Node nullNode = new Node();
        
        queue.addLast(root);
        queue.addLast(nullNode);
        
        while(!queue.isEmpty()){
            Node node = queue.pollFirst();
            if(node != null){
                if(node.left != null){
                    queue.addLast(node.left);
                }
                if(node.right != null){
                    queue.addLast(node.right);
                }
                node.next = queue.peekFirst() == nullNode ? null : queue.peekFirst();
                if(queue.peekFirst() == nullNode){
                    queue.addLast(queue.pollFirst());
                }
            }
        }
        
        return root;
    }
}
