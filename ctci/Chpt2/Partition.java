/*
	CTCI Problem 2.4 Partition
*/
import java.io.*;

class Partition extends LinkedList{
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
			System.out.println("Enter x");
			int x = Integer.parseInt(br.readLine());
			partitionList();
			list.printList();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
