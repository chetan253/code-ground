/*
	CTCI Problem 4.2 Minimal Tree
*/
import java.io.*;
import java.util.*;
class Node{
	int data;
	Node left, right;
	public Node(int data){
		this.data = data;
	}
}
class MinimalTree{

	static Node createMinimalTree(int[] arr, int start, int end){
		if(start > end){
			return null;
		}
		int mid = (start + end) / 2;
		Node n = new Node(arr[mid]);
		n.left = createMinimalTree(arr, start, mid - 1);
		n.right = createMinimalTree(arr, mid + 1, end);
		return n;
	}
	
	static void traverseTree(Node node){
		if(node == null){
			return;
		}
		System.out.println(node.data);
		traverseTree(node.left);
		traverseTree(node.right);
	}
	
	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.println("No of elements in to be inserted: ");
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			System.out.println("Insert "+ n +" elements");
			for(int i = 0; i < n; i++){
				arr[i] = Integer.parseInt(br.readLine());
			}
			Node treeRoot = createMinimalTree(arr, 0, arr.length - 1);
			System.out.println("Tree :");
			traverseTree(treeRoot);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
