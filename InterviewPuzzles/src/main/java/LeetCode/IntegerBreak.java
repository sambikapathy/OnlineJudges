package LeetCode;

/**
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * <p>
 * Example 2:
 * <p>
 * Input: 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 * <p>
 * Note: You may assume that n is not less than 2 and not larger than 58.
 */
public class IntegerBreak {

    public int integerBreak(int n) {
        if(n<=3){
            return n-1;
        }
        int product = 1;
        while (n > 4) {
            n -= 3;
            product *= 3;
        }
        product*=n;
        return product;
    }

    public static void main(String[] args) {
        System.out.println(new IntegerBreak().integerBreak(13));
    }
}
