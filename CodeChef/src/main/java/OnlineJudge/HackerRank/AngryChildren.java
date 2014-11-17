package OnlineJudge.HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AngryChildren {

	static BufferedReader in = new BufferedReader(new InputStreamReader(
	         System.in));
	   static StringBuilder out = new StringBuilder();

	   public static void main(String[] args) throws NumberFormatException, IOException {
	      int numPackets = Integer.parseInt(in.readLine());
	      int numKids = Integer.parseInt(in.readLine());
	      int[] packets = new int[numPackets];
	      
	      for(int i = 0; i < numPackets; i ++)
	      {
	         packets[i] = Integer.parseInt(in.readLine());
	      }
	      
	      int unfairness = Integer.MAX_VALUE;
	      Arrays.sort(packets);
	      for(int i=0;i<(numPackets-numKids);i++){
	    	  int diff = packets[i+numKids-1] - packets[i];
	    	  if(diff < unfairness){
	    		  unfairness = diff;
	    	  }
	      }
	      System.out.println(unfairness);
	   }
}
