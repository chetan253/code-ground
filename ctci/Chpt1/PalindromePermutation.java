/*
	CTCI Problem 1.4
*/
import java.io.*;
import java.util.*;
class PalindromePermutation{
	static boolean checkPermutation(String s, int length){
		HashMap<Character, Integer> charCounter = new HashMap<Character, Integer>();
		int len = length;
		for(int i = 0; i < length; i++){
			if(s.charAt(i) != ' '){
				if(!charCounter.containsKey(s.charAt(i)))
					charCounter.put(s.charAt(i), 1);
				else
					charCounter.put(s.charAt(i), charCounter.get(s.charAt(i))+1);
			}
			else{
				len -= 1;
			}
		}
		int evenCounter = 0;
		int oddCounter = 0;
		for(Integer value : charCounter.values()){
			if(value % 2 == 0){
				evenCounter++;
			}
			else if(value % 2 == 1){
				oddCounter++;
			}
		}
		if(len % 2 == 0){
			if(evenCounter >= 0 && oddCounter == 0)
				return true;
		}
		else if(len % 2 == 1){
			if(evenCounter >= 0 && oddCounter == 1)
				return true;
		}
		return false;
	}
	public static void main(String args[]){
		String s;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			s = br.readLine();
			boolean result = checkPermutation(s, s.length());
			System.out.println(result);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
