class Solution {
    
    public class ANode implements Comparable<ANode>{
        int val;
        int x;
        int y;
        
        public ANode(int val, int x, int y){
            this.val = val;
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(ANode b){
            if(this.x != b.x){
                return Integer.compare(this.x, b.x);
            }
            else{
                return Integer.compare(this.y, b.y);
            }
        }
    }
    
    public void dfs(TreeNode node, int x, int y, List<ANode> list){
        if(node != null){
            list.add(new ANode(node.val, x, y));            
            dfs(node.left, x-1, y+1, list);
            dfs(node.right, x+1, y+1, list);
        }
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        if(root ==null){
            return ans;
        }
        List<ANode> list = new ArrayList<ANode>();
        dfs(root, 0, 0, list);
        
        Collections.sort(list);
        ans.add(new ArrayList<Integer>());
        int prevX = list.get(0).x;
        for(ANode n : list){
            if(n.x != prevX){
                ans.add(new ArrayList<Integer>());
                prevX = n.x;
            }
            
            ans.get(ans.size()-1).add(n.val);
        }
        
        return ans;
    }
}
