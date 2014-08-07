import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BYTESM2 {

	static int [][] array = null;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader	f = new BufferedReader(new InputStreamReader(System.in));
		int total = parseInt(f.readLine());
		StringTokenizer st;
		int index = 0;
		while(index < total){
			st = new StringTokenizer(f.readLine());
			int h = parseInt(st.nextToken());
			int w = parseInt(st.nextToken());
			array = new int[h][w];
			
			for(int i=0;i<h;i++){
				for(int j=0;j<w;j++){
					if(!st.hasMoreTokens()) st = new StringTokenizer(f.readLine());
					array[i][j] = parseInt(st.nextToken());
					if(i<1){
						continue;
					}
					int t = array[i-1][j];
					int l =0 , r = 0;
					if(j-1>=0){
						l = array[i-1][j-1];
					}
					if(j+1<w){
						r = array[i-1][j+1];
					}
					int max = (l<r)?(r<t?t:r):(l<t?t:l);
					array[i][j]+=max;
				}
			}
			int max = 0;
			for(int j=0;j<w;j++){
				if(array[h-1][j] > max){
					max = array[h-1][j];
				}
			}
			System.out.println(max);
			index++;
		}
	}
}
