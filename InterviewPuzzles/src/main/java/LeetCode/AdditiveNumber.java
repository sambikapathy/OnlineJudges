package LeetCode;

import java.math.BigInteger;

public class AdditiveNumber {

	  public boolean isAdditiveNumber(String num) {
	        if(num == null || num.length() < 3){
	            return false;
	        }
	        
	        StringBuilder a = new StringBuilder();
	       for(int i =0;i<num.length();i++){
	           a.append(num.charAt(i));
	           StringBuilder b = new StringBuilder();
	           BigInteger ai = new BigInteger(a.toString());
	           for(int j=i+1;j<num.length();j++){
	        	   
	               b.append(num.charAt(j));
	               if(b.length()>1 && b.charAt(0)=='0'){
	            	   break;
	               }
	               if(isAdditiveNumber(num.substring(j+1) , ai , new BigInteger(b.toString()))){
	                   return true;
	               }
	           }
	       }
	        return false;
	        
	    }
	    
	    public boolean isAdditiveNumber(String num, BigInteger f , BigInteger s) {
	      
	        if(num.length() == 0){
	            return false;
	        }
	        
	        if(num.charAt(0) == '0'){
	            return false;
	        }
	        
	        BigInteger sum = f.add(s);
	        StringBuilder sb = new StringBuilder();
	        //198019823962
	        for(int i=0;i<num.length();i++){
	            
	            if(i > 0 && num.charAt(0)=='0'){
	                return false;
	            }
	            sb.append(num.charAt(i));
	            
	             System.out.println(f+" "+s+" "+sb);
	             
	            BigInteger temp = new BigInteger(sb.toString());
	            if(temp.compareTo(sum) == 1){
	                return false;
	            }else if(temp.compareTo(sum)==0){
	                
	                if(i+1==num.length()){
	                    return true;
	                }
	                return isAdditiveNumber(num.substring(i+1) , s , temp);
	            }
	        }
	        return false;
	    }
	    
	    public static void main(String[] args) {
	    	String input = "198019823962";
			System.out.println(new AdditiveNumber().isAdditiveNumber(input));
		}
}
