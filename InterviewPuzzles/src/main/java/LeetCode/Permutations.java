package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Permutations {
    public List<List<Integer>> permute_iter(int[] nums) {
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<>());
        queue.peek().add(nums[0]);

        for (int i = 1; i < nums.length; i++) {

            Queue<List<Integer>> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                List<Integer> list = queue.poll();
                for(int j=0;j<list.size()+1;j++){
                    List<Integer> l = new ArrayList<>(list);
                    l.add(j,nums[i]);
                    ((LinkedList<List<Integer>>) temp).add(l);
                }
            }
            queue = temp;
        }
        return new ArrayList<>(queue);
    }

    private List<List<Integer>> permute(int[] input) {
        return null;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        List<List<Integer>> result = new Permutations().permute(input);
//        result.stream().forEach(list -> System.out.println(list));
    }



}
