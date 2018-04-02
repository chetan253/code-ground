//Check if array A is a subset of array B 
import java.util.*;
class CheckSet{
	static int binarySearch(int arr[], int l, int r, int x){
	   	if (r >= l){
			int mid = l + (r - l)/2;
	 		if (arr[mid] == x)  
		    	return mid;
	 		if (arr[mid] > x) 
			    return binarySearch(arr, l, mid-1, x);
	 		return binarySearch(arr, mid+1, r, x);
	   	}
	 	return -1;
	}

	public static void main(String args[]){
		int[] a = new int[]{5,2,10,-5,-8};
		int[] b = new int[]{-4,-8,2,2,1,2,3,5,5,-5};
		boolean flag = true;
		Arrays.sort(b);
		int j = 0;
		for(int i = 0; i < a.length; i++){
			if(binarySearch(b, 0, b.length-1, a[i]) == -1){
				flag = false;
				break;
			}
		}
		if(flag)
			System.out.println("IS set");
		else
			System.out.println("IS not set");
	}
}
