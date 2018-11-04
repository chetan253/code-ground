public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        root.next = null;
        connectNext(root);
        return;
    }
    
    public void connectNext(TreeLinkNode node){
        if(node == null)
            return;
        if(node.left != null)
            node.left.next = node.right;
        if(node.right != null)
            if(node.next != null){
                if(node.next.left != null)
                    node.right.next = node.next.left;
                else if(node.next.right != null)
                    node.right.next = node.next.right;
                else
                    node.right.next = null;
            }
        
        connectNext(node.left);
        connectNext(node.right);
    }
}
