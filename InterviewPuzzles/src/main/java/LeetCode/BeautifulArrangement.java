package LeetCode;

import java.util.concurrent.atomic.AtomicInteger;

public class BeautifulArrangement {

    public int countArrangement(int N) {
        AtomicInteger total = new AtomicInteger(0);
        boolean[] flags = new boolean[N+1];
        countArrangement(N,0,1, total, flags);
        return total.intValue();
    }

    public void countArrangement(int N,int count, int index, AtomicInteger total, boolean[] flag) {
        if(count == N){
            total.incrementAndGet();
            return;
        }
        for(int i=1;i<=N;i++){
            if(flag[i]){
                continue;
            }
            if(i % index == 0 || index % i == 0){
                flag[i]= true;
                countArrangement(N, count+1, index+1, total, flag);
                flag[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        for(int i=1;i<=15;i++) {
            System.out.print(new BeautifulArrangement().countArrangement(i)+", ");
        }
    }
}
