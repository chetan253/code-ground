/*
	CTCI Problem 4.10: Check if t2 is subtree of t1
*/
import java.io.*;

class Node{
	int data;
	Node left, right;
	public Node(int data){
		this.data = data;
	}
}

class CheckSubtree{

	static Node checkHead(Node head1, Node head2){
		if(head1.data == head2.data){
			return head1;
		}
		return (head2.data < head1.data) ? checkHead(head1.left, head2) : checkHead(head1.right, head2);
	}

	static boolean checkTree(Node node1, Node node2){
		if(node1 == null && node2 == null)
			return true;
		else if(node1 == null || node2 == null)
			return false;
		else if(node1.data != node2.data)
			return false;
		else 
			return checkTree(node1.left, node2.left) && checkTree(node1.right, node2.right);
	}
	
	static boolean check(Node head1, Node head2){
		Node head = checkHead(head1, head2);
		if(head == null)
			return false;
		if(head2 == null)
			return true;
		return checkTree(head, head2);
	}
	
	public static void main(String args[]){
		//Tree 1
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		
		//node5 is head node
		node5.left = node2;
		node5.right = node7;
		node2.left = node1;
		node2.right = node3;
		node7.left = node6;
		node7.right = node8;
		node3.right = node4;
		node8.right = node9;
		
		//Tree 2
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		//n2 is head node
		n2.left = n1;
		n2.right = n3;
		n3.right = n4;
		//n4.right = n5;	//Uncomment for other result
		System.out.println(check(node5, n2));
		
	}
}
