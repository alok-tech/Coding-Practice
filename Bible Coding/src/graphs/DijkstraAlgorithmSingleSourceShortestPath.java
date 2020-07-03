package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class DijkstraAlgorithmSingleSourceShortestPath {

	public static int V = 5;
	public static ArrayList<ArrayList<Edge>> adj = new ArrayList<ArrayList<Edge>>();

	private static int dist[] = new int[V];

	private static Set<Integer> settled = new HashSet<Integer>();
	// Priority queue by default is Ascending order i.e 1 has high priority
	// than 2 and 2 has high priority than 3
	private static PriorityQueue<Node> pq = new PriorityQueue<Node>(V, new Node());

	public static void createGraph(int vertexCount) {
		for (int i = 0; i < vertexCount; i++) {
			adj.add(new ArrayList<Edge>());
		}
	}

	public static void dijkstraAlgorithm(int src) {
		for (int i = 0; i < V; i++)
			dist[i] = Integer.MAX_VALUE;

		pq.add(new Node(src, 0));
		dist[src] = 0;

		while (settled.size() != V) {
			// remove the minimum distance node
			// from the priority queue
			int u = pq.remove().node;
			settled.add(u);
			explore_Neighbours(u);
		}

	}

	// Function to process all the neighbours
	// of the passed node
	private static void explore_Neighbours(int u) {
		int edgeDistance = -1;
		int newDistance = -1;

		// All the neighbors of v
		for (int i = 0; i < adj.get(u).size(); i++) {
			Edge v = adj.get(u).get(i);
			// If current node hasn't already been processed
			if (!settled.contains(v.getEnd())) {
				edgeDistance = v.weight;
				newDistance = dist[u] + edgeDistance;
				if (newDistance < dist[v.getEnd()]) {
					dist[v.getEnd()] = newDistance;
				}
				Node next = new Node(v.getEnd(), dist[v.getEnd()]);
				pq.add(next);
			}
		}

	}

	public static void addEdge(int start, int end, int weight) {
		adj.get(start).add(new Edge(start, end, weight));
		adj.get(end).add(new Edge(end, start, weight));
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
		dijkstraAlgorithm(0);
		

		for (int i = 0; i < dist.length; i++)
			System.out.println("0" + " to " + i + " is " + dist[i]);
	}
}
