//Path that visits each vertex exactly once
import java.util.*;
class HamiltonianPath{
	static Graph g;
	static class Graph{
		int v;
		LinkedList<Integer> adj[];
		public Graph(int v){
			this.v = v;
			adj = new LinkedList[v];
			for(int i=0; i < v; i++){
				adj[i] = new LinkedList<Integer>();
			}
		}
		
		public void addEdge(int src, int dest){
			adj[src].add(dest);
		}
	}

	public static void DFS(int v, HashSet<Integer> visited, Stack<Integer> stack){
		visited.add(v);
		LinkedList<Integer> list = g.adj[v];
		for(int i : list){
			if(!visited.contains(i))
				DFS(i, visited, stack);
		}
		stack.push(v);
	}

	public static boolean checkPath(int u, int v){
		for(int i : g.adj[u]){
			if(i == v){
				System.out.println("Path found");
				return true;
			}
		}
		return false;
	}
	public static Stack<Integer> topologicalSort(){
		Stack<Integer> stack = new Stack<Integer>();
		HashSet<Integer> visited = new HashSet<Integer>();
		for(int i = 0; i < g.v; i++){
			if(!visited.contains(i)){
				DFS(i, visited, stack);						
			}
		}
		return stack;
	}
		
	public static boolean isTherePath(){
		Stack<Integer> stack = topologicalSort();
		Stack<Integer> vertexVisited = new Stack<Integer>();
		vertexVisited.push(stack.pop());
		while(!stack.empty()){
			int u = vertexVisited.peek();
			int v = stack.pop();
			System.out.println("Checking path between "+ u + " and "+v);
			if(!checkPath(u,v))
				return false;
			vertexVisited.push(v);
		}
		if(stack.empty()==true && g.adj[vertexVisited.peek()].size() == 0)
			return true;
		return false;
	}

	public static void main(String args[]){
		g = new Graph(5);
		g.addEdge(0, 1);
	        g.addEdge(0, 2);
	        g.addEdge(0, 4);
	        g.addEdge(2, 3);
	        g.addEdge(2, 4);
	        g.addEdge(3, 1);
		g.addEdge(3, 2);
		g.addEdge(3, 4);
		g.addEdge(4, 1);
		System.out.println(isTherePath());
	}
}
