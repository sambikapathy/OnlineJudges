import java.util.Arrays;

//SRM 500 Div 2 250
public class SRMCards {
	public int maxTurns(int[] cards) {
		Arrays.sort(cards);
		int count = 0;
		int i = 0;
		while (i < cards.length) {
			count++;
			if (i + 1 < cards.length) {
				if (cards[i + 1] - cards[i] == 1) {
					i = i + 2;
				}
			}
			i++;

		}
		return count;
	}
}