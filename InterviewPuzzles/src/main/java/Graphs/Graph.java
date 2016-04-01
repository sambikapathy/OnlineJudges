package Graphs;

public class Graph {

	int [][] matrix;
	public Graph(int size){
		matrix = new int[size][size];
	}
	
	public void addEdge(int src , int dest){
		matrix[src][dest]  = 1;
	}
	
	public void print(){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static Graph createGraph(int v , String input){
		String []conn = input.split(",");
		Graph graph = new Graph(v);
		for(int i=0;i<conn.length-1;){
			graph.addEdge(Integer.parseInt(conn[i]), Integer.parseInt(conn[i+1]));
			i+=2;
		}
		return graph;
	}
	public static void main(String[] args) {
		String input = "0,1,0,2,1,3";
		int v = 4;
		createGraph(v, input).print();
	}
}
