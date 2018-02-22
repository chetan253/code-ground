import java.io.*;
class ThreeInOne extends Stack{
	public static void main(String args[]){
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		Stack<Integer> stack3 = new Stack<Integer>();
		Stack[] array = new Stack[3];
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);
		stack2.push(4);
		stack2.push(5);
		stack3.push(6);
		array[0] = stack1;
		array[1] = stack2;
		array[2] = stack3;
		for(Stack item : array){
			System.out.println(item.peek());
		}
	}
}
