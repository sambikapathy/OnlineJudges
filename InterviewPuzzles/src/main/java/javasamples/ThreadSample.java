package javasamples;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSample {

}

class Printer implements  Runnable{

    boolean even = false;
    AtomicInteger state;
    public Printer(boolean isEven, AtomicInteger temp){
        this.even = isEven;
        state = temp;
    }
    @Override
    public void run() {
        if(even){
            if(state.intValue() % 2 == 0){

            }
        }else{

        }
    }
}
