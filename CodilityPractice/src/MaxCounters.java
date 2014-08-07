public class MaxCounters {

	public int[] solution(int N, int[] A) {
		int []array = new int[N];
		int max = 0;
		int total = 0;
		boolean isnew = true;
		for (int i : A) {
			if (i ==( array.length + 1)) {
				
//				for (int j = 0; j < array.length; j++) {
//					array[j] = max;
//				}
				if(!isnew){
				array = new int[N];
				total+=max;
				max = 0;
				}
			} else {
				int val = ++array[i - 1];
				if (val > max) {
					max = val;
				}
				isnew = false;
			}
		}
		
		for (int j = 0; j < array.length; j++) {
			array[j] += total;
		}

		
		return array;
	}

	public static void main(String[] args) {
		int a[] = new int[]{3,4,4,6,1,4,4};
		int [] result = (new MaxCounters().solution(5,a));
		for(int i : result){
			System.out.print(i+",");
		}
	}
}
