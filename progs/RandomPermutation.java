/*Random permutation of array : B505-Applied Algorithms*/
import java.util.*;

class RandomPermutation{
	public static void main(String args[]){
		int arr[] = new int[]{9,1,4,5,2};
		Random randNo = new Random();
		for(int i = 1; i < arr.length; i++){
			int tempRand = randNo.nextInt(arr.length - 1);
			int temp = arr[i];
			arr[i] = arr[tempRand];
			arr[tempRand] = temp;
		}
		for(int i : arr){
			System.out.print(i + ", ");
		}
		System.out.println();
	}
}
