package LeetCode;
public class HouseRobber1  {
    //1 0 1 0 1
    //1 2 3 4 5
    //1 2 1 8 1
    //2 1 2 8
    //10 1 1 10
    //1 10 1 10
    public int rob(int[] nums) {
        if(nums.length <= 2){
            if(nums.length ==2 ){
                return nums[0]>nums[1]?nums[0]:nums[1];
            }else if(nums.length ==1){
                return nums[0];
            }
            return 0;
        }
        int []max = new int[nums.length];
        max[0] = nums[0];
        max[1] = nums[1];
        for(int i=2;i<nums.length;i++){
            for(int j=i-2;j>=0;j--){
                if(max[j]+nums[i] > max[i]){
                    max[i] = max[j]+nums[i];
                }
            }
        }
        int result = 0;
        for(int i=0;i<nums.length;i++){
            if(max[i] > result){
                result = max[i];
            }
        }
        return result;
    }
}