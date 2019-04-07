/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

//DFS
class Solution {
    HashMap<Node, Node> map = new HashMap<Node, Node>();
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node newNode = new Node(node.val, new ArrayList<Node>());
        map.put(node, newNode);
        for(Node neighbor : node.neighbors){
            newNode.neighbors.add(cloneGraph(neighbor));
        }
        
        return newNode;
    }
}i

//BFS
class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> cloneMap = new HashMap<Node, Node>();
        Queue<Node> queue = new ArrayDeque<Node>();
        queue.add(node);
        Node cloned = new Node(node.val, new ArrayList<Node>());
        cloneMap.put(node, cloned);
        
        while(!queue.isEmpty()){
            Node n = queue.poll();
            for(Node ne : n.neighbors){
                Node clone = null;
                if(!cloneMap.containsKey(ne)){
                    queue.add(ne);
                    clone = new Node(ne.val, new ArrayList<>());
                    cloneMap.put(ne, clone);
                }
                cloneMap.get(n).neighbors.add(cloneMap.get(ne));
            }
        }
        
        return cloned;
    }
}
