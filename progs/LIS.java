//Longest increasing subsequence of consecutive elements such that A[i] ≤ A[i+1] ≤ ...≤ A[i+k]
import java.util.*;
class LIS{
	public static void main(String args[]){
		int[] arr = new int[]{-2,-3,0,1,3,5,4,7};
		int startPos = 0, lastPos = 0;
		int maxKey = Integer.MIN_VALUE;
		HashMap<Integer, ArrayList<Integer>> mapper = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		tempList.add(arr[0]);
		for(int i = 1; i < arr.length; i++){
			if(arr[i] >= arr[i-1]){
				tempList.add(arr[i]);
			}
			if(arr[i] < arr[i-1]){				
				mapper.put(tempList.size(), tempList);
				maxKey = maxKey < tempList.size() ? tempList.size() : maxKey;
				tempList = new ArrayList<Integer>();
				tempList.add(arr[i]);
			}
		}
		maxKey = maxKey < tempList.size() ? tempList.size() : maxKey;
		mapper.put(tempList.size(), tempList);
		System.out.println("Longest Subseq size : "+ maxKey + " seq is : "+ mapper.get(maxKey));
	}
}
