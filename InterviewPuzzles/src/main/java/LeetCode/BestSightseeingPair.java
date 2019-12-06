package LeetCode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class BestSightseeingPair {
    public int maxScoreSightseeingPair(int[] A) {
        int max = -1;
        int maxi = -1;
        int maxj=-1;
        for (int i = 0; i < A.length - 1; i++) {
            if (max != -1) {
                if (A[i] < A[maxi] && ((A[maxi] - A[i]) > (i - maxi))) {
                    continue;
                }
            }
            for (int j = i + 1; j < A.length; j++) {
                int temp = A[i] + A[j] + i - j;
                if (max < temp) {
                    max = temp;
                    maxi = i;
                    maxj = j;
                    System.out.println(A[i] + " " + A[j] + " " + i + " " + j);
                }
            }
        }
        System.out.println("->"+max +" "+maxi);
        return max;
    }

    public static void main(String[] args) throws IOException {
        String[] strings = Files.readAllLines(new File("/Users/sambikapathi/PersonalViews/OnlineJudges/OnlineJudges/InterviewPuzzles/src/main/java/LeetCode/input.txt").toPath()).get(0).split(",");

        int[] input = new int[strings.length];
        AtomicInteger index = new AtomicInteger(0);
        Arrays.stream(strings).forEach(item -> input[index.getAndIncrement()] = Integer.parseInt(item));
        System.out.println(new BestSightseeingPair().maxScoreSightseeingPair(input));

    }
}
