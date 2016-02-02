package div2Level250;



public class BritishCoins
{
	public int[] coins(int pence)
	{
		int [] result = new int[3];
		result[0] = pence/(12*20);
		pence -= result[0]*(12*20);
		
		result[1] = pence/12;
		pence-= result[1]*12;
		
		result[0] = pence;
		
		return result;
	}
	
	public static void main(String[] args) {
		int input = 533;
		int []result = (new BritishCoins().coins(input));
		System.out.println(result);
	}
	
}