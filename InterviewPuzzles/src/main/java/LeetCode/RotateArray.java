package LeetCode;


public class RotateArray {

	public static void main(String[] args) {
		int [] input = {1,2};
		int k=  1;
		new RotateArray().rotate(input, k);
		for(int i : input){
			System.out.print(i+" ");
		}
	}
	
    public void rotate(int[] nums, int k) {
        if(nums == null) return ;
        
        int s = nums.length;
        int [] temp = new int[s];
        for(int i=0;i<s;i++){
           System.out.println((i+k)%s +" - > "+nums[i]);
            temp[(i+k)%s] = nums[i];
        }
        
        nums = temp;
    }
}
