package OnlineJudge.GoogleCodeJam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InfiniteHousePancakes {

	
	public static void main(String[] args) throws Exception{
		File file = new File("small.in");
		File outFile = new File("small.out");
		BufferedReader br = new BufferedReader(new FileReader(file));
		BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
		int testCases = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCases; t++) {
			int total = Integer.parseInt(br.readLine());
			List<Integer> list = new ArrayList<Integer>();
			String []input = br.readLine().split(" ");
			for(int i =0;i<input.length;i++){
				list.add(Integer.parseInt(input[i]));
			}
			
			int[] initial = getMaxIndex(list);
			int max = initial[1];
			int index =  initial[0];
			int min = 0;
			while(list.size() > 0){
				
			}
			
			
			bw.write("Case #" + t + ": "+min+"\n");
			
		}
		br.close();
		bw.close();
	}
	
	
	
	
	
	
	
	
	public static void main1(String[] args) throws Exception{
		File file = new File("small.in");
		File outFile = new File("small.out");
		BufferedReader br = new BufferedReader(new FileReader(file));
		BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
		int testCases = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCases; t++) {
			int total = Integer.parseInt(br.readLine());
			List<Integer> list = new ArrayList<Integer>();
			String []input = br.readLine().split(" ");
			for(int i =0;i<input.length;i++){
				list.add(Integer.parseInt(input[i]));
			}
			
			int min = 0;
			int othermax = getMaxIndex(list)[1];
			while(list.size() > 0){
				int [] result = getMaxIndex(list);
				if(result[1] > list.size()){
					list.remove(result[0]);
					list.add((int)Math.ceil(result[1]*1.0/2));
					list.add((int)Math.floor(result[1]*1.0/2));
				}else{
				reduceByOne(list);
				}
				min++;
			}
			
			if(min > othermax)
				min = othermax;
			bw.write("Case #" + t + ": "+min+"\n");
			
		}
		br.close();
		bw.close();
	}
	
	private static void reduceByOne(List<Integer> list){
		
		
		for(int i=0;i<list.size();i++){
			list.set(i,list.get(i)-1);
		}
		Iterator<Integer> iter = list.iterator();
		for(;iter.hasNext();){
			int value = iter.next();
			if(value==0){
				iter.remove();
			}
		}
	}
	
	private  static int[] getMaxIndex(List<Integer> list){
		int index = -1;
		int max = 0;
		Iterator<Integer> iter = list.iterator();
		for(int i=0;iter.hasNext();i++){
			int value = iter.next();
			if(value == 0){
				iter.remove();
				continue;
			}
			if(value > max){
				max = value;
				index = i;
			}
		}
		return new int[]{index , max};
	}
}
