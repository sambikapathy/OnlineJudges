package coderbat;

public class SplitArray {

	public static void main(String[] args) {
		System.out.println(new SplitArray().splitArray(new int[]{1, 1, 1, 1, 1}) );
	}
	public boolean splitArray(int[] nums) {
		  int []second = new int[nums.length];
		  return splitArray(0 ,0, nums , second);
		}

		public boolean splitArray(int i , int j ,  int[] one , int[] two) {
		int sum1 = 0,sum2 = 0;
		  for(int x=0;x<one.length;x++)
		    sum1+=one[x];
		  
		  for(int x=0;x<two.length;x++)
		   sum2+=two[x];
		   
		  if(sum1 == sum2) return true;
		  
		  for(int x=i;x<one.length;x++){
		   two[j] = one[x];
		   int temp = one[x];
		   one[x] = 0;
		   
		   if(splitArray(i+1,j+1, one , two)) return true;
		   one[x] = temp;
		   two[j] = 0;
		  }
		  
		  return false;
		}
}
