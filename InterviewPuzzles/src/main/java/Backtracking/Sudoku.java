package Backtracking;

import java.util.Stack;

public class Sudoku {

    public void solveSudoku(int[][] input) {

        Stack<Pair> stack = new Stack<>();
        int r = 0, c = 0;
        int count = 0;
        int value = 1;
        while (count < 81) {
            if (input[r][c] == 0) {
                for (int i = value; i <= 9; i++) {
                    if (isValid(input, i, r, c)) {
                        input[r][c] = i;
                        stack.push(new Pair(r, c, i));
                        break;
                    }
                }
                if (input[r][c] == 0) {
                    if (stack.isEmpty()) {
                        throw new RuntimeException();
                    }
                    Pair pop = stack.pop();
                    r = pop.first;
                    c = pop.second;
                    value = pop.value + 1;
                    input[r][c]=0;
                    count--;
                    continue;
                }
            }

            count++;
            c++;
            value=1;

            if (c > 8) {
                c = 0;
                r = r + 1;
            }
        }

    }

    class Pair {
        public int first;
        public int second;
        public int value;

        public Pair(int f, int s, int v) {
            first = f;
            second = s;
            value = v;
        }
    }

    private boolean isValid(int[][] input, int value, int r, int c) {
        //col
        for (int i = 0; i < 9; i++) {
            if (input[r][i] == value) {
                return false;
            }
        }
        //row
        for (int i = 0; i < 9; i++) {
            if (input[i][c] == value) {
                return false;
            }
        }

        int rt = r / 3 * 3;
        int ct = c / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (input[rt + i][ct + j] == value) {
                    return false;
                }
            }
        }
        return true;
    }


    public void printMatrix(int[][] input) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] input = new int[9][9];
        input[3][4] = 4;
        Sudoku sudoku = new Sudoku();
        sudoku.solveSudoku(input);
        sudoku.printMatrix(input);
    }
}
