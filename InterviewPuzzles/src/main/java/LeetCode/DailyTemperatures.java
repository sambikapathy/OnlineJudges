package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
 * <p>
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * <p>
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 *
 *
 * 73,74,75
 * 75,74,69,73
 * 70, 75, 71,72, 73, 76
 *
 * 73,72,71,75
 */

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] input) {
        int [] output = new int[input.length];

        Map<Integer,Integer> count = new HashMap<>();
        Arrays.stream(input).forEach(i -> count.put(i,count.getOrDefault(i,0)+1));

        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<input.length;i++){

            while(!stack.isEmpty() && input[i] > input[stack.peek()]){
                int idx = stack.pop();
                output[idx] = i-idx;
            }
            stack.push(i);
        }
        return output;
    }

    public int[] dailyTemperatures_bruteforce(int[] T) {
        int [] output = new int[T.length];
        for(int i=0;i<T.length;i++){
            int result = 0;
            for(int j=i+1;j<T.length;j++){
                if(T[j] > T[i]){
                    result = j-i;
                    break;
                }
            }
            output[i] = result;

        }
        return output;
    }

    public static void main(String[] args) {
        int [] input = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = new DailyTemperatures().dailyTemperatures(input);
        Arrays.stream(result).forEach(i-> System.out.print(i+","));

        System.out.println();
        result = new DailyTemperatures().dailyTemperatures_bruteforce(input);
        Arrays.stream(result).forEach(i-> System.out.print(i+","));

    }

}
