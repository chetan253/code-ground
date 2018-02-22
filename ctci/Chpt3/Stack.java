/*
	Data Structure : Stack;
*/
public class Stack<E>{	
	public class StackNode<E>{
		E data;
		StackNode<E> next;
		public StackNode(E data){
			this.data = data;
		}
	}
	StackNode<E> top;
	public void push(E data){
		StackNode<E> node = new StackNode<E>(data);
		node.next = top;
		top = node;
	}
	
	public E pop(){
		if(top == null){
			return null;
		}
		E data = top.data;
		top = top.next;
		return data;
	}
	
	public E peek(){
		if(top == null){
			return null;
		}
		return top.data;
	}
	
	public boolean isEmpty(){
		return top == null;
	}
}
