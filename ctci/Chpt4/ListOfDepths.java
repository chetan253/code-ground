/*
	CTCI Problem 4.3 Depth Lists at each level of tree
*/
import java.io.*;
import java.util.*;
class Node{
	int data;
	Node left, right;
	public Node(int data){
		this.data = data;
		left = right = null;
	}
}
class ListOfDepths{
	static HashMap<Integer, ArrayList<Node>> mapper = new HashMap<Integer, ArrayList<Node>>();
	static int MAX_LEVEL = 1;
	static void makeList(Node node, int level){
		if(node == null){
			return;
		}
		MAX_LEVEL = level > MAX_LEVEL ? level : MAX_LEVEL;
		if(mapper.containsKey(level)){
			mapper.get(level).add(node);
		}else{
			mapper.put(level, new ArrayList<Node>());
			mapper.get(level).add(node);
		}
		makeList(node.left, level + 1);
		makeList(node.right, level + 1);
	}
	
	public static void main(String args[]){
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);
		Node node11 = new Node(11);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node4.left = node8;
		node4.right = node9;
		node5.left = node10;
		node5.right = node11;
		node3.left = node6;
		node3.right = node7;
		
		Node root = node1;
		makeList(root, 1);
		for(int i = 1; i <= MAX_LEVEL; i++){
			System.out.println("Printing nodes at level "+i);
			for(Node n : mapper.get(i)){
				System.out.print(n.data + " ");
			}
			System.out.println();
		}
	}
}
