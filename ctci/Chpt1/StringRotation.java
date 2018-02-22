/*
	CTCI Problem 1.9 String Rotation
*/
import java.io.*;
class StringRotation{
	static boolean isSubstring(String temp, String s2){
		return temp.indexOf(s2) != -1;
	}
	
	static boolean checkRotation(String s1, String s2){
		if(s1.length() == s2.length()){
			String temp = s1 + s1;
			return isSubstring(temp, s2);
		}
		return false;
	}
	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			String s1 = br.readLine();
			String s2 = br.readLine();
			System.out.println(checkRotation(s1, s2));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
