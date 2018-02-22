/* Min Heap*/
//ref: https://www.youtube.com/watch?v=t0Cq6tVNRBA
import java.util.*;
import java.io.*;
class MinHeap{
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
		while(hasParent(childIndex) && arr[childIndex] < getParent(childIndex)){
			swap(childIndex, getParentIndex(childIndex));
			childIndex = getParentIndex(childIndex);
		}
	}
	
	public static int poll(){
		int data = arr[0];
		arr[0] = arr[size-1];
		size--;
		heapifyDown();
		arr[size] = data;
		return data;
	}
	
	public static void heapifyDown(){
		int index = 0;
		while(hasLeftChild(index)){
			int smallerChildIndex = getLeftChildIndex(index);
			if(hasRightChild(index) && getRightChild(index) < getLeftChild(index)){
				smallerChildIndex = getRightChildIndex(index);
			}
			if(arr[index] < arr[smallerChildIndex]){
				break;
			}
			else{
				swap(index, smallerChildIndex);
			}
			index = smallerChildIndex;
		}
	}
	
	public static void swap(int index1, int index2){
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	
	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of elements to insert: ");
		try{
			int n = Integer.parseInt(br.readLine());
			int[] items = new int[n];
			System.out.println("Enter " + n + " elements:");
			for(int i = 0; i < n; i++){
				items[i] = Integer.parseInt(br.readLine());
			}
			// Insert in heap
			for(int i = 0; i < n; i++){
				insert(items[i]);
			}
			System.out.println("Popping min : " + poll());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
