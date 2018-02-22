/*
	CTCI Problem 4.6 Successor
*/
import java.io.*;
class Node{
	int data;
	Node left, right, parent;
	public Node(int data){
		this.data = data;
		left = right = parent = null;
	}
}
class Successor{
	
	static Node getInorderSuccessor(Node node){
		
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
		
		Node root = node5;
		
		node5.left = node2;
		node5.right = node7;
		node2.parent = node5;
		node7.parent = node5;
		
		node2.left = node1;
		node2.right = node3;
		node1.parent = node2;
		node3.parent = node2;
		
		node7.left = node6;
		node7.right = node8;
		node6.parent = node7;
		node8.parent = node7;
		
		node3.right = node4;
		node8.right = node9;
		node4.parent = node3;
		node9.parent = node8;
		
		HashMap<Integer, Node> mapper = new HashMap<Integer, Node>();
		mapper.put(1,node1);
		mapper.put(2,node2);
		mapper.put(3,node3);
		mapper.put(4,node4);
		mapper.put(5,node5);
		mapper.put(6,node6);
		mapper.put(7,node7);
		mapper.put(8,node8);
		mapper.put(9,node9);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			int node = Integer.parseInt(br.readLine());
			Node successor = getInorderSuccessor(mapper.get(n));
			System.out.println(successor);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
