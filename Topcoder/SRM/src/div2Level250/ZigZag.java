package div2Level250;

//DIV 1 250
public class ZigZag {
	
	public int longestZigZag(int[] seq){
		if(seq.length==1){
			return 1;
		}else if(seq.length==2){
			if(seq[0]!=seq[1]){
				return 2;
			}else{
				return 1;
			}
		}
		int []max = new int[seq.length];
		int []dir = new int[seq.length];
		max[0] = 1;
		if(seq[0]!=seq[1]){
			max[1] = 2;
		}
		dir[1] = Integer.compare(seq[0], seq[1]);
		dir[0] = -5;
		for(int i=2;i<seq.length;i++){
			for(int j=0;j<i;j++){
				int diff = Integer.compare(seq[j], seq[i]);
				if(diff!=0 &&(dir[j]==-5 || diff*-1==dir[j])){
					if(max[j]+1 > max[i]){
						max[i] = max[j]+1;
					}
					dir[i] = diff;
				}
			}
		} 
		
		int result = max[0];
		for(int i=1;i<max.length;i++){
			if(max[i] > result)
				result = max[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		int []seq = { 3,3,3,3,3};
		System.out.println(new ZigZag().longestZigZag(seq));
	}
}
