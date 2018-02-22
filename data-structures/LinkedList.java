/*
	Author: Chetan Patil
	Data Structure: Linked List
*/
import java.io.*;
class LinkedList{
	static Node head;

	static class Node{
		int data;
		Node next = null;
		public Node(int data){
			this.data = data;
		}
	}
	// Insert at tail
	static void append(int data){
		Node newNode = new Node(data);
		if(head == null){
			head = newNode;
			head.next = null;
			return;
		}
		Node node = head;
		while(node.next != null){
			node = node.next;
		}
		node.next = newNode;
		return;
	}

	//Insert at head
	static void push(int data){
		Node newNode = new Node(data);
		if(head == null){
			head = newNode;
			head.next = null;
			return;
		}
		newNode.next = head;
		head = newNode;
		return;
	}
	
	static void delete(int data){
		if(head.data == data){
			head = head.next;
			return;
		}
		Node currNode = head.next;
		Node prevNode = head;
		while(currNode != null){
			if(currNode.data == data){
				prevNode.next = currNode.next;
				return;
			}
			prevNode = currNode;
			currNode = currNode.next;
		}
	}
	static void printList(){
		Node n = head;
		while(n != null){
			System.out.print(n.data+" ");
			n = n.next;
		}
		System.out.println();
	}
	
	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.println("Enter number of nodes to insert : ");
			int nnodes = Integer.parseInt(br.readLine());
			for(int i = 0; i < nnodes; i++){
				System.out.println("Enter "+(i+1)+" node:");
				int data = Integer.parseInt(br.readLine());
				append(data);
			}
			System.out.println("Elements in List are:");
			printList();
			System.out.println("deleting 1");
			delete(1);
			printList();
			System.out.println("pushing 1");
			push(1);
			printList();
			System.out.println("deleting 5");
			delete(5);
			printList();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
