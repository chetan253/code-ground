import java.io.*;

class TestRef extends LinkedList{
	static void printListRef(LinkedList list){
		Node n = list.head;
		while(n != null){
			System.out.print(n+" ");
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
			printListRef(list);
			LinkedList list1 = new LinkedList();
			System.out.println("Enter no of elements to be inserted in linkedlist");
			n = Integer.parseInt(br.readLine());
			for(int i = 0; i < n; i++){
				System.out.println("Enter "+(i+1)+" element:");
				data = Integer.parseInt(br.readLine());
				list1.insert(data);
			}
			printListRef(list1);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
