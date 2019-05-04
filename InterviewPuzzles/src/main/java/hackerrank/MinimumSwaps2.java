package hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class MinimumSwaps2 {
    /**
     * i   arr                     swap (indices)
     * 0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
     * 1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
     * 2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
     * 3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
     * 4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
     * 5   [1, 2, 3, 4, 5, 6, 7]
     * <p>
     * [7, 1, 3, 2, 4, 5, 6]
     */

    /**
     * 7, 1, 3, 2, 4, 5, 6
     * 7, 1, 3, 2, 4, 6, 5
     * 7, 1, 3, 2, 5, 6, 4
     * 1, 7, 3, 2, 5, 6, 4
     * 1, 2, 3, 7, 5, 6, 4
     * 1, 2, 3, 4, 5, 6, 7
     * <p>
     * <p>
     * 7, 1, 3, 4, 5, 6, 2
     * 7 -> 6
     * 2 -> 1
     * <p>
     * 6 -> 2
     * 0 -> 7
     */
    static int minimumSwaps(int[] arr) {

        int[] temp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(temp);
        Map<Integer, Integer> targetPosition = new HashMap<>();
        Map<Integer, Integer> currentPosition = new HashMap<>();

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (temp[i] != arr[i]) {
                targetPosition.put(temp[i], i);
            }
            currentPosition.put(i, arr[i]);
        }
        while (!targetPosition.isEmpty()) {


            boolean done = false;
            for (Map.Entry<Integer, Integer> entry : targetPosition.entrySet()) {
                int targetPos = entry.getValue(); // 6
                int elementInTargetPos = currentPosition.get(targetPos); // 1
                int currentElement = targetPosition.get(elementInTargetPos); // 0
                int matchingEle = currentPosition.get(currentElement); //7


                if (entry.getKey() == matchingEle) {
                    targetPosition.remove(entry.getKey());
                    targetPosition.remove(elementInTargetPos);
                    done = true;
                    count++;
                    break;
                }

            }
            if (!done) {
                Map.Entry<Integer, Integer> entry = targetPosition.entrySet().iterator().next();
                int targetPos = entry.getValue(); // 6
                int key = entry.getKey();
                Map.Entry<Integer, Integer> entry2 = currentPosition.entrySet().stream().filter(entry1 -> entry1.getValue() == key).findFirst().get();

                currentPosition.put(entry2.getKey(), currentPosition.get(targetPos));
                currentPosition.remove(entry.getValue());
                targetPosition.remove(entry.getKey());
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] input = {2, 3, 4, 1};
        System.out.println(minimumSwaps(input));
    }
}
