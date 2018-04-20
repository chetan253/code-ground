//Ref : https://www.geeksforgeeks.org/diameter-tree-using-dfs/
import java.util.*;
class DiameterOfTree{
	static Tree t;
	static int leaf, maxLength = -1;

	static class Tree{
		int v;
		LinkedList<Integer> adj[];
		public Tree(int v){
			this.v = v;
			adj = new LinkedList[v];
			for(int i = 0; i < v; i++){
				adj[i] = new LinkedList<Integer>();
			}
		}

		public void addEdge(int src, int dest){
			adj[src].add(dest);
			adj[dest].add(src);
		}
	}

	static void DFS(int vertex, int length, HashSet<Integer> visited){
		visited.add(vertex);
		LinkedList<Integer> children = t.adj[vertex];
		length++;	
		for(int i : children){
			if(!visited.contains(i)){
				if(maxLength <= length){
					maxLength = length;
					leaf = i;
				}
				DFS(i, length, visited);
			}
		}
	}

	static void findDiameter(){
		HashSet<Integer> visited = new HashSet<Integer>();
		DFS(0, 1, visited);
		visited.clear();
		DFS(leaf, 1, visited);
	}

	public static void main(String args[]){
		t = new Tree(7);
		t.addEdge(0,1);
		t.addEdge(0,2);
		t.addEdge(1,3);
		t.addEdge(1,4);
		t.addEdge(2,5);
		t.addEdge(2,6);
		findDiameter();
		System.out.println(maxLength);
	}
}
