package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *

 Given an array A of integers, find the index of values that satisfy A + B = C + D, where A,B,C & D are integers values in the array

 Note:

 1) Return the indices `A1 B1 C1 D1`, so that
 A[A1] + A[B1] = A[C1] + A[D1]
 A1 < B1, C1 < D1
 A1 < C1, B1 != D1, B1 != C1

 2) If there are more than one solutions,
 then return the tuple of values which are lexicographical smallest.

 Assume we have two solutions
 S1 : A1 B1 C1 D1 ( these are values of indices int the array )
 S2 : A2 B2 C2 D2

 S1 is lexicographically smaller than S2 iff
 A1 < A2 OR
 A1 = A2 AND B1 < B2 OR
 A1 = A2 AND B1 = B2 AND C1 < C2 OR
 A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2

 Example:

 Input: [3, 4, 7, 1, 2, 9, 8]
 Output: [0, 2, 3, 5] (O index)

 If no solution is possible, return an empty list.

 */
public class Equal {
    public List<Integer> equal(List<Integer> A) {
        List<Integer> result = null;
        Map<Integer,List<List<Integer>>> cache = new HashMap<>();

        for(int i=0;i<A.size();i++){
            for(int j=i+1;j<A.size();j++){
                int sum = A.get(i) + A.get(j);
                if(!cache.containsKey(sum)){
                    cache.put(sum,new ArrayList<>());
                }
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                cache.get(sum).add(temp);
            }
        }

        for (Map.Entry<Integer, List<List<Integer>>> entry : cache.entrySet()) {
            if (entry.getValue().size() > 1) {
                List<List<Integer>> list = entry.getValue();
                List<Integer> start = list.get(0);
                for (int i = 1; i < list.size(); i++) {
                    List<Integer> current = list.get(i);
                    if (start.get(0) == current.get(0)
                            || start.get(0) == current.get(1)
                            || start.get(1) == current.get(0)
                            || start.get(1) == current.get(1)) {
                        continue;
                    }
                    int []res = new int[4];
                    res[0]=start.get(0);
                    res[1]=start.get(1);
                    res[2]=current.get(0);
                    res[3]=current.get(1);
                    if(result == null || isLess(res, result) < 0){
                        List<Integer> temp = new ArrayList<>();
                        Arrays.stream(res).forEach(temp::add);
                        result = temp;
                    }
                }
            }
        }
        return result;
    }

    private int isLess(int[] res, List<Integer> result) {
        for(int i=0;i<res.length;i++){
            if(res[i] != result.get(i)){
                  return res[i] - result.get(i);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int []input = {3, 4, 7, 1, 2, 9, 8};
        List<Integer> inp = new ArrayList<>();

        Arrays.stream(input).forEach(inp::add);
        System.out.println(new Equal().equal(inp));
    }
}
