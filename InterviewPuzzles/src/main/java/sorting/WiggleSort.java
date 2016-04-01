package sorting;

public class WiggleSort {

	public void wiggleSort(int[] nums) {
		int l = nums.length;
		int s = 0 , e = l-1;
		
		int pivot = getPivot(nums);
		while(s < e){
			while(nums[s] < pivot){
				s++;
			}
			
			while(nums[e] >= pivot){
				e--;
			}
			if(s < e){
			int t = nums[e];
			nums[e] = nums[s];
			nums[s] = t;
			s++;
			e--;
			}
		}
		System.out.println();
		for(int i : nums){
			System.out.print(i+" ");
		}
	}
	
	private int getPivot(int[] nums) {
		return nums[nums.length/2];
	}

	public static void main(String[] args) {
		int []input = {6,5,4,2};
		new WiggleSort().wiggleSort(input);
	}
}
