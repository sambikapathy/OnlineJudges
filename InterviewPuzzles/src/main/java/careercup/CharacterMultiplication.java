package careercup;

import java.util.ArrayList;
import java.util.List;

public class CharacterMultiplication {

	/*
	 * symbolicMul({ { 'a', 'b'}, {'c', 'd'} }); symbolicMul({ { 'a', 'b' },{
	 * 'c', 'd' }, {'e', 'f'} });
	 * 
	 * {{a,c},{a,d},{b,c},{b,d}}
	 * {{a,c,e},{a,c,f},{a,d,e},{a,d,f},{b,c,e},{b,c,f},{b,d,e},{b,d,f}}
	 */

	public static void multiply(char[][] input, String prefix, int row, List<String> list) {
		if (row >= input.length) {
			list.add(prefix);
			return;
		}
		for (int i = 0; i < input[row].length; i++) {
			multiply(input, prefix + input[row][i], row + 1, list);
		}
	}

	public static void main(String[] args) {
		char[][] input = { { 'a', 'b' }, { 'c', 'd' } };
		char[][] input2 = { { 'a', 'b' }, { 'c', 'd', 'e' }, { 'g', 'f' } };

		List<String> result = new ArrayList<>();
		multiply(input2, "", 0, result);
		System.out.println(result);
	}
}
