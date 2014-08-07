
public class PermMissingElement {

	public int solution(int[] A) {
		long total =0;
		for(int i : A){
			total+=i;
		}
		long n = A.length+1;
		long sum = (n*(n+1))/2;
	    return (int) Math.abs(total-sum);  
    }
	
	public static void main(String[] args) {
		int a[] = new int[]{3,1,2,4,7,5};
		System.out.println(new PermMissingElement().solution(a));
	}
}
