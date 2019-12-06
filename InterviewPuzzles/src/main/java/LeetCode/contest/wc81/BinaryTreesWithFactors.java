package LeetCode.contest.wc81;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BinaryTreesWithFactors {
    /**
     * Given an array of unique integers, each integer is strictly greater than 1.
     * <p>
     * We make a binary tree using these integers and each number may be used for any number of times.
     * <p>
     * Each non-leaf node's value should be equal to the product of the values of it's children.
     * <p>
     * How many binary trees can we make?  Return the answer modulo 10 ** 9 + 7.
     * <p>
     * Example 1:
     * <p>
     * Input: A = [2, 4]
     * Output: 3
     * Explanation: We can make these trees: [2], [4], [4, 2, 2]
     * <p>
     * Example 2:
     * <p>
     * Input: A = [2, 4, 5, 10]
     * Output: 7
     * Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
     * <p>
     * <p>
     * <p>
     * Note:
     * <p>
     * 1 <= A.length <= 1000.
     * 2 <= A[i] <= 10 ^ 9.
     */

    public int numFactoredBinaryTrees(int[] A) {
        return -1;
    }

    public void findFactors(Map<Integer,List<Set<Integer>>> result,int original, int num, int[] input, int index, List<Integer> factors) {

        if (factors.size() > 2) {
            return;
        }
        if (num == 1) {
            Set<Integer> values = new HashSet<>(factors);
            if(!result.containsKey(original)) {
                result.put(original,new ArrayList<>());
            }
            result.get(original).add(values);
            return;
        }
        for (int i = index; i < input.length; i++) {
            if (num % input[i] == 0) {
                factors.add(input[i]);
                findFactors(result,original,num / input[i], input, i, factors);
                factors.remove(factors.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
//        int[] input = {2, 4, 5, 10,20};
//        Map<Integer,List<Set<Integer>>> map = new HashMap<>();
//        new BinaryTreesWithFactors().findFactors(map, 20,20, input, 0, new ArrayList<>());
//        System.out.println(map);
        System.out.println(new BinaryTreesWithFactors().palindromes(124));
    }

    private int palindromes(int i){
        String input = String.valueOf(i);
        StringBuilder sb = new StringBuilder(input);
        if(input.equals(sb.reverse().toString())){
            return i;
        }else{
            int temp = palindromes(i+1);
            return temp;
        }
    }
}
