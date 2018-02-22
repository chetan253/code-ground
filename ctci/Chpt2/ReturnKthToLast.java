/*
	CTCI Problem 2.1
*/
import java.io.*;

class ReturnKthToLast extends LinkedList{
	static void printKthToLast(LinkedList list, int k){
		Node n = list.head;
		int counter = 0;
		while(n != null){
			if(counter+1 >= k){
				System.out.print(n.data+" ");
			}
			counter++;
			n = n.next;
		}
		System.out.println();
	}
	public static void main(String args[]){
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
			list.printList();
			System.out.println("Enter k: ");
			int k = Integer.parseInt(br.readLine());
			printKthToLast(list, k);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
