/*
CTCI Prob 1.2: Program to demonstrate if two strings are permutations of each other
*/

import java.io.*;
import java.util.Arrays;
class PermutationStrings{
	static boolean checkLen(String str1, String str2){
		if(str1.length() == str2.length())
			return true;
		return false;
	}
	static boolean checkPermutation(String str1, String str2){
		if(checkLen(str1, str2)){
			char str1Carr[] = str1.toCharArray();
			char str2Carr[] = str2.toCharArray();
			Arrays.sort(str1Carr);
			Arrays.sort(str2Carr);
			String str1a = new String(str1Carr);
			String str2a = new String(str2Carr);
			if(str1a.equals(str2a))
				return true;
		}
		return false;
	}
	public static void main(String args[]){
		String str1, str2;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			str1 = br.readLine();
			str2 = br.readLine();
			if(checkPermutation(str1, str2))
				System.out.println("They are permutations of each other");
			else
				System.out.println("They are not permutations of each other");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
