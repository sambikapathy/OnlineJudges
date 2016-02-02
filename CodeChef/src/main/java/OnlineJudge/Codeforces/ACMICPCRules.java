package OnlineJudge.Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class ACMICPCRules {

	public static void main(String[] args) {
		try{
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(in, out);
		out.close();
		}catch(RuntimeException ex){
			ex.printStackTrace();
		}
	}
	
	static class TaskA {
	    public void solve( InputReader in, PrintWriter out) {
	        int x = in.nextInt();
	        Map<String, List<String>> map = new HashMap<String,List<String>>();
	        int total = 0;
	        List<String> result = new ArrayList<String>();
	        for(int i=0;i<x;i++){
	        	String pre = in.next();
	        	String team = in.next();
	        	List<String> values = map.get(pre);
	        	if(values == null){	        		
	        		values = new ArrayList<String>();
	        		values.add(team);
	        		map.put(pre , values);
	        	}
	        }
	    }
	}
	
	static class InputReader {
	    public BufferedReader reader;
	    public StringTokenizer tokenizer;

	    public InputReader(InputStream stream) {
	        reader = new BufferedReader(new InputStreamReader(stream), 32768);
	        tokenizer = null;
	    }

	    public String next() {
	        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
	            try {
	                tokenizer = new StringTokenizer(reader.readLine());
	            } catch (IOException e) {
	                throw new RuntimeException(e);
	            }
	        }
	        return tokenizer.nextToken();
	    }

	    public int nextInt() {
	        return Integer.parseInt(next());
	    }

	}
}
