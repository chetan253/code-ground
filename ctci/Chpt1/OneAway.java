/*
	CTCI Problem 1.5 One Away
*/
import java.io.*;
import java.util.*;
class OneAway{
	static boolean checkEdits(String s1, String s2){
		int editCounter = 0;
		HashSet<Character> set = new HashSet<Character>();
		for(int i = 0; i < s1.length(); i++){
			set.add(s1.charAt(i));
		}
		if(Math.abs(s1.length() - s2.length()) <= 1){
			for(int i = 0; i < s2.length(); i++){
				if(editCounter <= 1){
					if(!set.contains(s2.charAt(i))){	
						editCounter++;
					}
				}else{
					return false;
				}
			}
			return true;
		}
		return false;
	}
	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			String s1 = br.readLine();
			String s2 = br.readLine();
			System.out.println(checkEdits(s1,s2));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
