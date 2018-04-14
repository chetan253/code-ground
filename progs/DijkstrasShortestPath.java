import java.util.*;

class Vertex{
        int vertex, cost;
        public Vertex(int vertex, int cost){
                this.vertex = vertex;
                this.cost = cost;
        }
}

class HeapMap{
	int v;
	Vertex[] heap;							//Vertex Heap array for src to vertex including cost 
	HashMap<Integer, Integer> map;					//Mapping = <Vertex, Position of Vertex in Heap array>
	int size = 0;

	public HeapMap(int v){
		this.v = v;
		heap = new Vertex[v];
		map = new HashMap<Integer, Integer>();
	}

	//Basic heap driver functions
	public int getLeftChildPos(int pos){
		return (pos * 2) + 1;
	}
	public boolean hasLeftChild(int pos){
		return getLeftChildPos(pos) < size ? true : false;
	}

	public Vertex getLeftChild(int pos){
		return heap[getLeftChildPos(pos)];
	}

	public int getRightChildPos(int pos){
		return (pos * 2) + 2;
	}

	public boolean hasRightChild(int pos){
		return getRightChildPos(pos) < size ? true : false;
	}

	public Vertex getRightChild(int pos){
		return heap[getRightChildPos(pos)];
	}

	public int getParentPos(int pos){
		return (pos - 1) / 2;
	}

	public boolean hasParent(int pos){
		return getParentPos(pos) < 0 ? false : true;
	}

	public Vertex getParent(int pos){
		return heap[getParentPos(pos)];
	}
	
	//Swap two verticeso on specified positions
	public void swap(int pos1, int pos2){
		Vertex temp = heap[pos1];
		heap[pos1] = heap[pos2];
		heap[pos2] = temp;
		map.put(heap[pos1].vertex, pos1);			//Update positons in the map for corresponding vertices
		map.put(heap[pos2].vertex, pos2);
	}

	public void heapifyUp(int pos){					//Heap property violated at position on inserting vertex or decreasing value of vertex
		int childPos = pos;
		while(hasParent(childPos) && getParent(childPos).cost > heap[childPos].cost){
			swap(childPos, getParentPos(childPos));
			childPos = getParentPos(childPos);
		}
	}

	//Insert vertices in heap
	public void add(int v, int value){
		heap[size] = new Vertex(v, value);
		map.put(v, size);
		size++;
		heapifyUp(size - 1);
	}

	public void heapifyDown(){
		int pos = 0;
		while(hasLeftChild(pos)){
			int smallerChildPos = getLeftChildPos(pos);
			if(hasRightChild(pos) && getRightChild(pos).cost < getLeftChild(pos).cost)
				smallerChildPos = getRightChildPos(pos);

			if(heap[pos].cost < heap[smallerChildPos].cost)
				break;
			else
				swap(smallerChildPos, pos);
			
			pos = smallerChildPos;
		}
	}

	//Remove and get lowest cost vertex 
	public Vertex extractMin(){
		Vertex minVertex = heap[0];
		map.remove(minVertex.vertex);
		heap[0] = heap[size-1];
		size--;
		map.put(heap[0].vertex, 0);
		heapifyDown();
		return minVertex;
	}

	//Decrease the cost for given vertex
	public void decrease(int vertex, int value){
		int pos = map.get(vertex);
		heap[pos].cost = value;
		heapifyUp(pos);
	}

	//Check if vertex exists in heap or not
	public boolean contains(int vertex){
		return map.containsKey(vertex);
	}

	//Check if heap is empty or not
	public boolean isEmpty(){
		return size > 0 ? false : true;
	}

}

class DijkstrasShortestPath{
	static Graph g;
	static HeapMap hm;
	static HashMap<Integer, Integer> minDist = new HashMap<Integer, Integer>();	//Mapping = <Vertex, Total Path cost from source vertex>
	static class Edge{
		int src, dest, cost;
		public Edge(int src, int dest, int cost){
			this.src = src;
			this.dest = dest;
			this.cost = cost;
		}
	}
	static class Graph{
		int v;
		LinkedList<Edge> adj[];
		public Graph(int v){
			this.v = v;
			adj = new LinkedList[v];
			for(int i = 0; i < v; i++){
				adj[i] = new LinkedList<Edge>();
			}
		}

		public void addEdge(int src, int dest, int cost){
			adj[src].add(new Edge(src, dest, cost));
			adj[dest].add(new Edge(dest, src, cost));
		}
	}

	//Init heap
	static void initHeapMap(int src){
		hm = new HeapMap(g.v);
		for(int i = 0; i < g.v; i++){
			hm.add(i, Integer.MAX_VALUE);
		}
		hm.decrease(src, 0);
	}

	//Dijkstras shortest path algorithm
	static void getShortestPath(int src){
		while(!hm.isEmpty()){
			Vertex minVertex = hm.extractMin();
			minDist.put(minVertex.vertex, minVertex.cost);
			
			//get all adjacent vertices of minVertex
			LinkedList<Edge> adjVertices = g.adj[minVertex.vertex];
			for(Edge e : adjVertices){
				int currentCost = minDist.get(minVertex.vertex) + e.cost;

				if(hm.contains(e.dest) && currentCost < hm.heap[hm.map.get(e.dest)].cost)
					hm.decrease(e.dest, currentCost);
			}
		}
	}

	//print heap - testing purpose
	static void printHeap(){
		for(int i = 0; i < hm.size; i++){
                        Vertex ver = hm.heap[i];
                        System.out.println("vertex "+ ver.vertex + " vertex cost = "+ver.cost);
                }
	}

	//Print min distances from source to each vertex
	static void printMinDist(int src){
		System.out.println("Source vertex is " + src);
		for(Map.Entry<Integer, Integer> entry : minDist.entrySet()){
			System.out.println(src + " to "+ entry.getKey() + " = " + entry.getValue());
		}
	}
	
	//heap testing
	static void testHeap(){
		Random rand = new Random(1);
		hm = new HeapMap(g.v);
		for(int i = 0; i < g.v; i++){
			hm.add(i, rand.nextInt(50));
		}
		printHeap();
		while(!hm.isEmpty()){
			Vertex ver = hm.extractMin();
                        System.out.println("Extracted vertex "+ ver.vertex + " vertex cost = "+ver.cost);
			printHeap();
		}

	}

	public static void main(String args[]){
		int v = 9;
		int src = 1;
		g = new Graph(v);
		g.addEdge( 0, 1, 4);
		g.addEdge( 0, 7, 8);
		g.addEdge( 1, 2, 8);
		g.addEdge( 1, 7, 11);
		g.addEdge( 2, 3, 7);
		g.addEdge( 2, 8, 2);
		g.addEdge( 2, 5, 4);
		g.addEdge( 3, 4, 9);
		g.addEdge( 3, 5, 14);
		g.addEdge( 4, 5, 10);
		g.addEdge( 5, 6, 2);
		g.addEdge( 6, 7, 1);
		g.addEdge( 6, 8, 6);
		g.addEdge( 7, 8, 7);
		
		initHeapMap(src);

		getShortestPath(src);
		printMinDist(src);
	}
}
