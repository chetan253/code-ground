
/* 
CTCI Prob 1.1 Program to demonstrate unique characters in the string with and w/o using data structure
Assumption: String of ASCII values
*/
import java.util.*;

class CheckChars{
	private String inputStr;
	private HashSet<Character> checkUnique = new HashSet<Character>();

	public CheckChars(String inputStr){
		this.inputStr = inputStr;
	}
	
	//Using HashSet DS to keep track on unique chars
	public boolean checkChars(){
		for(int i = 0; i < inputStr.length(); i++){
			char c = inputStr.charAt(i);
			if(checkUnique.contains(c)){
				return false;
			}
			else{
				checkUnique.add(c);
			}
		}
		return true;
	}
	
	//Using boolean array to keep track on repeated chars
	public boolean checkCharsWoDS(){
		boolean[] uniqueChars = new boolean[128];
		for(int i = 0; i < inputStr.length(); i++){
			char c = inputStr.charAt(i);
			if(uniqueChars[(int)c]){
				return false;
			}
			else
				uniqueChars[(int)c] = true;
		}
		return true;
	}
}

class UniqueChars{
	public static void main(String args[]) throws Exception{
		String inputStr;
		Scanner scan = new Scanner(System.in);
		inputStr = scan.nextLine();
		CheckChars cc = new CheckChars(inputStr);	
		boolean withDSresult = inputStr.length() > 128 ? false : cc.checkChars();
		boolean withoutDSresult = inputStr.length() > 128 ? false : cc.checkCharsWoDS();
		System.out.println("with DS = " + withDSresult);
		System.out.println("without DS = " + withoutDSresult);
	}
}
