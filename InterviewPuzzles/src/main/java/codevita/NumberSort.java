package codevita;

import java.util.Scanner;

public class NumberSort {
    public static final String[] units = {"", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
            "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen"};

    public static final String[] tens = {
            "",        // 0
            "",        // 1
            "Twenty",    // 2
            "Thirty",    // 3
            "Forty",    // 4
            "Fifty",    // 5
            "Sixty",    // 6
            "Seventy",    // 7
            "Eighty",    // 8
            "Ninety"    // 9
    };


    public static String convert(final int n) {
        if (n < 0) {
            return "Minus " + convert(-n);
        }

        if (n < 20) {
            return units[n];
        }

        if (n < 100) {
            return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
        }

        if (n < 1000) {
            return units[n / 100] + " Hundred" + ((n % 100 != 0) ? " " : "") + convert(n % 100);
        }

        if (n < 100000) {
            return convert(n / 1000) + " Thousand" + ((n % 10000 != 0) ? " " : "") + convert(n % 1000);
        }

        if (n < 10000000) {
            return convert(n / 100000) + " Lakh" + ((n % 100000 != 0) ? " " : "") + convert(n % 100000);
        }

        return convert(n / 10000000) + " Crore" + ((n % 10000000 != 0) ? " " : "") + convert(n % 10000000);
    }

    public static int converge(int a, int b) {
        boolean isDone = false;
        while (!isDone) {
            if (a > 99999 || b > 99999) {
                return -1;
            }
            if (a == b) {
                return a;
            }
            String as = convert(a);
            String bs = convert(b);
            int i = as.compareTo(bs);
            if (i < 0) {
                a += a;
                b += b;
            } else {
                int temp = a;
                a += b;
                b += temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a, b;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        if (0 < converge(a, b)) {
            System.out.println(converge(a, b));
        } else {
            System.out.println("Out of bounds");
        }

    }
}
