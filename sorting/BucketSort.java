import java.util.*;
import java.util.LinkedList;
class BucketSort{	
	public static void main(String args[]){
		int[] arr =new int[]{10,1,2,5,15,20,80,30,40,35};
		ArrayList<LinkedList<Integer>> list = new ArrayList<LinkedList<Integer>>();
		int max = Integer.MIN_VALUE;
		for(int i : arr){
			max = i > max ? i : max;
		}
		
		for(int i = 0; i < arr.length; i++){
			list.add(new LinkedList<Integer>());
		}
		
		for(int i : arr){
			int index = (i * arr.length) / (max + 1);
			list.get(index).add(i);
		}
		int[] sorted = new int[arr.length];
		int sortedIndex = 0;
		for(int i = 0; i < arr.length; i++){
			Integer[] bucketarr = new Integer[list.get(i).size()];
			bucketarr = list.get(i).toArray(bucketarr);
			Integer[] barr = insertionsort(bucketarr);
			for(int j : barr){
				sorted[sortedIndex++] = j;
			}
		}
		
		for(int i : sorted){
			System.out.println(i);
		}
	}
	
	static Integer[] insertionsort(Integer[] arr){
		for(int i = 1; i < arr.length; i++){
			int j = i;
			while(j > 0 && arr[ j ] < arr[ j - 1 ]){
				int temp = arr[ j ];
				arr[ j ] = arr[ j - 1 ];
				arr[ j - 1 ] = temp;
				j--;
			}
		}
		return arr;
	}
}


