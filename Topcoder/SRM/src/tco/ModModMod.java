package tco;



public class ModModMod
{
	public static void main(String[] args) {
		System.out.println(new ModModMod().findSum(new int[]{995,149,28,265,275,107,555,241,702,462,519,212,362,478,783,381,602,546,183,886,59,317,977,612,328,91,771,131}, 992363));
	}
	public long findSum(int[] m, int R)
	{
		long result = 0;
		
		for(int i=1;i<=R;i++){
			result+=sum(i, m);
		}
		return result;
	}
	
	private long sum(int n , int []m){
		long result = (long)n;
		for(int i=0;i<m.length;i++){
			result=result%((long)m[i]);
		}
		return result;
	}
	
}
