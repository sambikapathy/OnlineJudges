package OnlineJudge.HackerRank;

import java.util.Scanner;

public class InsertionSort1 {

	public static void insertIntoSorted(int[] ar) {
       boolean first = true;
       boolean isDone = false;
    	   int temp = ar[ar.length-1];
    	   for(int i=ar.length-2;i>=0;i--){
    		   if(temp > ar[i]){
    			   ar[i+1] = temp;
    			   isDone = true;
    			   if(!first)
    			   printArray(ar);
    			   break;
    		   }else{
    			   first = false;
    			   ar[i+1] = ar[i];
    			   //temp = ar[i];
    			   printArray(ar);
    		   }
    	   }
    	   if(!isDone){
    		   ar[0] = temp;
    		   printArray(ar);
    	   }
    }
    
    
/* Tail starts here */
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
         for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
         }
         insertIntoSorted(ar);
    }
    
    
    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }
}
