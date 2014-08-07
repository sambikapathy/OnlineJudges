

public class MISERMAN {

	public static void main(String[] args) throws Exception {
		java.io.BufferedReader r = new java.io.BufferedReader(
				new java.io.InputStreamReader(System.in));
		String [] input = r.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		int [][]array = new int[n][m];
		for(int i=0;i<n;i++){
			String []splits = r.readLine().split(" ");
			for(int j=0;j<m;j++){
				int value = Integer.parseInt(splits[j]);
				array[i][j] = value;
				if(i==0){
					continue;
				}
				int x = value+array[i-1][j];
				int min = x;
				if(j>0){
					int y = array[i-1][j-1]+value;
					if(y < min){
						min = y;
					}
				}
				if(j+1<m){
					int y = array[i-1][j+1]+value;
					if(y < min){
						min = y;
					}
				}
				array[i][j] = min;
				
			}
		}
		int min = array[n-1][0];
		for(int j=0;j<m;j++){
			int value = array[n-1][j];
			if(value < min){
				min= value;
			}
		}
		System.out.println(min);
	}
}
