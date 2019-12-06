package interviewbit;

import java.util.HashSet;
import java.util.Set;

public class ColorfulNumber {
    public int colorful(int A) {
        char[] input = ("" + A).toCharArray();
        Set<Integer> cache = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            int temp = 1;
            for (int j = i; j < input.length; j++) {
                temp *= (input[j]-'0');
                if(cache.contains(temp)){
                    return 0;
                }
                cache.add(temp);
            }
        }
        return 1;
    }

    public static void main(String[] args) {

        System.out.println(new ColorfulNumber().colorful(23));
    }
}
