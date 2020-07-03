package graphs;

import java.util.ArrayList;

public class BellmanFordSingleSourceShortestPath {

	public static int V = 5;
	public static int E = 7;
	public static ArrayList<ArrayList<Edge>> adj = new ArrayList<ArrayList<Edge>>();
	
	public static ArrayList<Edge> edges = new ArrayList<Edge>();

	private static int dist[] = new int[V];

	public static void createGraph(int vertexCount) {
		for (int i = 0; i < vertexCount; i++) {
			adj.add(new ArrayList<Edge>());
		}
	}

	public static void bellmanFordAlgorithm(int src) {
		for (int i = 0; i < V; i++)
			dist[i] = Integer.MAX_VALUE;

		dist[src] = 0;

		for (int i = 1; i < V; ++i) {
			for (int j = 0; j < E; ++j) {
				int u = edges.get(j).getStart();
				int v = edges.get(j).getEnd();
				int weight = edges.get(j).weight;
				if(dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
					dist[v] = dist[u] + weight;
				}
			}
		}
		// Also check for negative-weight cycles.
		// If we still get a shorter path, then there is a cycle of negative weight.
		for (int j = 0; j < E; ++j) {
			int u = edges.get(j).getStart();
			int v = edges.get(j).getEnd();
			int weight = edges.get(j).weight;
			if(dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle"); 
                return; 
			}
		}
		printArr(dist, V);
	}
	
    // A utility function used to print the solution 
    public static void printArr(int dist[], int V) 
    { 
        System.out.println("Vertex Distance from Source"); 
        for (int i = 0; i < V; ++i) 
            System.out.println(i + "\t\t" + dist[i]); 
    } 

	public static void addEdge(int start, int end, int weight) {
		Edge one = new Edge(start, end, weight);
		Edge two = new Edge(end, start, weight);
		adj.get(start).add(one);
		adj.get(end).add(two);
	
		edges.add(one);
		edges.add(two);
	}

	public static void printGraph() {
		for (int i = 0; i < adj.size(); i++) {
			// Adjacency list of ith Vertex
			System.out.println("\nAdjacency list of vertex" + i);
			ArrayList<Edge> vertex = adj.get(i);
			for (int j = 0; j < vertex.size(); j++) {
				if (j == vertex.size() - 1) {
					System.out.print(vertex.get(j).getStart() + "--->" + vertex.get(j).getEnd() + " Weight"
							+ vertex.get(j).getWeight() + " ");
				} else {
					System.out.print(vertex.get(j).getStart() + "--->" + vertex.get(j).getEnd() + " Weight"
							+ vertex.get(j).getWeight() + " ");
				}
			}
		}
	}

	public static void main(String[] args) {
		createGraph(V);
		// Adding edges one by one
		addEdge(0, 1, 2);
		addEdge(0, 4, 4);
		addEdge(1, 2, 7);
		addEdge(1, 3, 9);
		addEdge(1, 4, 8);
		addEdge(2, 3, 3);
		addEdge(3, 4, 5);
		bellmanFordAlgorithm(0);
	}
}
