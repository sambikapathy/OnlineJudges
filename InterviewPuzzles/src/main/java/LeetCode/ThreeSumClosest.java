package LeetCode;

import java.util.Arrays;

public class ThreeSumClosest {

	public static int threeSumClosest(int[] nums, int target) {
        if(nums.length <= 3){
            int t = 0;
            for(int i : nums)
                t+= i;
            return t;
        }
        Arrays.sort(nums);
        int sum = nums[0]+nums[1]+nums[2];
        for(int i=0;i<=nums.length-3;i++){
            int s = i+1;
            int e = nums.length-1;
            while(s<e){
                int t = nums[i] + nums[s] + nums[e];
                if(t == target){
                    return t;
                }
                int o = Math.abs(target-sum);
                int n = Math.abs(target - t);
                
                if(o < n){
                    e--;
                }else{
                    sum = t;
                    //o = n;
                    s++;
                }
            }
        }
        return sum;
    }
	
	public static void main(String[] args) {
		int [] array = {1,2,4,8,16,32,64,128};
		int target = 82;
		System.out.println(threeSumClosest(array , target));
	}
}
