package OnlineJudge.HackerRank.Algorithms;

import java.util.Scanner;

public class Encryption {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String word = in.nextLine();		
		int f = (int) Math.floor(Math.sqrt(word.length()));
		int c = (int) Math.ceil(Math.sqrt(word.length()));
		int mi =0 , mj = 0;
		if(f==c){
			mi=mj=f;
		}else if(f*c >= word.length()){
			mi=f;
			mj=c;
		}else{
			mi=mj=c;
		}
		print2(word, mi, mj);
	}
	
//	private static void print(String word , int r, int c) {
//		char[][]matrix = new char[r][c];
//		for(int i=0;i<r;i++) {
//			for(int j=0;j<c;j++) {
//				if(i*c+j < word.length()){
////				System.out.print(word.charAt(i*c+j));
//					matrix[i][j]=word.charAt(i*c+j);
//				}else{
//					break;
//				}
//			}
//		}
//		int count = 0;
//		for(int i=0;i<matrix[0].length;i++){
//			for(int j=0;j<matrix.length;j++){
//				if(matrix[j][i] != Character.MIN_VALUE)
//				System.out.print(matrix[j][i]);
//                count++;
//			}
//            if(count < word.length()){
//			System.out.print(" ");
//        }
//		}
//	}
	//feedthedog
	//fto ehg ee dd
	private static void print2(String word , int r, int c) {
		int count = 0;
		for(int i=0;i<c;i++){
			for(int j=0;j<r;j++){
				if(j*c+i < word.length()){
				System.out.print(word.charAt(j*c+i));
                count++;
				}
			}			
            if(count < word.length()){
			System.out.print(" ");
        }
		}
	}
}

