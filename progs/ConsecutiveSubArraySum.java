//Consecutive Subarray Sum
import java.io.*;
class ConsecutiveSubArraySum{
	public static String findConsSubArray(int[] arr, int sum, int S, int firstPos, int lastPos){
		for(int i = 0; i < arr.length; i++){
			sum =  sum + arr[i];
			while(sum > S && firstPos <= lastPos){
				sum -= arr[firstPos++]; 
			}
			if(sum == S){
				break;
			}
			lastPos = i;
		}
		return sum == S ? "Subarray found" : "Subarray not found";
	}
	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{	
			System.out.println("Enter the length of array: ");
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			System.out.println("Enter the "+n+" numbers");
			for(int i = 0; i < n; i++){
				arr[i] = Integer.parseInt(br.readLine());
			}
			System.out.println("Enter the sum: ");
			int S = Integer.parseInt(br.readLine());
			int firstPos = 0;
			int lastPos = 0;
			int sum = 0;
			System.out.println(findConsSubArray(arr, sum, S, firstPos, lastPos));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
