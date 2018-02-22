/*
	Linked List
*/
public class LinkedList{
	Node head;
	public class Node{
		int data;
		Node next;
		public Node(int data){
			this.data = data;
		}
	}
	public void insert(int data){
		Node node = new Node(data);
		if(head == null){
			head = node;
			return;
		}
		Node n = head;
		while(n.next != null){
			n = n.next;
		}
		n.next = node;
		return;
	}

	public void printList(){
		Node n = head;
		while(n != null){
			System.out.print(n.data+" ");
			n = n.next;
		}
		System.out.println();
	}
}
