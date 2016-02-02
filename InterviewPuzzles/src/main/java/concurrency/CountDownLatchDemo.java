package concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

	public static void main(String[] args) {
		CountDownLatch start = new CountDownLatch(1);
		CountDownLatch end = new CountDownLatch(5);
		
		for(int i=0;i<5;i++){
			new Thread(new Worker(start , end)).start();
		}
		System.out.println("Main Start");
		start.countDown();
		try {
			end.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main End");
	}
}

class Worker implements Runnable{

	private CountDownLatch start = null;
	private CountDownLatch end = null;
	
	public Worker(CountDownLatch start , CountDownLatch end){
		this.start = start;
		this.end = end;
	}
	@Override
	public void run() {
		try {
			start.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.toString());
		end.countDown();
	}
	
}
