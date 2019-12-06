package interviewbit;

import java.util.HashMap;
import java.util.Map;

public class Fraction {

    public String fractionToDecimal(int a1, int b1) {
        if (a1 == 0 || b1 == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        long a = a1;
        long b = b1;
        int sign = 1;
        if (a < 0) {
            a *= -1;
            sign *= -1;
        }
        if (b < 0) {
            b *= -1;
            sign *= -1;
        }
        if (a < b) {
            result.append("0");
        }
        boolean frac = false;
        Map<Long, Long> seen = new HashMap<>();
        while (a > 0) {
            if (frac) {
                if (seen.containsKey(a)) {
                    result.insert(seen.get(a).intValue() + 1, "(");
                    result.append(")");
                    break;
                }
            }
            if (a >= b) {
                seen.put(a, (long) (result.length() - 1));
                long t = a / b;
                a = a % b;
                result.append(t);
            } else {
                if (!frac) {
                    result.append(".");
                    frac = true;
                }
                while ((a = a * 10) < b) {
                    result.append("0");
                }
            }

        }
        if (sign == -1) {
            return "-" + result.toString();
        }
        return result.toString();
    }

    public static void main(String[] args) {

//        System.out.println(new Fraction().fractionToDecimal(-1, 2));
        System.out.println("abc".hashCode());
        System.out.println("bca".hashCode());
    }

}
