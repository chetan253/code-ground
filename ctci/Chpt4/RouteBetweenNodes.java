/*
	CTCI Problem 4.1
*/
import java.io.*;
import java.util.*;

class Node{
	int data;
	ArrayList<Node> children = new ArrayList<Node>();
	public Node(int data){
		this.data = data;
	}
}

class RouteBetweenNodes{
	static HashMap<Integer, Node> map = new HashMap<Integer, Node>();

	static boolean checkPath(int src, int dest){
		Node source = map.get(src);
		Node destination = map.get(dest);
		LinkedList<Node> list = new LinkedList<Node>();
		HashSet<Node> set = new HashSet<Node>();		
		list.add(source);
		set.add(source);
		while(!(list.peek() == null)){
			Node node = list.poll();	//BFS Traversal
			
			if(node == destination){
				return true;
			}
			for(Node n : node.children){
				if(set.contains(n)){
					continue;
				}
				list.add(n);
				set.add(n);
			}
		}
		return false;
	}
	public static void main(String args[]){
		Node node0 = new Node(0);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		node0.children.add(node1);
		node0.children.add(node4);
		node0.children.add(node5);
		node1.children.add(node2);
		node1.children.add(node3);
		node1.children.add(node4);
		node3.children.add(node2);
		node3.children.add(node4);
		
		map.put(0, node0);
		map.put(1, node1);
		map.put(2, node2);
		map.put(3, node3);
		map.put(4, node4);
		map.put(5, node5);
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter source node: ");
		int source = scan.nextInt();
		System.out.print("Enter destination node: ");
		int destination = scan.nextInt();
		
		System.out.println("Path exists? "+checkPath(source, destination));
	}
}
