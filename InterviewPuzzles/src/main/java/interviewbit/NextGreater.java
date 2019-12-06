package interviewbit;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class NextGreater {
    /**
     * Example:
     * <p>
     * Input : A : [4, 5, 2, 10]
     * Output : [5, 10, 10, -1]
     * <p>
     * Example 2:
     * <p>
     * Input : A : [3, 2, 1]
     * Output : [-1, -1, -1]
     */
    public ArrayList<Integer> nextGreater(ArrayList<Integer> A) {

        if (A == null || A.size() == 0) {
            return new ArrayList<>();
        }
        int[] arr = new int[A.size()];
        arr[A.size() - 1] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(A.get(A.size() - 1));

        for (int i = A.size() - 2; i >= 0; i--) {
            int val = A.get(i);
            //result
            while (!stack.isEmpty() && stack.peek() < val) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                arr[i] = stack.peek();
            } else {
                arr[i] = -1;
            }

            //populate stack
            stack.push(val);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i:arr){
            result.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int []input = {3, 2, 1};
        ArrayList list = new ArrayList();
        for(int i:input){
            list.add(i);
        }
        ArrayList arrayList = new NextGreater().nextGreater(list);
        System.out.println(Objects.toString(arrayList));
    }
}
