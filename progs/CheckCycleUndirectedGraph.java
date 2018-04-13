//Check cycle in undirected graph using Disjoint Sets Union-Find (No path compression)
//Alternatively, DFS can also be used to find cycle in undirected graph.
import java.util.*;
class CheckCycleUndirectedGraph{
	static Graph g;
	
	static class Graph{
		int v, e;
		LinkedList<Integer> adj[];
		ArrayList<Edge> edges = new ArrayList<Edge>();
		public Graph(int v){
			this.v = v;
			adj = new LinkedList[v];
			for(int i = 0; i < v; i++){
				adj[i] = new LinkedList<Integer>();
			}
		}

		public void addEdge(int src, int dest){
			adj[src].add(dest);
			adj[dest].add(src);
			edges.add(new Edge(src, dest));
		}
		
	}
	
	static class Edge{
		int src, dest;
		public Edge(int src, int dest){
			this.src = src;
			this.dest = dest;
		}
	}	

	//Intialize each vertex as one set
	static void initSets(int[] arr){
		for(int i = 0; i < g.v; i++){
			arr[i] = i;
		}
	}
	
	//Get rank of a set
	static int getRank(int[] arr, int vertex, int rank){
		if(arr[vertex] == vertex){
			return rank;
		}
		return getRank(arr, arr[vertex], rank + 1);
	}

	//Unification of sets based on rank
	static void union(int[] arr, int v1, int v2){
		 int v1_rank = getRank(arr, v1, 0);
		 int v2_rank = getRank(arr, v2, 0);
		 if(v1_rank <= v2_rank)
		 	arr[v1] = v2;
		 else
			arr[v2] = v1;
	}

	//Find set to which vertex belongs
	static int find(int[] arr, int vertex){
		if(arr[vertex] == vertex){
			return vertex;
		}
		return find(arr, arr[vertex]);
	}

	//Driver function
	static void checkCycle(int[] arr){
		for(Edge edge : g.edges){
			int v1 = find(arr, edge.src);
			int v2 = find(arr, edge.dest);
			
			if(v1 == v2){
				System.out.println("Cycle detected");
				return;		
			}
			else
				union(arr, edge.src, edge.dest);
		}
		System.out.println("Acyclic Graph");
	}
	
	public static void main(String args[]){
		g = new Graph(5);
                g.addEdge(0, 2);
                g.addEdge(0, 3);
                g.addEdge(2, 3);
                g.addEdge(1, 4);
                g.addEdge(3, 1);
		int[] arr = new int[g.v];		
		initSets(arr);
		checkCycle(arr);
	}
}
