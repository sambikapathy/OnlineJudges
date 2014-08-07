import java.util.Scanner;


public class TOANDFRO {

	public static void main (String[] args) throws java.lang.Exception
	  {
		Scanner in = new Scanner(System.in);
		int total = in.nextInt();
		while(total != 0){
			System.out.println(getDecodedString(total, in.next()));
			total = in.nextInt();
		}
		
//		System.out.println(getDecodedString(5,"toioynnkpheleaigshareconhtomesnlewx"));
//		System.out.println(getDecodedString(3,"ttyohhieneesiaabss"));
	  }
	
	private static String getDecodedString(int col , String input){
		int row = input.length()/col;
		char [][]inter = new char[row][col];
		int [] fwd = new int[col];
		int [] rev = new int[col];
		int revIndex = col;
		for(int i=0;i<col;i++){
			fwd[i]=i;
			rev[i] = --revIndex;
		}
		int index = 0;
		boolean straight = true;
		for(int i=0;i<row;i++){
			int [] array = fwd;
			if(!straight){
				array = rev;
			}
			for(int j : array){
				char c = (input.charAt(index++));
				inter[i][j]=c;
				
			}
			if(straight)
				straight = false;
			else
				straight = true;
			//System.out.println();
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<col;i++){
			for(int j=0;j<row;j++){
				sb.append(inter[j][i]);
			}
			//System.out.println();
		}
		return sb.toString();
	}

}
