/*
	CTCI Problem 4.5 Check if given BST is valid or not;
*/
class Node{
	int data;
	Node right, left;
	public Node(int data){
		this.data = data;
		right = left = null;
	}
}

class ValidateBST{
	
	static boolean checkBST(Node root){
		return checkBST(root, null, null);
	}
	
	static boolean checkBST(Node node, Integer min, Integer max){
		if(node == null){
			return true;
		}
		
		if((min != null && node.data <= min) || (max != null && node.data > max)){
			return false;
		}
		
		if( !checkBST(node.left, min, node.data) || !checkBST(node.right, node.data, max)){
			return false;
		}
		return true;
	}
	
	public static void main(String args[]){
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		//Node node10 = new Node(10);
		
		Node root = node5;
		
		node5.left = node2;
		node5.right = node7;
		node2.left = node1;
		//node4.right = node10;
		node2.right = node3;
		node7.left = node6;
		node7.right = node8;
		node3.right = node4;
		node8.right = node9;
		System.out.println(checkBST(root));
	}
}
