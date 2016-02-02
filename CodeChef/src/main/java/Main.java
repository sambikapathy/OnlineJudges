
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

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
	        int y = in.nextInt();
	        
	        String result = "";
	        while(x > 0){
	        	int i = x%10;
	        	int j = y%10;
	        	int k = Math.abs(i-j);
	        	result  += k;
	        	
	        	x/=10;
	        	y/=10;
	        }
	        StringBuilder sb = new StringBuilder(result);
	        sb.reverse();
	        for(int i=0;i<sb.length();i++){
	        	if(sb.charAt(i) != '0'){
	        		out.println(sb.substring(i));
	        		break;
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

