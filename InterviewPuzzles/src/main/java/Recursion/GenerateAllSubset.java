package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubset {

	private void allSubset(List<Integer> input, List<Integer> result) {
		if (input.isEmpty()) {
			System.out.println(result);
			return;
		}
		for (Integer i : input) {
			List<Integer> newR = new ArrayList<>(result);
			List<Integer> newI = new ArrayList<>(input);
			newI.remove(i);

			allSubset(newI, newR);
			newR.add(i);
			allSubset(newI, newR);

		}
	}

	public static void main(String[] args) {
		System.out.println("hello");
	}
}
