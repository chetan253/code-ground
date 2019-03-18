class LRUCache {
    
    HashMap<Integer, Node> nodeMap;
    int capacity;
    Node head, tail;
    
    // Node will be used for representing Doubly Linked List
    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        
        public Node(){}
        
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<Integer, Node>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!nodeMap.containsKey(key)){
            return -1;
        }
        
        Node ans = nodeMap.get(key);
        ans.prev.next = ans.next;
        ans.next.prev = ans.prev;
        
        // Make ans as starting element of DLL
        ans.next = head.next;
        ans.next.prev = ans;
        
        // Manage head and root of DLL
        head.next = ans;
        ans.prev = head;
        
        return ans.val;
    }
    
    public void put(int key, int value) {
        // If key already exists the update operation will be performed
        if(nodeMap.containsKey(key)){
            Node node = nodeMap.get(key);
            node.val = value;
            get(key);
            return;
        }
        // If capacity is reached remove/evict last element from queue as well as nodeMap
        if(nodeMap.size() == capacity){
            Node evict = tail.prev;
            evict.prev.next = tail;
            evict.next.prev = evict.prev;
            
            nodeMap.remove(evict.key);
        }
        
        Node node = new Node(key, value);
        
        // Make this node as root after head node
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
        
        // Make entry in nodeMap
        nodeMap.put(key, node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
