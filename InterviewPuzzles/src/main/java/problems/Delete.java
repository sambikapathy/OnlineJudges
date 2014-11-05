package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Delete {

	private static void testList(List<Long> list) {
		long sT = System.currentTimeMillis();
		List<Long> result = new ArrayList<Long>();
		for(long i:list){
			if(!result.contains(i)){
				result.add(i);
			}
		}
		long eT = System.currentTimeMillis();
		System.out.println("List "+ (eT-sT));
	}

	private static void testSet(List<Long> list) {
		long sT = System.currentTimeMillis();
		Set<Long> result = new HashSet<Long>();
		for(long i:list){
			result.add(i);
		}
		List<Long> resutlList= new ArrayList<Long>(result);
		long eT = System.currentTimeMillis();
		System.out.println("Set "+(eT-sT));
	}
	
	private static List<Long> generateLong(){
		List<Long> list = new ArrayList<Long>();
		long start = 898098792l;
		for(int i= 0;i<16000;i++){
			list.add(start++);
		}
		return list;
	}

	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			List<Long> list = generateLong();
		testList(list);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		testSet(list);
		}
	}
}
