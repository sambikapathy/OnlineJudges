package OnlineJudge.HackerRank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TeamFormation2 {

	public static void main(String[] args) throws Exception{
		java.io.BufferedReader r = new java.io.BufferedReader(
				new java.io.InputStreamReader(System.in));
		
		int n = Integer.parseInt(r.readLine().trim());
		for(int i =0;i<n;i++){
			String []input = r.readLine().trim().split(" ");
			int m = Integer.parseInt(input[0]);
			TreeSet<Range> treeSet = new TreeSet<Range>(new Comparator<Range>() {

				@Override
				public int compare(Range o1, Range o2) {
					return o1.size > o2.size?1:-1;
				}
			});
			int [] array = new int[m];
			for(int j=0;j<m;j++){
			array[j] = Integer.parseInt(input[j+1]);
			}
			//Arrays.sort(array);
			for(int j=0;j<m;j++){
				int value = array[j];
				Iterator<Range> iter = treeSet.iterator();
				boolean isDone = false;
				while(iter.hasNext()){
					Range set = iter.next();
//					if(set.contains(value)){
//						continue;
//					}else{
//						set.add(value);
//						isDone = true;
//						break;
//					}
					boolean plus = false , minus = false;
					if(!(value>=set.start && value <=set.end)
							&& ((value+1>=set.start && value+1 <=set.end && (plus=true)) 
									||
									(value-1>=set.start && value-1 <=set.end && (minus=true)))){
						if(plus){
							set.start = value;
						}else{
							set.end = value;
						}
						set.size++;
						isDone = true;
						iter.remove();
						treeSet.add(set);
						break;
					}
					
					
				}
				if(!isDone){
					Range set = new Range();
					set.start = set.end = (value);
					set.size++;
					treeSet.add(set);
				}
			}
			
			Iterator<Range> iter = treeSet.iterator();
			if (treeSet.size() == 0) {
				System.out.println(0);
			} else {
				int smallest = Integer.MAX_VALUE;
				while (iter.hasNext()) {
					Range set = iter.next();
					// for(Integer val : set){
					// System.out.print(val+" ");
					// }
					// System.out.println();
					if (set.size < smallest) {
						smallest = set.size;
					}
				}
				System.out.println(smallest);
			}
			
			
		}
	}
	
	
	static class Range{
		public int start;
		public int end;
		public int size;
	}
}
