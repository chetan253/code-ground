/*
	CTCI Problem 3.5 Sort Stack
	Ref: geek for geeks
*/
import java.io.*;
class SortStack extends Stack{
	public static void main(String args[]){
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> tempStack = new Stack<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			System.out.println("Enter the number of elements to be pushed: ");
			int n = Integer.parseInt(br.readLine());
			for(int i = 0; i < n; i++){
				int data = Integer.parseInt(br.readLine());
				stack.push(data);
			}
			while(!stack.isEmpty()){
				int temp = stack.pop();
				while(!tempStack.isEmpty() && tempStack.peek() > temp){
					stack.push(tempStack.pop());
				}
				tempStack.push(temp);
			}
			while(!tempStack.isEmpty()){
				stack.push(tempStack.pop());
			}
			System.out.println("Sorted Stack:");
			while(!stack.isEmpty()){
				System.out.println(stack.pop());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
