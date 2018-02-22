/*
	CTCI Problem 1.3
*/
import java.io.*;
class URLify{
	static String modify(String inputStr, int trueLength){
		char[] charArr = new char[inputStr.length()];
		int trueLenCtr = trueLength - 1, charCtr = charArr.length - 1;
		for(int i = 0, charArrCtr = 0; i < trueLength; i++){
			if(inputStr.charAt(i) == ' '){
				charArr[charArrCtr] = '%';
				charArr[charArrCtr + 1] = '2';
				charArr[charArrCtr + 2] = '0';
				charArrCtr += 3;		//We will increment the array to 3 as 3 characters have been appended and extra buffer is assumed to hold all edits 
			}
			else{
				charArr[charArrCtr] = inputStr.charAt(i);
				charArrCtr++;
			}
		}
		return String.valueOf(charArr);
	}
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			String inputStr = br.readLine();
			int trueLength = Integer.parseInt(br.readLine());
			System.out.println(modify(inputStr, trueLength));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
