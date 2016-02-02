package OnlineJudge.GoogleCodeJam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class StoreCredit {

	public static void main(String[] args) throws Exception{
		File file = new File("small.in");
		File outFile = new File("small.out");
		BufferedReader br = new BufferedReader(new FileReader(file));
		BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
		int testCases = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCases; t++) {
			int total = Integer.parseInt(br.readLine());
			br.readLine();
			HashMap<Integer, String> map = new HashMap<Integer, String>();
			
			String [] input = br.readLine().split(" ");
			int []array = new int[input.length];
			for(int i=0;i<input.length;i++){
				int value = Integer.parseInt(input[i]);
				array[i] = value;
				if(map.containsKey(value)){
					String entry = map.get(value);
					int freq = Integer.parseInt(entry.split(":")[0])+1;
					map.put(value, freq+":"+(i+1));
				}else{
					map.put(value, "1:"+(i+1));
				}
			}
			
			for(int i=0;i<input.length;i++){
				int result = total-array[i];
				if(map.containsKey(result)){
					String value = map.get(result);
					boolean isDone = true;
					int targetIndex = -1;
					if(result == array[i]){
						isDone = false;
						int freq = Integer.parseInt(value.split(":")[0]);
						if(freq > 1){
							isDone = true;
							targetIndex = Integer.parseInt(value.split(":")[1]);
						}
					}else{
						targetIndex = Integer.parseInt(value.split(":")[1]);
					}
					bw.write("Case #" + t + ": "+(i+1) +" "+ targetIndex+"\n");
					break;
				}
			}
			
			
		}
		br.close();
		bw.close();
	}
}
