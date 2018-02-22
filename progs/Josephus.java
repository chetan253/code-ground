//Josephus Problem - Output :- Last 2 who survive 
import java.util.*;
class Josephus{
	public static void main(String args[]){
		int n = Integer.parseInt(args[0]);	//Pass number of people in the circle
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		for(int i = 1; i <= n; i++){
			arrList.add(i);
		}
		int sword = 0;
		while(arrList.size() > 2){
			int executed = (sword +arrList.size() + 1) % arrList.size();
			sword = (sword+ 1) % arrList.size();
			arrList.remove(executed);
		}
		
		for(int i : arrList){
			System.out.println(i);
		}
		
	}
}
