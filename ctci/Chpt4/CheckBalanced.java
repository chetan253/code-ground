/*
	CTCI Problem 4.4 Check if a binary tree is balanced or not;
*/
import java.util.*;
import java.io.*;
class Node{
	int data;
	Node left, right;
	public Node(int data){
		this.data = data;
	}
}
class CheckBalanced{

	static int checkBalancing(Node node, int level){
		if(node == null){
			return level;
		}
		int result = Math.abs(getMaxDepth(node.left, level + 1) - getMaxDepth(node.right, level + 1));		
		return result == 0 ? 1 : 0;
	}
	
	static int getMaxDepth(Node node, int level){
		if(node == null){
			return level;
		}
		int leftDepth = getMaxDepth(node.left, level + 1);
		int rightDepth = getMaxDepth(node.right, level + 1);
		return Math.max(leftDepth, rightDepth);
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

		//for not balanced
		//Node node10 = new Node(10);
		//Node node11 = new Node(11);
		Node root = node5;
		
		node5.left = node2;
		node5.right = node7;
		node2.left = node1;
		node2.right = node3;
		node7.left = node6;
		node7.right = node8;
		node3.right = node4;
		node8.right = node9;
		
		//for not balanced
		//node9.right = node10;
		//node10.left = node11;
		int result = checkBalancing(root, 1);
		if(result == 1){
			System.out.println("Tree is balanced");
		}
		else{
			System.out.println("Tree is not balanced");
		}
	}
}
