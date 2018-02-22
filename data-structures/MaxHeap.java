// ref : https://www.youtube.com/watch?v=t0Cq6tVNRBA
import java.io.*;
import java.util.*;
class MaxHeap{
	public static int[] arr = new int[10];
	public static int size = 0;
	
	public static void ensureCapacity(){
		if(arr.length < size + 1){
			arr = Arrays.copyOf(arr, arr.length * 2);
		}
		return;
	}
	
	public static int getLeftChildIndex(int index){
		return (index * 2) + 1;
	}
	
	public static int getRightChildIndex(int index){
		return (index * 2) + 2;
	}
	
	public static int getParentIndex(int index){
		return (index - 1) / 2;
	}
	
	public static int getLeftChild(int index){
		return arr[getLeftChildIndex(index)];
	}
	
	public static int getRightChild(int index){
		return arr[getRightChildIndex(index)];
	}
	
	public static int getParent(int index){
		return arr[getParentIndex(index)];
	}
	
	public static boolean hasLeftChild(int index){
		return getLeftChildIndex(index) < size ? true : false;
	}
	
	public static boolean hasRightChild(int index){
		return getRightChildIndex(index) < size ? true : false;
	}
	
	public static boolean hasParent(int index){
		return getParentIndex(index) < 0 ? false : true;
	}
	
	public static void insert(int data){
		ensureCapacity();
		arr[size] = data;
		size++;
		heapifyUp();
	}
	
	public static void heapifyUp(){
		int childIndex = size - 1;
		while(hasParent(childIndex) && getParent(childIndex) < arr[childIndex]){
			swap(childIndex, getParentIndex(childIndex));
			childIndex = getParentIndex(childIndex);
		}
	}
	
	public static int poll(){
		int data = arr[0];
		arr[0] = arr[size-1];
		size--;
		heapifyDown();
		return data;
	}
	
	public static void heapifyDown(){
		int index = 0;
		while(hasLeftChild(index)){
			int maxChildIndex = getLeftChildIndex(index);
			if(hasRightChild(index) && getLeftChild(index) < getRightChild(index)){
				maxChildIndex = getRightChildIndex(index);
			}
			if(arr[index] > arr[maxChildIndex]){
				break;
			}
			else{
				swap(maxChildIndex, index);
			}
			index = maxChildIndex;
		}	
	}
	
	public static void swap(int index1, int index2){
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	
	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of elements to be inserted: ");
		try{
			int n = Integer.parseInt(br.readLine());
			int[] items = new int[n];
			System.out.println("Enter " + n + " elements:");
			for(int i = 0; i < n; i++){
				items[i] = Integer.parseInt(br.readLine());
			}
			for(int i = 0; i < n; i++){
				insert(items[i]);
			}
			System.out.println("Popping max : " + poll());
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
