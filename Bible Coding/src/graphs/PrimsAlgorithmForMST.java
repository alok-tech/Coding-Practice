package graphs;

import java.util.ArrayList;
public class PrimsAlgorithmForMST {

	public static int V = 5;
	public static ArrayList<ArrayList<Edge>> adj = new ArrayList<ArrayList<Edge>>();
	public static void createGraph(int vertexCount) {
		for (int i = 0; i < vertexCount; i++) {
			adj.add(new ArrayList<Edge>());
		}
	}

	
	public static void mstPrims(int s) {
		// Avoid any edge which makes a circle
		int sum = 0;
		int edgeCount = V - 1;
		String path = "" + s;
		boolean[] visited = new boolean[V];
		while (edgeCount > 0) {
			int index = 0;
			ArrayList<Edge> vertex = adj.get(s);
			visited[s] = true;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < vertex.size(); i++) {
				if (vertex.get(i).getWeight() < min && !visited[vertex.get(i).getEnd()]) {
					min = vertex.get(i).getWeight();
					s = vertex.get(i).getEnd();
					path = path + "--> " + s;
				}
			}
			sum = sum + min;
			edgeCount--;
		}
		System.out.println(sum);
		System.out.println(path);
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
		mstPrims(1);
		// printGraph();
	}
}
