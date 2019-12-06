package LeetCode;

import java.util.Arrays;

public class SortingAlgos {

    public static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    index = j;
                }
            }

            int t = nums[i];
            nums[i] = nums[index];
            nums[index] = t;
        }

        System.out.println(Arrays.toString(nums));

    }

    public static void main(String[] args) {
        int[] input = {2, 5, 4, 5, 1};
        selectionSort(input);
    }
}
