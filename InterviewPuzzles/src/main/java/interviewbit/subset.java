package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *

 Given a set of distinct integers, S, return all possible subsets.

 Note:

 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 Also, the subsets should be sorted in ascending ( lexicographic ) order.
 The list is not necessarily sorted.

 Example :

 If S = [1,2,3], a solution is:

 [
 [],
 [1],
 [1, 2],
 [1, 2, 3],
 [1, 3],
 [2],
 [2, 3],
 [3],
 ]


 */
public class subset {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        dfs(A, new ArrayList<>(),result,0);
        return result;
    }

    private void dfs(ArrayList<Integer> A, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result, int index){
        if(index == A.size()){
            return;
        }

        for(int i=index;i<A.size();i++){
            temp.add(A.get(i));
            result.add(new ArrayList<>(temp));
            dfs(A,temp,result,i+1);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        ArrayList<ArrayList<Integer>> subsets = new subset().subsets(input);
        System.out.println(subsets);
    }
}
