package div2Level1000;

/*
 * 0)	
    	
{"NYN",
 "YNN",
 "NNN"}
Returns: 4
The example from the problem statement.
1)	
    	
{"NYYY",
 "YNNN",
 "YNNN",
 "YNNN"}
Returns: 0
It's impossible to travel all these roads while obeying the other rules.
2)	
    	
{"NYY",
 "YNY",
 "YYN"}
Returns: 0
This is also impossible.
3)	
    	
{"NNNNNY",
 "NNNNYN",
 "NNNNYN",
 "NNNNNN",
 "NYYNNN",
 "YNNNNN"}
Returns: 24

 */
public class HamiltonPath {

	public int countPaths(String[] roads){
		return -1;
	}
	
	public static void printPerm(String input , int pos){
		if(pos>=input.length()){
			System.out.println(input);
		}
		
	}
	
	
	public static void main(String[] args) {
		String []input = {};
		//System.out.println(new HamiltonPath().countPaths(input));
		printPerm("abc", 0);
	}
}
