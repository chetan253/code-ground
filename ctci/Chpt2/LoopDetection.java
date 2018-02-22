/*
	CTCI Problem 2.8 Loop Detection
*/

import java.io.*;
import java.util.*;

class Node{
	char data;
	Node next;
	public Node(char data){
		this.data = data;
	}
}
class MultiReturn{
	boolean found = false;
	Node node;
}
class LoopDetection{
	static MultiReturn detectLoop(Node head){
		MultiReturn result = new MultiReturn();
		HashSet<Node> set = new HashSet<Node>();
		Node node = head;
		while(node != null){
			if(!set.contains(node)){
				set.add(node);
				node = node.next;
				continue;
			}
			result.found = true;
			result.node = node;
			return result;
		}
		return result;
	}
	
	public static void main(String args[]){
		Node n1 = new Node('A');
		Node n2 = new Node('B');
		Node n3 = new Node('C');
		Node n4 = new Node('D');
		Node n5 = new Node('E');
		Node n6 = new Node('F');
		Node head = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		
		//Creating loop ('F' -> 'C')	
		n6.next = n3;
		
		MultiReturn result = detectLoop(head);
		if(result.found)
			System.out.println("Intersection found : "+result.found+" at node data : "+result.node.data+" with reference : "+result.node);
		else
			System.out.println("Intersection found : "+result.found);
	}
}
