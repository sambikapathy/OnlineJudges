

public class CANDY3 {

	public static void main(String[] args) throws Exception{
		 java.io.BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
	     int total = Integer.parseInt(r.readLine());
	     for(int i=0;i<total;i++){
	    	 r.readLine();
	    	 int size = Integer.parseInt(r.readLine());
	    	 int result = 0;
	    	 for(int j=0;j<size;j++){
	    		 result+= Integer.parseInt(r.readLine());
	    	 }
	    	 if(result%size==0){
	    		 System.out.println("YES");
	    	 }else{
	    		 System.out.println("NO");
	    	 }
	     }
	}
}
