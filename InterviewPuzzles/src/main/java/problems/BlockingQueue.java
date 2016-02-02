package problems;

import java.util.ArrayList;
import java.util.List;

public class BlockingQueue {

	private List<Integer> list;
	int limit = 2;
	
	public BlockingQueue(){
		list = new ArrayList<Integer>();
	}
	
	public synchronized void enqueue(Integer i) throws InterruptedException{
		if(list.size()==limit){
			System.out.println("Producer Waiting");
			wait();
		}
		
		if(list.size()==0){
			notifyAll();
		}
		System.out.println("Produced "+ i);
		list.add(i);
	}
	
	public synchronized Integer dequeue() throws InterruptedException{
		if(list.size()==0){
			wait();
			System.out.println("Consumer Waiting");
		}
		
		if(list.size()==limit){
			notifyAll();
		}
		if(list.size()>0){
		int i = list.remove(0);
		System.out.println("Consumed "+i);
		return i;
		}else{
			System.out.println("Consumed -1");
			return -1;
		}
	}
	
	
	public static void main(String[] args) {
		final BlockingQueue q = new BlockingQueue();
		new Thread(){
			public void run() {
				for(int i=1;i<10;i++){
				try {
					Thread.sleep((int)(Math.random()*1000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					q.enqueue(i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
//                System.out.println("Producer");
            }
		}.start();
		
		
		new Thread(){
			public void run() {
				for(int i=1;i<10;i++){
					try {
						Thread.sleep((int)(Math.random()*1000));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						q.dequeue();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
//                System.out.println("Consumer");
            }
		}.start();
		
		new Thread(){
			public void run() {
				for(int i=1;i<10;i++){
					try {
						Thread.sleep((int)(Math.random()*1000));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						q.dequeue();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
//                System.out.println("Consumer");
            }
		}.start();
	}
	
}
