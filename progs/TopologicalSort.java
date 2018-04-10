import java.util.*;
class TopologicalSort{
	static Graph g;
	static class Graph{
		int v;
		LinkedList<Integer> adj[];
		public Graph(int v){
			this.v = v;
			adj = new LinkedList[v];
			for(int i = 0; i < v; i++){
				adj[i] = new LinkedList<Integer>();
			}
		}
		
		public void addEdge(int src, int dest){
			adj[src].add(dest);
		}
	}
	
	static void DFS(int v, HashSet<Integer> visited, Stack<Integer> stack){
		visited.add(v);
		LinkedList<Integer> list = g.adj[v];
		for(int i : list){
			if(!visited.contains(i)){
				DFS(i, visited, stack);
			}
		}
		stack.push(v);
	}

	static void topologicalSort(){
		Stack<Integer> stack = new Stack<Integer>();
		HashSet<Integer> visited = new HashSet<Integer>();
		for(int i = 0; i < g.v; i++){
			if(!visited.contains(i))
				DFS(i, visited, stack);
		}
		System.out.println("Topological order : ");
		while(!stack.empty()){
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
	}

	public static void main(String args[]){
		g = new Graph(5);
                /*g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		*/
		g.addEdge(0, 1);
                g.addEdge(0, 2);
                g.addEdge(0, 4);
                g.addEdge(2, 3);
                g.addEdge(2, 4);
                g.addEdge(3, 1);
                g.addEdge(3, 2);
                g.addEdge(3, 4);
                g.addEdge(4, 1);
		topologicalSort();
	}
}
