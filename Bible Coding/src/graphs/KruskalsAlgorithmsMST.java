package graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KruskalsAlgorithmsMST {
	public static int V = 5;
	public static ArrayList<ArrayList<Edge>> adj = new ArrayList<ArrayList<Edge>>();
	public static ArrayList<Edge> allEdges = new ArrayList<>();

	public static void createGraph(int vertexCount) {
		for (int i = 0; i < vertexCount; i++) {
			adj.add(new ArrayList<Edge>());
		}
	}

	public static void mstKruskals() {

		 /* 1. Sort all the edges in non-decreasing order of their weight. 2. Pick the
		 * smallest edge. Check if it forms a cycle with the spanning tree formed so
		 * far. If cycle is not formed, include this edge. Else, discard it. 3. Repeat
		 * step#2 until there are (V-1) edges in the spanning tree.
		 */

		PriorityQueue<Edge> pq = new PriorityQueue<>(allEdges.size(), Comparator.comparingInt(o -> o.weight));

		// add all the edges to priority queue, //sort the edges on weights
		for (int i = 0; i < allEdges.size(); i++) {
			pq.add(allEdges.get(i));
		}

		// create a parent []
		int[] parent = new int[V];

		ArrayList<Edge> mst = new ArrayList<>();

		// process vertices - 1 edges
		int index = 0;
		while (index < V - 1) {
			Edge edge = pq.remove();
			// check if adding this edge creates a cycle
			int x_set = find(parent, edge.getStart());
			int y_set = find(parent, edge.getEnd());

			if (x_set == y_set) {
				// ignore, will create cycle
			} else {
				// add it to our final result
				mst.add(edge);
				index++;
				union(parent, x_set, y_set);
			}
		}
		// print MST
		System.out.println("Minimum Spanning Tree: ");
		printGraph(mst);
	}

	public void makeSet(int[] parent) {
		// Make set- creating a new element with a parent pointer to itself.
		for (int i = 0; i < V; i++) {
			parent[i] = i;
		}
	}

	public static int find(int[] parent, int vertex) {
		// chain of parent pointers from x upwards through the tree
		// until an element is reached whose parent is itself
		if (parent[vertex] != vertex)
			return find(parent, parent[vertex]);
		;
		return vertex;
	}

	public static void union(int[] parent, int x, int y) {
		int x_set_parent = find(parent, x);
		int y_set_parent = find(parent, y);
		// make x as parent of y
		parent[y_set_parent] = x_set_parent;
	}

	public static void addEdge(int start, int end, int weight) {
		Edge edge = new Edge(start, end, weight);
		adj.get(start).add(edge);
		adj.get(end).add(new Edge(end, start, weight));
		allEdges.add(edge);
	}

	public static void printGraph(ArrayList<Edge> edgeList) {
		for (int i = 0; i < edgeList.size(); i++) {
			Edge edge = edgeList.get(i);
			System.out.println("Edge-" + i + " source: " + edge.getStart() + " destination: " + edge.getEnd()
					+ " weight: " + edge.weight);
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
		mstKruskals();
		// printGraph();
	}
}
