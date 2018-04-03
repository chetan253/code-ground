//Count the nodes in BST greater than K
class BSTMaxThanK{
	static int K = 10;
	static class Node{
		int data;
		Node left, right;
		public Node(int data){
			this.data = data;
		}
	}
	static int getCount(Node node, int counter){
		if(node == null){
			return -1;
		}
		int leftChild = getCount(node.left, counter) + 1;
		int rightChild = getCount(node.right, counter) + 1;
		return leftChild + rightChild;
	}
	static int getGreaterThan(Node node, int counter){
		if(node == null){
			return 0;
		}
		return getCount(node, 0) + 1;
	}
	static int getK(Node node, int k, int counter){
		if(node == null)
			return counter;
		if(node.data == k)
			return getGreaterThan(node.right, 0) + counter; //add the previous counter that are grater than k;
		else if(node.data < k)
			return getK(node.right, k, counter);
		else if(node.data > k)
			return getK(node.left, k, getGreaterThan(node.right, 0)+1+counter); //counter + 1(self) is added to nodes greater than current and passed until k is found
		return -1;
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

		Node root = node5;
		
		node5.left = node2;
		node5.right = node7;
		node2.left = node1;
		node2.right = node4;
		node7.left = node6;
		node7.right = node8;
		node4.left = node3;
		node8.right = node9;

		System.out.println("Greater Than K are : "+ getK(root, K, 0));
	}
}
