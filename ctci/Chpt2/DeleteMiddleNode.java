/*
	CTCI Problem 2.3 Delete Middle Node
*/
import java.io.*;
class DeleteMiddleNode extends LinkedList{
	static void deleteMiddleNode(LinkedList list){
		int counter = 0;
		Node n = list.head;
		while(n != null){
			counter++;
			n = n.next;
		}
		int middle = counter%2 == 1 ? counter/2 : (counter/2) - 1;
		counter = 0;
		n = list.head;
		Node prev = null;
		while(n != null){
			if(counter == middle){
				prev.next = n.next;
				return;
			}
			counter++;
			prev = n;
			n = n.next;
		}
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
			System.out.println("After deleting middle node list is:");
			deleteMiddleNode(list);
			list.printList();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
