package Arrays;

import java.util.Scanner;

public class MaximumSquare {


    public static void main(String[] args) {
        System.out.println(getMaximumSquare());
    }

    private static int getMaximumSquare() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] input = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                input[i][j] = in.nextInt();
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (input[i][j] != 0) {
                    int c = 1;
                    if (isOne(input, i, j, c)) {
                        if (max < c) {
                            max = c;
                            c++;
                        }
                    }
                }
            }
        }

        return max;
    }

    private static boolean isOne(int[][] input, int r, int c, int size) {
        for (int i = r; i < input.length && i < r + size; i++) {
            for (int j = c; j < input[0].length && j < c + size; j++) {
                if (input[i][j] != 1) {
                    return false;
                }
            }
        }

//        for (int i = r + size; i < input.length; i++) {
//            if (input[i][j] != 1) {
//                return false;
//            }
//        }
        return true;
    }


}


/*
1 1 1 0 0
1 1 1 1 1
1 0 1 1 1
1 0 1 1 1
*/
