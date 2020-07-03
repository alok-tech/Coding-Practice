package graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Graph {
	
	public static int V = 5;
	public static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	
	// For Shortest Path and Weighted Graph
	PriorityQueue<Integer> PQ = new PriorityQueue<>();
	
	public static void createGraph(int vertexCount) {
		for(int i = 0; i< vertexCount; i++) {
			adj.add(new ArrayList<>());
		}
	}
	
	public static void addEdge(int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	
	public static void printGraph(){
		for(int i = 0; i < adj.size(); i++) {
			// Adjacency list of ith Vertex
			System.out.println("\nAdjacency list of vertex" + i); 
			ArrayList<Integer> vertex = adj.get(i);
			for(int j=0; j< vertex.size(); j++) {
				if (j == vertex.size()-1) {
					System.out.print(vertex.get(j));
				}else {
					System.out.print(vertex.get(j) + "--->");
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		createGraph(V);
        // Adding edges one by one 
        addEdge(0, 1); 
        addEdge(0, 4); 
        addEdge(1, 2); 
        addEdge(1, 3); 
        addEdge(1, 4); 
        addEdge(2, 3); 
        addEdge(3, 4);
        printGraph();
	}
}
