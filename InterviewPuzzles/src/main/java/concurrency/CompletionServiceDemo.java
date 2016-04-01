package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;


public class CompletionServiceDemo {

	public static void main(String[] args) throws ExecutionException {
		
		CompletionService<String> c = new ExecutorCompletionService(Executors.newFixedThreadPool(2));
		
		c.submit(new Worker());
		try {
			System.out.println(c.take().get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		c.shutdown();
	}
	
	static class Worker implements Callable<String>{

		public Worker(){
		}
		
		@Override
		public String call() throws Exception {
		return "result";
		}
		
	}
}
