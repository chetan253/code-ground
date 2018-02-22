/*
	CTCI Problem 1.8 Zero matrix
*/
import java.io.*;
import java.util.*;
class ZeroMatrix{
	static void makeRowZero(int[][] arr, int row, int col){
		for(int c = 0; c < col; c++){
			arr[row][c] = 0;
		}
	}
	static void makeColZero(int[][] arr, int row, int col){
		for(int r = 0; r < row; r++){
			arr[r][col] = 0;
		}
	}
	static void checkZeros(int[][] arr, int row, int col){
		HashSet<Integer> rowsToZero = new HashSet<Integer>();
		HashSet<Integer> colsToZero = new HashSet<Integer>();
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(arr[i][j] == 0){
					rowsToZero.add(i);
					colsToZero.add(j);
				}
			}
		}
		for(Integer i : rowsToZero){
			makeRowZero(arr, i, col);
		}
		for(Integer j : colsToZero){
			makeColZero(arr, row, j);
		}
	}
	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			int m = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[m][n];
			for(int i = 0; i < m; i++)
				for(int j = 0; j < n; j++)
					arr[i][j] = Integer.parseInt(br.readLine());
			checkZeros(arr,m,n);
			for(int i = 0; i < m; i++){
				for(int j = 0; j < n; j++){
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
