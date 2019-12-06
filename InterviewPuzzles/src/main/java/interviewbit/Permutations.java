package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a collection of numbers, return all possible permutations.
 * <p>
 * Example:
 * <p>
 * [1,2,3] will have the following permutations:
 * <p>
 * [1,2,3]
 * [1,3,2]
 * [2,1,3]
 * [2,3,1]
 * [3,1,2]
 * [3,2,1]
 * <p>
 * NOTE
 * <p>
 * No two entries in the permutation sequence should be the same.
 * For the purpose of this problem, assume that all the numbers in the collection are unique.s
 */
public class Permutations {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        perm(result, A, 0, new ArrayList<>(),A.size());
        return result;
    }

    private void perm(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> a, int start, ArrayList<Integer> temp,int max) {
        if (temp.size()==max) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < a.size(); i++) {
            temp.add(a.remove(i));
            perm(result, a, 0, temp,max);
            a.add(i, temp.get(temp.size() - 1));
            temp.remove(temp.size() - 1);
        }
    }

    private static void ps(String prefix, String input) {
        if (input.length() == 0) {
            System.out.println(prefix);
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            ps(prefix + input.charAt(i), input.substring(0, i) + input.substring(i + 1));
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        ArrayList<ArrayList<Integer>> permute = new Permutations().permute(input);
        System.out.println(permute);
//        ps("", "123");
    }

}
