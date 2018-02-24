// Algos Lab - 7 LCS
import java.io.*;
class LCS{
	static int lcs(char[] X, char[] Y, int m, int n){
		int LCS[][] = new int[m+1][n+1];
		for (int i=0; i<=m; i++){
			for (int j=0; j<=n; j++){
				if (i == 0 || j == 0)
					LCS[i][j] = 0;
				else if (X[i-1] == Y[j-1]){
					LCS[i][j] = LCS[i-1][j-1] + 1;
				}
				else
					LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
			}
		}
		return LCS[m][n];
	}
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the first string: ");
		String s1 = br.readLine();
		System.out.println("Enter the first string: ");
		String s2 = br.readLine();
		System.out.println("The LCS is of size : "+ lcs(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length()));	
	}
}
