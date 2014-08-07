
public class TapeEquilibrium {

	public int solution(int[] A) {
		int minimum = Integer.MAX_VALUE;
		int pre[] = new int[A.length];
		int post[]= new int[A.length];
		for(int i=1;i<A.length;i++){
			pre[i] = pre[i-1]+A[i-1];
		}
		for(int i=A.length-2;i>=0;i--){
			post[i] = post[i+1]+A[i+1];
		}
		for(int i=1;i<A.length;i++){
			int sum = Math.abs(pre[i]-(A[i]+post[i]));
			if(sum < minimum)
				minimum = sum;
		}
	    return minimum;  
    }
	
	public static void main(String[] args) {
		int a[] = new int[]{3,1,2,4,3};
		System.out.println(new TapeEquilibrium().solution(a));
	}
}
