package LeetCode;

public class SortColors {

	public void sortColors(int[] nums) {
	       int l = 0 , r = nums.length-1;
	       int length = nums.length;
	       while(l < r){
	           while(nums[l] == 0 && l < length){
	               l++;
	           }
	           //0 1 2 0 0 1
	           while(r>=0 && (nums[r] == 1 || nums[r]==2)){
	               r--;
	           }
	           if(l < r){
	           int t = nums[r];
	           nums[r] = nums[l];
	           nums[l] = t;
	           l++;
	           r--;
	           }
	       }
	       
	       r = nums.length-1;
//	       l++;
	       if(l < nums.length)
	       while(l < r){
	           while(nums[l] == 1 && l < length){
	               l++;
	           }
	           //0 1 2 0 0 1
	           while(r >= 0 && nums[r]==2){
	               r--;
	           }
	           if(l<r){
	           int t = nums[r];
	           nums[r] = nums[l];
	           nums[l] = t;
	           l++;
	           r--;
	           }
	       }
	    }
	 
	 public static void main(String[] args) {
		int nums[] = {1,0,0};
		new SortColors().sortColors(nums);
		System.out.println(nums);
	}
}
