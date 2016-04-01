package OnlineJudge.HackerRank;

import java.util.Scanner;

public class Contacts {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		Node head = new Node();
		for(int i=0;i<t;i++){
			String[] input = in.nextLine().split(" ");
			String word = input[1];
			if(input[0].equals("add")){
				Node temp = head;
				for(int j=0;j<word.length();j++){
					int index = word.charAt(j) -'a';
					if(temp.next[index] == null){
						temp.next[index] = new Node();
					}
					temp.next[index].total++;
					if(j==word.length()-1){
						temp.next[index].isWord=true;
					}
					temp = temp.next[index];
				}
			}else{
				Node temp = head;
				int total = 0;
				for(int j=0;j<word.length();j++){
					char c = word.charAt(j);
					int index = c-'a';
					if(temp.next[index] == null){
//						System.out.println("0");
						total = 0;
						break;
					}else{
						temp = temp.next[index];
						total = temp.total;
					}
				}
				System.out.println(total);
				
			}
			
		}
				
	}
	/*
	 4
add hack
add hackerrank
find hac
find hak
	 */
	
}

class Node{
	public Node [] next = new Node[26];
	public int total;
	public boolean isWord;
}

