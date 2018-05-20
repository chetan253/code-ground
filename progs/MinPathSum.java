import java.io.*;
import java.util.*;
class MinPathSum{

	public static void getMinPath(int arr[][],int m, int n){
		int cost[][] = new int[m][n];
		char trace[][] = new char[m][n];
		char LEFT = 'L', UP = 'U', START = 'S';
		cost[0][0] = arr[0][0];
		trace[0][0] = START;
		for(int i = 0; i < m; i++){
                        for(int j = 0; j < n; j++){
                                if(i == 0 && j == 0)
					continue;
				if(i == 0){
					cost[i][j] = arr[i][j] + cost[i][j-1];
					trace[i][j] = LEFT;
				}
				if(j == 0){
					cost[i][j] = arr[i][j] + cost[i-1][j];
					trace[i][j] = UP;
				}
                        }
                }

		for(int i = 1; i < m; i++){
                        for(int j = 1; j < n; j++){
                                cost[i][j] = Math.min(cost[i-1][j], cost[i][j-1]) + arr[i][j];
				if(cost[i-1][j] < cost[i][j-1])
					trace[i][j] = UP;
				else
					trace[i][j] = LEFT;
                        }
		}

		backTrack(trace, arr, UP, LEFT, m-1, n-1);
		System.out.println("Minimum cost is : "+ cost[m-1][n-1]);
	}

	public static void backTrack(char path[][], int arr[][], char UP, char LEFT, int m, int n){
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		while(path[m][n] != 'S'){
			arrList.add(0, arr[m][n]);
			if(path[m][n] == UP){
				m--;
			}
			else{
				n--;
			}
		}
		arrList.add(0, arr[m][n]);
		System.out.println("Path is : " + arrList);
	}

	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.println("Enter size of 2D matrix m and n : ");
			int m = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int arr[][] = new int[m][n];
			System.out.println("Enter matrix data i.e distances: ");
			for(int i = 0; i < m; i++){
				for(int j = 0; j < n; j++){
					arr[i][j] = Integer.parseInt(br.readLine());
				}
			}
			getMinPath(arr, m, n);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
