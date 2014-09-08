import java.util.Arrays;

//SRM 502 Div 2 250
public class TheProgrammingContestDivTwo
{
	public int[] find(int T, int[] requiredTime)
	{
		Arrays.sort(requiredTime);
		int total = 0;
		int task=0;
		int penalty = 0;
		for(int i=0;i<requiredTime.length;i++){
			if((total + requiredTime[i]) > T){
				break;
			}
			task++;
			total+= requiredTime[i];
			penalty+=total;
		}
		
		return new int[]{task , penalty};
	}
}