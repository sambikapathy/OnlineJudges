
public class MissingInteger {

	public int solution(int[] A) {
		int a[] = new int[A.length];
		for(int i:A){
			a[i-1]++;
		}
		for(int i=0;i<a.length;i++){
			if(a[i]==0){
				return i+1;
			}
		}
		return -1;
    }
	
	public static void main(String[] args) {
		int a[] = new int[]{3,2,4,6,1,4,4};
		System.out.println(new MissingInteger().solution(a));
	}
}
