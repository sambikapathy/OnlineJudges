package javasamples;

import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {

	static LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);

	public static void main(String[] args) {

		System.out.println(queue.remainingCapacity());
		new Thread(new Producer(queue)).start();
		
		new Thread(new Consumer(queue)).start();
		
		
	}

	public static void sleep(int n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Producer implements Runnable {

	static int i = 0;
	LinkedBlockingQueue<String> queue;

	public Producer(LinkedBlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("Produced "+i);
			try {
				queue.put(i+++"");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ProducerConsumer.sleep(100);

		}

	}

}

class Consumer implements Runnable {

	LinkedBlockingQueue<String> queue;

	public Consumer(LinkedBlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			while(true){
			System.out.println(" Consumed " + queue.take());
			ProducerConsumer.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
