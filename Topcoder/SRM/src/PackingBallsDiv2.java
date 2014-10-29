
public class PackingBallsDiv2 {

	int minPacks(int R, int G, int B){
		int total = 0;
		total+= R/3;
		R = R%3;
		total+=G/3;
		G = G%3;
		total+=B/3;
		B = B%3;
		while(R>0 || G >0 || B >0){
			if(R+G+B==2){
				if(R%2==0 || G%2==0 || B%2==0){
					total++;
					break;
				}
			}else{
			total++;
			R--;G--;B--;
			}
		}
		return total;
	}
	
	public static void main(String[] args) {
		System.out.println(new PackingBallsDiv2().minPacks(1,3,3));
	}
}
