package codevita;

public class HopGame {

    public int maxValue(int[] input) {

        int result = 0;
        int[] max = new int[input.length];
        int[] maxWDJ = new int[input.length];
        max[0] = input[0];
        maxWDJ[0]=input[0];
        for (int i = 1; i < input.length; i++) {
            //Without Double
            int one = max[i-1]+input[i];
            int two = -1;
            int three = -1;

            if (i - 2 >= 0) {
                two = 2 * input[i] + max[i - 2];
            }else{
                two = 2*input[i];
            }

            int maxV = Math.max(one,two);
            if (result < maxV) {
                result = maxV;
            }
            max[i] = maxV;

            maxV=0;
            one = Math.max(maxWDJ[i-1],max[i-1])+input[i];
            two = -1;
            three = -1;

            if (i - 2 >= 0) {
                two = 2 * input[i] + Math.max(maxWDJ[i - 2],max[i-2]);
            }else {
                two = 2*input[i];
            }

            if(i-3 >=0){
                three = 3*input[i] + max[i-3];
            }else if(i==2){
                three = 3*input[i];
            }
            maxV = Math.max(one,two);
            maxV = Math.max(maxV,three);
            if (result < maxV) {
                result = maxV;
            }
            maxWDJ[i] = maxV;
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] input = {4, 2, 3};
        int[] input = {34,35,6};
        System.out.println(new HopGame().maxValue(input));
    }
}
