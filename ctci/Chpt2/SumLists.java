/*
	CTCI Problem 2.5 Sum Lists
*/
import java.io.*;

class SumLists extends LinkedList{
	static LinkedList sumUp(LinkedList list, int c1, int c2){
		LinkedList result = new LinkedList();
		Node nodeList = list.head;
		Node nodeResult = null;
		int counter = 0;
		int carry = 0;
		while(nodeList != null && counter < c1){
			result.insert(nodeList.data);
			nodeList = nodeList.next;
			counter++;
		}
		
		nodeResult = result.head;
		
		while(nodeResult != null){
			int sum = nodeResult.data + nodeList.data + carry;
			carry = sum / 10;
			nodeResult.data = sum % 10;
			if(nodeResult.next == null && carry > 0){
				result.insert(0);
				list.insert(0);
			}
			nodeList = nodeList.next;
			nodeResult = nodeResult.next;
		}
		return result;
	}
	static void convertToList(LinkedList list,String s){
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == ' ' || s.charAt(i) == '-' || s.charAt(i) == '>'){
				continue;
			}
			list.insert(Character.getNumericValue(s.charAt(i)));	
		}
	}
	
	static int getCount(String s){
		int counter = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == ' ' || s.charAt(i) == '-' || s.charAt(i) == '>'){
				continue;
			}
			counter++;	
		}
		return counter;
	}
	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			LinkedList list = new LinkedList();
			System.out.println("Enter the first LinkedList");
			String s1 = br.readLine();
			int c1 = getCount(s1);
			System.out.println("Enter the second LinkedList");
			String s2 = br.readLine();
			int c2 = getCount(s2);
			int diff= Math.abs(c1-c2);	//Check the difference betweet the numbers by 2 lists
			if(diff == 0){
				convertToList(list, s1);
				convertToList(list, s2);
			}
			else{
				for(int i = 0; i < diff; i++){
					if(c1 > c2){
						c2++;
						s2 +=0;
						continue;
					}
					c1++;
					s1 += 0;
				}
				convertToList(list, s1);
				convertToList(list, s2);
			}			
			list.printList();
			LinkedList result = sumUp(list, c1, c2);
			result.printList();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
