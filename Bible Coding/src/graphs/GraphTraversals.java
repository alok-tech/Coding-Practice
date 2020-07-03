package graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class GraphTraversals {
	public static int V = 5;
	public static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

	public static void createGraph(int vertexCount) {
		for (int i = 0; i < vertexCount; i++) {
			adj.add(new ArrayList<>());
		}
	}

	public static void addEdge(int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}

	public static void printGraph() {
		for (int i = 0; i < adj.size(); i++) {
			// Adjacency list of ith Vertex
			System.out.println("\nAdjacency list of vertex" + i);
			ArrayList<Integer> vertex = adj.get(i);
			for (int j = 0; j < vertex.size(); j++) {
				if (j == vertex.size() - 1) {
					System.out.print(vertex.get(j));
				} else {
					System.out.print(vertex.get(j) + "--->");
				}
			}
		}
	}

	public static void bfsTraversal(int s) {
		boolean visited[] = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		// Mark Current Node as visited
		visited[s] = true;
		queue.add(s);
		while (queue.size() != 0) {
			s = queue.poll();
			System.out.println(s + " ");
			Iterator<Integer> it = adj.get(s).listIterator();

			while (it.hasNext()) {
				int n = it.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
	
	public static void dfsWithRecursion (int s) {
		boolean visited[] = new boolean[V];
		if(visited[s])
			return;
		System.out.print(s + " ");
		visited[s] = true;
		for (int u : adj.get(s)) {
			dfsWithRecursion(u);
		}
	}

	public static void dfsTraversal(int s) {
		boolean visited[] = new boolean[V];
		// Create a stack for DFS
		Stack<Integer> stack = new Stack<Integer>();
		// push current Node
		stack.push(s);
		while (!stack.isEmpty()) {
			s = stack.pop();
			if (!visited[s]) {
				System.out.print(s + " ");
				visited[s] = true;
			}
			Iterator<Integer> itr = adj.get(s).iterator();
			while (itr.hasNext()) {
				int v = itr.next();
				if (!visited[v]) {
					stack.push(v);
				}
			}
		}

	}

	public static void main(String[] args) {
		createGraph(V);
		// Adding edges one by one
		/*
		 * addEdge(0, 1); addEdge(0, 4); addEdge(1, 2); addEdge(1, 3); addEdge(1, 4);
		 * addEdge(2, 3); addEdge(3, 4);
		 * 
		 * printGraph();
		 */
		// bfsTraversal(1);
		addEdge(0, 1);
		addEdge(0, 2);
		addEdge(1, 2);
		addEdge(2, 0);
		addEdge(2, 3);
		addEdge(3, 3);
		//bfsTraversal(1);
		//dfsTraversal(1);
		dfsTraversal(1);
	}
}
