import java.math.BigDecimal;
import java.math.RoundingMode;


public class P100ArrangedProbability {

	public static void main(String[] args) {
		for(long b=10000000000l;b<1000000000000l;b++){
			for(long r = 10000000000l;r<1000000000000l;r++){
				double prob = (b*1.0/(b+r))*((b-1)*1.0/(b+r-1));
				BigDecimal value = new BigDecimal(prob);
				value.setScale(2, RoundingMode.FLOOR);
				if(value.floatValue() == 0.5){
					System.out.println(b +" "+r);
				}
			}
		}
	}
}
