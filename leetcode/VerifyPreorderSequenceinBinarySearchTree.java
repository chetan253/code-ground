class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int root = Integer.MIN_VALUE;
        Stack<Integer> s = new Stack();
        for(int i = 0; i < preorder.length; i++){
            if(preorder[i] < root){
                return false;
            }
            while(!s.isEmpty() && preorder[i] > s.peek()){
                root = s.pop();
            }
            s.push(preorder[i]);
        }
        
        return true;
    }
}
