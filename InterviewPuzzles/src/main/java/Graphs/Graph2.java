package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Graph2 {

	GraphNode [] nodes;
	
	public Graph2(int v){
		nodes = new GraphNode[v];
	}
	
	private void addEdge(int src , int dest){
		GraphNode node = nodes[src];
		GraphNode end = new GraphNode(dest);
		if(node == null){
			GraphNode start = new GraphNode(src);
			nodes[src] = start;
			start.next = end;
		}else{
			GraphNode temp = node;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = end;
		}
	}
	
	private void print(){
		for(int i=0;i<nodes.length;i++){
			GraphNode node = nodes[i];
			if(node != null){
				System.out.print(node.vertex+" ");
				node = node.next;
				while(node != null){
					System.out.print(" -> "+ node.vertex);
					node = node.next;
				}
				System.out.println();
			}
			
		}
	}
	
	public void dfs(int v , boolean[]isVisited){
		if(isVisited[v]){
			return;
		}
		
		GraphNode node = nodes[v];		
		System.out.println("Visited "+ v);
		isVisited[v] = true;
		if(node != null)
		while(node.next != null){
			dfs(node.next.vertex , isVisited);
			node = node.next;
		}
	}
	
	public void bfs(int v , boolean[]isVisited){
		if(isVisited[v]){
			return;
		}
		
		GraphNode node = nodes[v];
		Queue<GraphNode> q = new LinkedList<GraphNode>();
		q.add(node);
		while(q.size() > 0){
			GraphNode temp = q.poll();
			System.out.println("Visited "+ temp.vertex);
			isVisited[temp.vertex] = true;
			while(temp.next != null && !isVisited[temp.next.vertex]){
				q.add(temp.next);
				temp = temp.next;
			}
		}
		
	}
	
	public void topologySorting(){
		
	}
	
	public static Graph2 createGraph(int v , String input){
		String []conn = input.split(",");
		Graph2 graph = new Graph2(v);
		for(int i=0;i<conn.length-1;){
			graph.addEdge(Integer.parseInt(conn[i]), Integer.parseInt(conn[i+1]));
			i+=2;
		}
		return graph;
	}
	
	public static void main(String[] args) {
		String input = "0,1,0,2,1,2,2,0,2,3,3,3";
		int v = 4;
		Graph2 graph = createGraph(v, input);
		graph.print();
		
		System.out.println("###DFS");
		graph.dfs(2, new boolean[v]);
		
		System.out.println("###BFS");
		graph.bfs(2, new boolean[v]);
		
		
	}
	
}

class GraphNode{
	int vertex;
	GraphNode next;
	
	public GraphNode(int vertex) {
		this.vertex = vertex;
	}

	@Override
	public String toString() {
		return "GraphNode [vertex=" + vertex + "]";
	}
	
	
}
