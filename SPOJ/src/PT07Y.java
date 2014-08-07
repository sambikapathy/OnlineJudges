import java.util.Scanner;

public class PT07Y {

	static int[][] matrix = null;
	static boolean[] bool = null;

	public static void main(String[] args) {
		Scanner z = new Scanner(System.in);
		int nodes = z.nextInt();
		int edges = z.nextInt();
		matrix = new int[nodes][nodes];
		for (int i = 0; i < edges; i++) {
			int s = z.nextInt() - 1;
			int e = z.nextInt() - 1;
			matrix[s][e] =1;// matrix[e][s] = 
		}
		bool = new boolean[nodes];
		boolean failed = false;
		for(int i=0;i<nodes;i++){
			if(bool[i]!=true){
				boolean value = dfs(i);
				if(!value){
					failed = true;
					System.out.println("NO");
					break;
				}else{
					bool[i]=true;
				}
			}
		}
		if(!failed)
		System.out.println("YES");

	}
	
	public static boolean dfs(int vertex){
		if(bool[vertex]){
			return false;
		}
		bool[vertex] = true;
		for(int i=0;i<matrix[vertex].length;i++){
			if(matrix[vertex][i]==1){
				boolean value =  dfs(i);
				if(!value){
					return false;
				}
			}
		}
		return true;
	}
}
