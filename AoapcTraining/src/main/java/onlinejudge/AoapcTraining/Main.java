package onlinejudge.AoapcTraining;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 11292 - Dragon of Loowater
 */
public class Main {
	
    public static void main (String args[])  throws Exception// entry point from OS
    {
    	/*BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	while(true){
    		String input = in.readLine();
    		int m = Integer.parseInt(input.split(" ")[0]);
    		int n= Integer.parseInt(input.split(" ")[1]);
    		if(m==0 && n==0) break;
    		int []dragon = new int[m];
    		int []knight = new int[n];
    		for(int i=0;i<m;i++) dragon[i] = Integer.parseInt(in.readLine());
    		for(int i=0;i<n;i++) knight[i] = Integer.parseInt(in.readLine());
    		
    		Arrays.sort(dragon);
    		Arrays.sort(knight);
    		
    		int di = 0;
    		long total=0;
    		for(int i=0;i<n && di < m;i++){
    			if(knight[i]>= dragon[di]){
    				di++;
    				total+= knight[i];
    			}
    		}
    		if(di<m){
    			System.out.println("Loowater is doomed!");
    		}else{
    			System.out.println(total);
    		}
    		
    	}*/
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(;;){
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			int N = parseInt(st.nextToken()), M = parseInt(st.nextToken());
			if(M==0&&N==0)break;
			int[] heads = new int[N], knights = new int[M];
			for (int i = 0; i < N; i++) heads[i] = parseInt(in.readLine().trim());
			for (int i = 0; i < M; i++) knights[i] = parseInt(in.readLine().trim());
			long res = 0;
			Arrays.sort(heads);
			Arrays.sort(knights);
			int k = 0;
			for (int i = 0; i < knights.length && k < heads.length; i++)
				if(knights[i]>=heads[k]){
					res+=knights[i];
					k++;
				}
			if(k < heads.length)System.out.println("Loowater is doomed!");
			else System.out.println(res);
		}
    }
}
