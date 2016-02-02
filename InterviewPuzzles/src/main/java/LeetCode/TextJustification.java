package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	public List<String> fullJustify(String[] words, int maxWidth) {
        int index = 0;
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<String>();
        while(index < words.length){
            String word = words[index];
            
            int l = sb.length() + word.length();
            
            if(l > maxWidth){
                
                sb=paddString(sb, maxWidth);
                result.add(sb.toString());
                 sb = new StringBuilder();
                
            }else if(l+1 <= maxWidth){
                
                sb.append(word + " ");
                index++;
            }else if(l == maxWidth){
                
                sb.append(word);
                index++;    
            }
            
           
        }
        if(sb.length()>0){
        	result.add(sb.toString());
        }
        return result;
    }
    
    public StringBuilder paddString(StringBuilder sb , int l){
        //What if there is only one word 
        int words = sb.toString().split(" ").length;
        int padd = l-sb.length()+words;
        int length = 0;
        boolean uneven = true;
        StringBuilder result = new StringBuilder();
        length = padd / (words-1);
        if(padd%(words-1) == 0){
            uneven = false;
        }
        //This    is    an
        //
		String[] array = sb.toString().split(" ");
		for (int i = 0; i < array.length; i++) {
			if (array[i].length() > 0) {
				result.append(array[i]);
				if(i != array.length -1)
				for (int j = 0; j < length; j++) {
					result.append(" ");
				}
				if (uneven) {
					for (int j = 0; j < padd % (words - 1); j++)
						result.append(" ");
					uneven = false;
				}
			}
		}
		if (result.length() != l) {
			for (int i = result.length(); i < l; i++) {
				result.append(" ");
			}
		}
        return result;
    }
    
    public static void main(String[] args) {
		String [] input = {"This", "is", "an", "example", "of", "text", "justification."};
		int l = 16;
		List<String> output = new TextJustification().fullJustify(input , l);
		for(String str : output){
			System.out.println(str);
		}
	}
}
