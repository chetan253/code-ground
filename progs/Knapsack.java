import java.io.*;
class Knapsack{

	public static int knapSack(int[] values, int[] weights, int maxWeight, int length){
		if(maxWeight == 0 || length < 0){
			return 0;
		}
		if(weights[length] > maxWeight){
			return knapSack(values, weights, maxWeight, length-1);
		}
		return Math.max(values[length] + knapSack(values, weights, (maxWeight - weights[length]), length - 1), knapSack(values, weights, maxWeight, length-1));
	}	
	
	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.println("Enter the number of items :");
			int n = Integer.parseInt(br.readLine());
			int[] values = new int[n];
			int[] weights = new int[n];
			System.out.println("Enter values of "+n+" items: ");
			for(int i = 0; i < n; i++){
				values[i] = Integer.parseInt(br.readLine());
			}
			System.out.println("Enter weights of corresponding "+n+" items: ");
			for(int i = 0; i < n; i++){
				weights[i] = Integer.parseInt(br.readLine());
			}
			System.out.println("Enter the maximum weight the knapsack can hold:");
			int maxWeight = Integer.parseInt(br.readLine());
			int maxSolution = knapSack(values, weights, maxWeight, n - 1);
			System.out.println("Maximum value of knapsack : "+ maxSolution);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
