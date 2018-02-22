/*
	CTCI Problem 3.3 Set Of Plates
*/
import java.io.*;

class Stack<E>{	
	Stack<E> next = null;
	class StackNode<E>{
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

class SetOfPlates{
	static Stack<Integer> setTop = null;
	static void popFromStack(){
		Stack stack = setTop;
		if(stack.isEmpty()){
			System.out.println("Popping stack in set");
			stack = stack.next;
			setTop = stack;
		}
		System.out.println(stack.peek());
		stack.pop();
		return;
	}
	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			int capacity = 5, counter = 0;
			System.out.println("Number of elements to be inserted in the stack");
			int n = Integer.parseInt(br.readLine());
			System.out.println("Enter "+n+" elements:");
			Stack<Integer> stack = new Stack<Integer>();
			for(int i = 0; i < n; i++){
				counter++;
				int data = Integer.parseInt(br.readLine());
				if(counter > capacity){
					System.out.println("Inserting new Stack");
					Stack tempStack = new Stack<Integer>();
					tempStack.next = stack;
					stack = tempStack;
					setTop = stack;
					counter = 1;
				}
				stack.push(data);
			}
			System.out.println();
			System.out.println("Popping starts");
			popFromStack();
			popFromStack();
			popFromStack();
			popFromStack();
			popFromStack();
			popFromStack();
			popFromStack();
			popFromStack();
			popFromStack();
			popFromStack();
			popFromStack();
			popFromStack();
			popFromStack();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
