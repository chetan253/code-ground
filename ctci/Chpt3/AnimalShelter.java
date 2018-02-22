/*
	CTCI Problem 3.6 Animal Shelter
*/
import java.io.*;
class AnimalShelter extends Queue{

	static String dequeueAny(Queue<String> queue, Queue<String> list){
		if(list.peek() != null){
			return list.pop();
		}
		return queue.pop();
	}

	static String dequeueDog(Queue<String> queue, Queue<String> list){
		if(list.peek() == null){
			while(queue.peek() != "Dog"){
				list.push(queue.pop());
			}
			return queue.pop();
		}
		return list.peek() == "Dog" ? list.pop() : null;
	}
	
	static String dequeueCat(Queue<String> queue, Queue<String> list){
		if(list.peek() == null){
			while(queue.peek() != "Cat"){
				list.push(queue.pop());
			}
			return queue.pop();
		}
		return list.peek() == "Cat" ? list.pop() : null;	
	}
	
	static void enqueue(String data, Queue<String> queue){
		queue.push(data);
	}
	
	public static void main(String args[]){
		Queue<String> queue = new Queue<String>();
		Queue<String> list = new Queue<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			
			enqueue("Cat", queue);
			enqueue("Cat", queue);
			enqueue("Dog", queue);
			enqueue("Cat", queue);
			enqueue("Dog", queue);
			enqueue("Cat", queue);
			System.out.println("Printing Queue");
			queue.printQueue();
			System.out.println(dequeueAny(queue, list));
			System.out.println(dequeueDog(queue, list));
			System.out.println(dequeueCat(queue, list));
			System.out.println(dequeueAny(queue, list));
			
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
}
