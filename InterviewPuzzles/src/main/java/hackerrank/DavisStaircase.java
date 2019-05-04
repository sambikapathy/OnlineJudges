package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DavisStaircase {
    //1,2,3 at a time
    static int stepPerms(int n) {

        int[] mat = new int[n + 1];
        int[] inp = {1, 2, 3};
        mat[0] = 1;
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < inp.length; j++) {
                if (i - inp[j] >= 0) {
                    mat[i] += mat[i - inp[j]];
                }
            }
        }
        return mat[n];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[] input = {1, 3, 7};
        for (int sItr = 0; sItr < 3; sItr++) {
            System.out.println(stepPerms(input[sItr]));
        }
    }
}
