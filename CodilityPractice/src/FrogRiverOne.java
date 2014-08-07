
public class FrogRiverOne {

	 public int solution(int X, int[] A) {
		 int []time = new int[A.length];
		 int count = 0,sec=0;
		 for(int i : A){
			 if(i>A.length){
				 continue;
			 }
			 if(time[i-1]==0){
				 count++;
				 time[i-1] = 1;
				 if(count==X)
					 return sec;
			 }
			 sec++;
		 }
		 return -1;
	    }
	 
	 public static void main(String[] args) {
			int a[] = new int[]{7,6};
			System.out.println(new FrogRiverOne().solution(5,a));
		}
}
