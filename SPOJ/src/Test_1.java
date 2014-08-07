
public class Test_1 {
	public static void main (String[] args) throws java.lang.Exception
	  {
	     java.io.BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
	     String s;
	     while (!(s=r.readLine()).startsWith("42")) System.out.println(s);
	  }
	
	public static void main1 (String[] args) throws java.lang.Exception
	  {
		java.io.BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
	     calculatePrimes();
	     int count = Integer.parseInt(r.readLine());
	     for(int i=0;i<count;i++){
	    	 String str[] = r.readLine().split(" ");
	    	 long sTime = System.currentTimeMillis();
	    	 printPrimes(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
	    	 System.out.println();
	    	 long eTime = System.currentTimeMillis();
	    	 System.out.println("Time taken"+(eTime-sTime));
	     }
	    // printPrimes(1, 2);
	     /*for(int i = 0;i<count;i++){
	    	 System.out.print(primes[i]+" ");
	     }*/
	     
	     
	     
	  }
	
	private static void printPrimes(int x , int y){
		int max=y-x+1; 
		boolean [] isPrime = new boolean[max];
		
		for(int i=0;i<max;i++){
			isPrime[i] = true;
		}
		for(int i=0;i<count;i++){
			int j = primes[i];
			int index = 2;
			for(j=j*index;j<=y;j=primes[i]*index){
				index++;
				if(j<x ||  j>y)
					continue;
				isPrime[j-x] = false;
//				j = j* index;
			}
		}
		
		if(x==1)
			isPrime[x-1]=false;
		for(int i=0;i<max;i++){
//			if((i+x)%2==0)
//				continue;
			if(isPrime[i])
			System.out.println((i+x));
		}
	}
	
	
	static int []primes = new int[31624];
	
	static int count = 0;
	private static void calculatePrimes(){
		primes[count++] = 2;
		for(int i=3;i<31624;i+=2){
			boolean isPrime = true;
			for(int j=3;j<=Math.sqrt(i)+1;j+=2){
				if(i%j==0){
					isPrime = false;
					break;
				}
			}
			if(isPrime){
				primes[count++] = i;
			}
		}
	}
	//31623
	//100000
	
}

