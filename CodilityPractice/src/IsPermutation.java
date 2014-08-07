
public class IsPermutation {

	public int solution(int[] A) {
		int []occ = new int[A.length];
		for(int i : A){
			if(i>A.length){
				return 0;
			}
			occ[i-1] = occ[i-1]+1;
		}
		
		for(int i : occ){
			if(i!=1){
				return 0;
			}
		}
		return 1;
		
    }
	
	public static void main(String[] args) {
		int a[] = new int[]{3,1,4};
		System.out.println(new IsPermutation().solution(a));
	}
}
