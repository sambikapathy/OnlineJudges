package LeetCode.contest.wc80;

import java.util.ArrayList;
import java.util.List;

/**
 * We had some 2-dimensional coordinates, like "(1, 3)" or "(2, 0.5)".  Then, we removed all commas, decimal points, and spaces, and ended up with the string S.  Return a list of strings representing all possibilities for what our original coordinates could have been.
 * <p>
 * Our original representation never had extraneous zeroes, so we never started with numbers like "00", "0.0", "0.00", "1.0", "001", "00.01", or any other number that can be represented with less digits.  Also, a decimal point within a number never occurs without at least one digit occuring before it, so we never started with numbers like ".1".
 * <p>
 * The final answer list can be returned in any order.  Also note that all coordinates in the final answer have exactly one space between them (occurring after the comma.)
 * <p>
 * Example 1:
 * Input: "(123)"
 * Output: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
 * <p>
 * Example 2:
 * Input: "(00011)"
 * Output:  ["(0.001, 1)", "(0, 0.011)"]
 * Explanation:
 * 0.0, 00, 0001 or 00.01 are not allowed.
 * <p>
 * Example 3:
 * Input: "(0123)"
 * Output: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]
 * <p>
 * Example 4:
 * Input: "(100)"
 * Output: [(10, 0)]
 * Explanation:
 * 1.0 is not allowed.
 */
public class AmbiguousCoordinates {
    public List<String> ambiguousCoordinates(String S) {
        List<String> result = new ArrayList<>();
        for(int i=1;i<S.length()-2;i++){
            String left = S.substring(1,i+1);
            String right = S.substring(i+1,S.length()-1);

            List<String> l = addDots(left);
            List<String> r = addDots(right);

            for(String le : l){
                for(String re : r){
                    result.add(String.format("(%s, %s)",le,re));
                }
            }
        }
        return result;
    }

    private static List<String> addDots(String input) {
        List<String> result = new ArrayList<>();
        //123
        //0123
        //1230
        if(input.length()==1){
            result.add(input);
            return result;
        }
        if(!input.startsWith("0")) {
            result.add(input);
        }
        for(int i=0;i<input.length()-1;i++){
            String l = input.substring(0,i+1);
            String r = input.substring(i+1);
            if(r.endsWith("0") || (l.startsWith("0") && l.length()>1)){
                continue;
            }else{
                result.add(l+"."+r);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        long stime = System.currentTimeMillis();
        //1111111100011111110001111111
        System.out.println(new AmbiguousCoordinates().ambiguousCoordinates("(1111111100011111110001111111)"));
//        System.out.println(new AmbiguousCoordinates().ambiguousCoordinates("1111111100011111110001111111"));
        System.out.println((System.currentTimeMillis()-stime));

//        System.out.println(addDots("0011"));
    }
}
