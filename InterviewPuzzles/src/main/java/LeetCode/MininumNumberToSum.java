package LeetCode;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MininumNumberToSum {

	private int count = 2000000;
	private Set<Integer> result = new TreeSet<Integer>();
	private BitSet bit = new BitSet(count);
	private void calc(){
		for(int i =1;i<count;i++){
			if(bit.get(i)){
				continue;
			}else{
				
				List<Integer> temp = new ArrayList<Integer>();
				for(int j=1;j<count;j++){
					if(bit.get(j)){
						temp.add(j+i);
					}
				}
				for(int j : temp){
					bit.set(j);
				}
				bit.set(i);
				result.add(i);
			}
		}
		for(int j : result){
			System.out.println(j);
		}
		System.out.println(result.size());
	}
	
	public static void main(String[] args) {
		new MininumNumberToSum().calc();
	}
}
