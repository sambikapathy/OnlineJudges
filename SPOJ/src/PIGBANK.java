import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class PIGBANK {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		for(int i=0;i<t;i++){
			StringTokenizer st = new StringTokenizer(in.readLine()); 
			int diff = Math.abs(Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken()));
			double minValue = Double.MAX_VALUE;
			for(int j=0;j<Integer.parseInt(in.readLine());j++){
				StringTokenizer st1 = new StringTokenizer(in.readLine());
				int mValue = Integer.parseInt(st1.nextToken());
				int weight = Integer.parseInt(st1.nextToken());
				double val = mValue/weight;
				if(val < minValue){
					minValue = val;
				}
					
			}
		}
	}
}
