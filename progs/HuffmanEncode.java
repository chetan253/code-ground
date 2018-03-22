//Huffman Encode - B505 Applied Algorithms
import java.util.*;

static class Node implements Comparable<Node>{
        int freq;
        char c;
        Node left, right;
        public Node(char c, int freq){
                this.c = c;
                this.freq = freq;
                left = right = null;
        }
        public int compareTo(Node n){
                return Integer.compare(this.freq, n.freq);
        }
}

class HuffmanEncode{	
	
	//Huffman code printing
	public static void printData(Node root, String s){
		//Preorder traversal
		if(root.left == null && root.right == null && root.c != '\0'){
			System.out.println(root.c + " : " + s);
			return;
		}
		printData(root.left, s+"0");
		printData(root.right, s+"1");
	}

	public static void main(String args[]){
		String str = "abcabcabcdefghihigjkdlabcdef"; //If taking from string {1}
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
 		HashMap<Character, Integer> freqMapper = new HashMap<Character, Integer>();
		//Get the frequencies of characters {1}
		/*for(char c  : str.toCharArray()){
			if(freqMapper.containsKey(c)){
				freqMapper.put(c, freqMapper.get(c)+1);
			}
			else{
				freqMapper.put(c, 1);
			}
		}*/
		
		//If taking frequencies directly
    		freqMapper.put('a',45000);
		freqMapper.put('b',13000);
		freqMapper.put('c',12000);
		freqMapper.put('d',16000);
		freqMapper.put('e',9000);
		freqMapper.put('f',5000);

		//Pushing char freq nodes in priority queue
		for(Character c : freqMapper.keySet()){
			queue.add(new Node(c, freqMapper.get(c)));
		}
		//tree construction
		while(queue.size() > 1){
			Node n1 = queue.poll();
			Node n2 = queue.poll();
			Node n = new Node('\0', n1.freq + n2.freq);
			n.left = n1;
			n.right = n2;
			queue.add(n);
		}
		Node root = queue.poll();
		printData(root, "");
	}
}
