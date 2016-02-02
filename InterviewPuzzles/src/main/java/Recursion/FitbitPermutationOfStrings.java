package Recursion;

import java.util.ArrayList;
import java.util.List;

public class FitbitPermutationOfStrings {
//"{Valery,Jason,Peter} was in {good,bad} mood and he went to the {beach, party, library}
	public static void main(String[] args) {
		String [][] input = {
				{"Valery","Jason"},
				{"good","bad"},
				{"beach", "party"}
		};
		
		print(input , 0 , 0 , new ArrayList<String>());
	}
	
	private static void print(String [][]input , int i , int j , List<String> temp){
		if(i== input.length-1 ){
			if(j < input[i].length){
				for(String str : temp){
					System.out.print(str +" ");
				}
				System.out.println(input[i][j]);
				print(input , i , j+1 , temp);
				return;
			}
		}
		
		for(int x=j;x<input[i].length;x++){
			temp.add(input[i][x]);
			print(input , i+1 , 0 , temp);
			temp.remove(input[i][x]);
		}
		
		
	}
}
