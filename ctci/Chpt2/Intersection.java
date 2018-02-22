/*
	CTCI Problem 2.7 Intersection in LinkedList
*/
import java.io.*;
import java.util.*;
class Node{
	int data;
	Node next;
	public Node(int data){
		this.data = data;
	}
}
class MultiReturn{
	boolean found = false;
	Node node;
}
class Intersection{
	public MultiReturn getIntersection(Node l1Head, Node l2Head){
		MultiReturn result = new MultiReturn();
		HashSet<Node> set = new HashSet<Node>();
		Node l1n = l1Head;
		while(l1n != null){
			set.add(l1n);
			l1n = l1n.next;
		}
		Node l2n = l2Head;
		while(l2n != null){
			if(set.contains(l2n)){
				result.found = true;
				result.node = l2n;
				return result;
			}
			l2n = l2n.next;
		}
		return result;
	}

	static void printList(Node head, int listNo){
		Node n = head;
		System.out.println("List :" + listNo);
		while(n != null){
			System.out.print(n.data+" ");
			n = n.next;
		}
		System.out.println();
	}
	
	public static void main(String args[]){
		Intersection intersect = new Intersection();
		//List 1
		Node l1n1 = new Node(1);
		Node l1n2 = new Node(2);
		Node l1n3 = new Node(3);
		Node l1n4 = new Node(4);
		//List 2
		Node l2n1 = new Node(10);
		Node l2n2 = new Node(11);
		Node l2n3 = new Node(12);
		Node l2n4 = new Node(13);
		Node l1Head = l1n1;
		Node l2Head = l2n1;
		l1n1.next = l1n2;
		l1n2.next = l1n3;
		l1n3.next = l1n4;
		l2n1.next = l2n2;
		l2n2.next = l2n3;
		l2n3.next = l2n4;
		//Creating Intersection at tail of list 2 to mid node of list 1
		// prev list1 : 1 -> 2 -> 3 -> 4     	new list1 :  1 -> 2 -> 3 -> 4
		// prev list1 : 10 -> 11 -> 12 -> 13    new list2 :  10 -> 11 -> 12 -> 13 -> 3 -> 4 (Intersection at 13 -> 3)
		l2n4.next = l1n3;
	
		printList(l1Head, 1);
		printList(l2Head, 2);
		MultiReturn result = intersect.getIntersection(l1Head, l2Head);
		if(result.found)
			System.out.println("Intersection found : "+result.found+" at node data : "+result.node.data+" with reference : "+result.node);
		else
			System.out.println("Intersection found : "+result.found);
		
	}
}
