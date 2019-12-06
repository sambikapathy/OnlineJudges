package codevita;

import java.util.BitSet;

public class Inverses {

    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    public int count2(int input) {
        int count = 0;
        boolean iseven = input % 2 == 0;
        for (int i = 1; i < input; i++) {

            if (gcd(input, i) == 1) {
                count++;
            }
//            if(iseven){
//                i++;
//            }
        }
        return count;
    }
    //99876876
    //99876876
    public static void main(String[] args) {
        long st = System.currentTimeMillis();
        System.out.println(new Inverses().count((int) Math.pow(10, 8)-123123));
//        System.out.println(new Inverses().count(10));
        Inverses in = new Inverses();
//        for(int i=12;i<Math.pow(10,8);i++){
//            try {
//                if (in.count2(i) != in.count(i)) {
//                    System.out.println(i);
//                }
//            }catch (Exception e){
//                System.out.println("Failed for "+ i);
//                System.exit(1);
//            }
//        }
    }

    private int count(int input) {
        int[] factors = new int[input/2+1];

        int index = 0;

        for (int i = 2; i <= Math.sqrt(input) + 1; i++) {
            if (input % i == 0) {
                // If divisors are equal, print only one
                if (input / i == i)
                    factors[index++] = i;

                else {
                    factors[index++] = i;
                    factors[index++] = input / i;
                }
            }
        }

        int count = 0;

        int chunkSize = 10000;
        int numOfChunks = (int)Math.ceil(input / chunkSize);
        for(int i = 0; i < numOfChunks; ++i) {
            int start = i * chunkSize;
            int length = Math.min(input - start, chunkSize);

            int[] temp = new int[length];
            count+=getVal(start,input,index,factors);
        }

//        for(int i=1;i<input/1000;i++){
//            count+=getVal(i*1000,index,factors);
//        }
        return count;
    }

    private int getVal(int start , int input,int index,int[]factors){
        BitSet result = new BitSet(input);
        for(int i=0;i<index;i++){
            for(int j=1;j<input/factors[i];j++){
                result.set(j*factors[i]);
            }
        }
        int count = 0;
        for(int i=1;i<input;i++){
            if(!result.get(i)){
                count++;
            }
        }
        return count;
    }

    private int count1(int input) {
        int[] factors = new int[input / 2];

        int index = 0;
        boolean iseven = false;
        if (input % 2 == 0) {
            factors[0] = 2;
            iseven = true;
            index++;
        }
        for (int i = 2; i <= Math.sqrt(input) + 1; i++) {
            if (input % i == 0) {
                // If divisors are equal, print only one
                if (input / i == i)
                    factors[index++] = i;

                else {
                    factors[index++] = i;
                    factors[index++] = input / i;
                }
            }
        }
        int count = 0;
        for (int i = 1; i < input; i++) {
            if (iseven && i % 2 == 0) {
                continue;
            }
            boolean fact = false;
            for (int j = 0; j < index; j++) {
                if (i % factors[j] == 0) {
                    fact = true;
                    break;
                }
            }
            if (!fact) {
                count++;
            }
        }
        return count;
    }
}
