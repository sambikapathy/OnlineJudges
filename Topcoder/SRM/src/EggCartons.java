public class EggCartons
{
	
	public int minCartons(int n)
	{
		int max = minCartons(n, 0);
		if(max == Integer.MAX_VALUE){
			max = -1;
		}
		return max;
	}
	
	public int minCartons(int n , int count)
	{
		if(n==0){
			return count;
		}
		int s = Integer.MAX_VALUE , e = Integer.MAX_VALUE;
		if(n-6>=0)s = minCartons(n-6 , count+1);
		if(n-8>=0)e = minCartons(n-8,count+1);
		
		return s>e?e:s;
	}
	
	public static void main(String[] args) {
		int input = 15;
		System.out.println(new EggCartons().minCartons(input));
	}
}