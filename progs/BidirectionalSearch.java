import java.util.*;

public class BidirectionalSearch {

    public static class Node{
        int val;
        List<Node> neighbors;
        public Node(int val){
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }

    public static boolean bfs(Node root, Node destination){

        Queue<Node> queueA = new ArrayDeque<>();
        Queue<Node> queueB = new ArrayDeque<>();

        HashSet<Node> setA = new HashSet<>();
        HashSet<Node> setB = new HashSet<>();

        queueA.add(root);
        queueB.add(destination);
        setA.add(root);
        setB.add(destination);

        while(!queueA.isEmpty() || !queueB.isEmpty()) {
            if (doesPathExist(queueA, setA, setB)) {
                return true;
            } else if (doesPathExist(queueB, setB, setA)) {
                return true;
            }
        }
        return false;
    }

    public static boolean doesPathExist(Queue<Node> queue, HashSet<Node> setA, HashSet<Node> setB){

        Node node = queue.poll();
        if(node == null){
            return false;
        }
        for(Node neigh : node.neighbors) {
            if (setB.contains(neigh)) {
                return true;
            } else if(!setA.contains(neigh)){
                queue.add(neigh);
                setA.add(neigh);
            }
        }
        return false;
    }

    public static void main(String args[]){
        Node n0 = new Node(1);
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(1);
        Node n4 = new Node(1);
        Node n5 = new Node(1);
        Node n6 = new Node(1);
        Node n7 = new Node(1);
        Node n8 = new Node(1);
        Node n9 = new Node(1);
        Node n10 = new Node(1);
        Node n11 = new Node(1);
        Node n12 = new Node(1);
        Node n13 = new Node(1);
        Node n14 = new Node(1);

        n0.neighbors.add(n4);
        n1.neighbors.add(n4);
        n4.neighbors.addAll(Arrays.asList(n0,n1,n6));

        n2.neighbors.add(n5);
        n3.neighbors.add(n5);
        n5.neighbors.addAll(Arrays.asList(n2,n3,n6));

        n6.neighbors.addAll(Arrays.asList(n4,n5,n7));
        n7.neighbors.addAll(Arrays.asList(n6,n8));

        n8.neighbors.addAll(Arrays.asList(n7,n9,n10));

        n9.neighbors.addAll(Arrays.asList(n8,n11,n12));
        n11.neighbors.add(n9);
        n12.neighbors.add(n9);

        n10.neighbors.addAll(Arrays.asList(n8,n13,n14));
        n13.neighbors.add(n10);
        n14.neighbors.add(n10);

        System.out.println(bfs(n0, n14));
    }
}

