/*
	CTCI Problem 3.2 Stack Min
*/
import java.io.*;
class StackMin extends Stack{
	public static void main(String args[]){
		Stack<Integer> stackMain = new Stack<Integer>();
		Stack<Integer> stackMin = new Stack<Integer>();
		int min = Integer.MAX_VALUE;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.println("Number of elements to be inserted in the stack");
			int n = Integer.parseInt(br.readLine());
			System.out.println("Enter "+n+" elements:");
			for(int i = 0; i < n; i++){
				int data = Integer.parseInt(br.readLine());
				if(data <= min){
					min = data;
					stackMin.push(min);
				}
				stackMain.push(data);
			}
			while(!stackMain.isEmpty()){
				if(stackMain.top.data == stackMin.top.data){
					System.out.println("Popping from main and min: "+stackMain.top.data+" "+stackMin.top.data);
					stackMain.pop();
					stackMin.pop();
					continue;
				}
				System.out.println("Popping from main: "+stackMain.top.data);
				stackMain.pop();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
