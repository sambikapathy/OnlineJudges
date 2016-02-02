package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class RomanInteger {

	public static void main(String[] args) {
		System.out.println(new RomanInteger().romanToInt("IV"));
	}
	public int romanToInt(String s) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        
        
        int value = map.get(s.charAt(s.length()-1)+"");
        int result = value;
        for(int i=s.length()-2;i>=0;i--){
            int c = map.get(s.charAt(i)+"");
            if(c < value){
            	result-=c;
            }else{
            	result+=c;
            }
            value = c;
        }

        return result;
    }
}
