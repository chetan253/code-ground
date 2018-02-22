/*
	CTCI Problem 2.6 Palindrome LinkedList	
*/
import java.io.*;
import java.util.*;
class Palindrome extends LinkedList{
	public boolean checkPalindrome(LinkedList list, int len){
		Stack<Integer> stack = new Stack<Integer>();
		int middle = len / 2;
		int counter = 0;
		boolean flag = true;
		Node n = list.head;
		while(n != null){
			if(counter < middle && len % 2 == 0){
				stack.push(n.data);
				counter++;
				n = n.next;
				continue;
			}
			if(counter <= middle && len % 2 == 1){
				stack.push(n.data);
				if(middle != counter){
					n = n.next;	
				}
				counter++;
				continue;
			}
			int data = stack.pop();
			if(data != n.data){
				flag = false;
				return flag;
			}
			counter++;
			n = n.next;
		}
		return stack.empty() ? true : false;
	}
	public static void main(String args[]){
		Palindrome p = new Palindrome();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			LinkedList list = new LinkedList();
			System.out.println("Enter no of elements to be inserted in linkedlist");
			int n = Integer.parseInt(br.readLine());
			int data;
			for(int i = 0; i < n; i++){
				System.out.println("Enter "+(i+1)+" element:");
				data = Integer.parseInt(br.readLine());
				list.insert(data);
			}
			boolean result = p.checkPalindrome(list, n);
			System.out.println(result);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
