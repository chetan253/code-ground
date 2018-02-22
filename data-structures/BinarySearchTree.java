/*
	Author: Chetan Patil
	Data Structure: Binary Search Tree
*/
class BSTNode{
	int data;
	BSTNode right = null;
	BSTNode left = null;
	
	public BSTNode(int data){
		this.data = data;
	}
}
class BinarySearchTree{
	public boolean searchData(int data, BSTNode root){
		if(data == root.data){
			return true;
		}
		if(data > root.data && root != null){
			return searchData(data, root.right);
		}
		if(data < root.data && root != null){
			return searchData(data, root.left);
		}
		return false;
	}
	
	public static void main(String args[]){
		BinarySearchTree bst = new BinarySearchTree(); 
		BSTNode node8 = new BSTNode(8);
		BSTNode node4 = new BSTNode(4);
		BSTNode node10 = new BSTNode(10);
		BSTNode node2 = new BSTNode(2);
		BSTNode node6 = new BSTNode(6);
		BSTNode node20 = new BSTNode(20);
		BSTNode root =	node8;
		node8.left = node4;
		node8.right = node10;
		node4.left = node2;
		node4.right = node6;
		node10.right = node20;
		System.out.println(bst.searchData(30, root));
		
	}
}
