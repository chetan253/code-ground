/*
	Data Structure: Queue
*/
public class Queue<E>{
	public class QueueNode<E>{
		E data = null;
		QueueNode next = null;
		public QueueNode(E data){
			this.data = data;
		}
	}
	QueueNode<E> startNode, endNode;
	public void push(E data){
		QueueNode<E> newNode = new QueueNode<E>(data);
		if(startNode == null){
			startNode = newNode;
			endNode = newNode;
			return;
		}
		QueueNode<E> node = startNode;
		while(node.next != null){
			node = node.next;
		}
		node.next = newNode;
		return;
	}
	
	public E pop(){
		if(startNode == null){
			return null;
		}
		E data = startNode.data;
		startNode = startNode.next;
		return data;
	}
	
	public E peek(){
		if(startNode == null){
			return null;
		}
		return startNode.data;
	}
	
	public void printQueue(){
		QueueNode<E> node = startNode;
		while(node != null){
			System.out.print(node.data+" ");
			node = node.next;
		}
		System.out.println();
	}
}
