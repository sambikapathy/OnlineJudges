package OnlineJudge.HackerRank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TeamFormation {

	/*
4  
7 4 5 2 3 -4 -3 -5  
1 -4  
4 3 2 3 1  
7 1 -2 -3 -4 2 0 -1  

	 */
	//Fails with TLE
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i =0;i<n;i++){
			int m = in.nextInt();
			TreeSet<Set<Integer>> treeSet = new TreeSet<Set<Integer>>(new Comparator<Set<Integer>>() {
				@Override
				public int compare(Set<Integer> o1, Set<Integer> o2) {
					int a = o1.size();
					int b = o2.size();
					return a > b ? 1 : a < b ? -1 : -1;
					
				}
			});
			int [] array = new int[m];
			for(int j=0;j<m;j++){
			array[j] = in.nextInt();
			}
			Arrays.sort(array);
			for(int j=0;j<m;j++){
				int value = array[j];
				Iterator<Set<Integer>> iter = treeSet.iterator();
				boolean isDone = false;
				while(iter.hasNext()){
					Set<Integer> set = iter.next();
//					if(set.contains(value)){
//						continue;
//					}else{
//						set.add(value);
//						isDone = true;
//						break;
//					}
					if(!set.contains(value) && (set.contains(value-1)||set.contains(value+1))){
						set.add(value);
						isDone = true;
						
						iter.remove();
						treeSet.add(set);
						break;
					}
					
					
				}
				if(!isDone){
					Set<Integer> set = new HashSet<Integer>();
					set.add(value);
					treeSet.add(set);
				}
			}
			
			Iterator<Set<Integer>> iter = treeSet.iterator();
			if (treeSet.size() == 0) {
				System.out.println(0);
			} else {
				int smallest = Integer.MAX_VALUE;
				while (iter.hasNext()) {
					Set<Integer> set = iter.next();
					// for(Integer val : set){
					// System.out.print(val+" ");
					// }
					// System.out.println();
					if (set.size() < smallest) {
						smallest = set.size();
					}
				}
				System.out.println(smallest);
			}
			
			
		}
	}
}
