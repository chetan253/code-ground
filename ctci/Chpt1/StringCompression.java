/*
	CTCI Problem 1.6 String Compression
*/
import java.io.*;
import java.util.*;
class StringCompression{
	static String check(String inputStr){
		String origStr = inputStr;
		inputStr += " ";
		char[] charArr = inputStr.toCharArray();
		charArr[charArr.length - 1] = '\0';		//Extra buffer for last character count
		String compressed = "";
		int counter = 1;
		for(int i = 1; i < charArr.length; i++){
			if(charArr[i] == charArr[i-1]){
				counter++;
			}
			else{
				compressed += charArr[i-1];
				compressed += Integer.toString(counter);
				counter = 1;
			}
		}
		if(compressed.length() < origStr.length()){
			return compressed;
		}
		return origStr;
	}
	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			String inputStr = br.readLine();
			System.out.println(check(inputStr));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
