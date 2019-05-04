package LeetCode;

//650. 2 Keys Keyboard
public class TwoKeysKeyboard {
    /**
     * Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:
     *
     *     Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
     *     Paste: You can paste the characters which are copied last time.
     *
     * Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.
     *
     * Example 1:
     *
     * Input: 3
     * Output: 3
     * Explanation:
     * Intitally, we have one character 'A'.
     * In step 1, we use Copy All operation.
     * In step 2, we use Paste operation to get 'AA'.
     * In step 3, we use Paste operation to get 'AAA'.
     *
     * Note:
     *
     *     The n will be in the range [1, 1000].
     */
    public int minSteps(int n) {

        //prime -> return the same number
        int[] result = new int[n + 1];
        result[1] = 0;
        for (int i = 2; i <= n; i++) {
            result[i] = i;
        }

        for (int i = 2; i <= n; i++) {
            int temp = result[i];
            for(int j=1;j*i<=n;j++){
                result[i*j] = Math.min(result[i*j],result[i]+j);
            }
        }
        return result[n];
    }

    public static void main(String[] args) {
        TwoKeysKeyboard inst = new TwoKeysKeyboard();
        System.out.println(inst.minSteps(16));
    }
}
