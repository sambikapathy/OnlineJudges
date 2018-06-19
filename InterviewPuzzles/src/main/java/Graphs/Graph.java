package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

	GraphNode[] nodes;

	public Graph(int v) {
		nodes = new GraphNode[v];
	}

	private void addEdge(int src, int dest) {
		GraphNode start = nodes[src];
		GraphNode end = nodes[dest];

		if (start == null) {
			start = new GraphNode(src);
			nodes[src] = start;
		}
		if (end == null) {
			end = new GraphNode(dest);
			nodes[dest] = end;
		}

		start.neighbours.add(end);
	}

	private void print() {
		for (int i = 0; i < nodes.length; i++) {
			GraphNode node = nodes[i];
			if (node != null) {
				System.out.println();
			}

		}
	}

	public void dfs(int v, boolean[] isVisited) {
		if (isVisited[v]) {
			return;
		}

		GraphNode node = nodes[v];
		System.out.println("Visited " + v);
		isVisited[v] = true;
		if (node != null)
			for (GraphNode node1 : node.neighbours) {
				dfs(node1.vertex, isVisited);
			}
	}

	public void bfs(int v, boolean[] isVisited) {
		if (isVisited[v]) {
			return;
		}

		GraphNode node = nodes[v];
		Queue<GraphNode> q = new LinkedList<GraphNode>();
		q.add(node);
		while (q.size() > 0) {
			GraphNode temp = q.poll();
			System.out.println("Visited " + temp.vertex);
			isVisited[temp.vertex] = true;
			for (GraphNode node1 : temp.neighbours) {
				if (!isVisited[node1.vertex])
					q.add(node1);
			}
		}
	}

	// FIXME
	public void topologySorting() {

	}

	// FIXME
	public boolean isCyclePresent() {
		return false;
	}

	public static Graph createGraph(int v, String input) {
		String[] conn = input.split(",");
		Graph graph = new Graph(v);
		for (int i = 0; i < conn.length - 1;) {
			graph.addEdge(Integer.parseInt(conn[i]), Integer.parseInt(conn[i + 1]));
			i += 2;
		}
		return graph;
	}

	public static void main(String[] args) {
		String input = "0,1,0,2,1,3";
		int v = 4;
		Graph graph = createGraph(v, input);
		graph.print();

		System.out.println("###DFS");
		graph.dfs(0, new boolean[v]);

		System.out.println("###BFS");
		graph.bfs(0, new boolean[v]);

	}

}

class GraphNode {
	int vertex;
	List<GraphNode> neighbours;

	public GraphNode(int vertex) {
		this.vertex = vertex;
		neighbours = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "GraphNode [vertex=" + vertex + "]";
	}

}
