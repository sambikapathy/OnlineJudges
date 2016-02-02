package concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
	public static void main(String[] args) {

		Semaphore s = new Semaphore(2);
		List<Integer> a = new ArrayList<Integer>();
		for(int i=0;i<5;i++){
			new Thread(new Worker(s, i)).start();
			a.add(i);
		}
		
		System.out.println("Main Start");
		
		System.out.println(Collections.synchronizedList(a));
	}
	static class Worker implements Runnable{

		private Semaphore s = null;
		private int i = 0;
		public Worker(Semaphore s, int i){
			this.s = s;
			this.i = i;
		}
		@Override
		public void run() {
			try {
				s.acquire();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread "+i);
			
			s.release();
		}
		
	}
}

