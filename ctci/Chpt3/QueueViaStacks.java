/*
	CTCI Problem 3.4 Queue Via Stacks
*/
import java.io.*;
class QueueViaStacks extends Stack{
	public static void main(String args[]){
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> queueStack = new Stack<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.println("How many element you want to insert?");
			int n = Integer.parseInt(br.readLine());
			for(int i = 0; i < n; i++){
				int data = Integer.parseInt(br.readLine());
				stack.push(data);
			}
			while(!stack.isEmpty()){
				queueStack.push(stack.pop());
			}
			System.out.println("Removing from queue:");
			while(!queueStack.isEmpty()){
				System.out.println(queueStack.pop());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
