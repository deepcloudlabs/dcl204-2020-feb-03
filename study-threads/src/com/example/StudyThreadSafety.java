package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class StudyThreadSafety {

	public static void main(String[] args) throws InterruptedException {
		AnotherTask task = new AnotherTask();
		int logicalProcessors= Runtime.getRuntime().availableProcessors();
		ExecutorService es = 
				Executors.newFixedThreadPool(logicalProcessors);
		IntStream.range(0,1_000)
		         .forEach(i -> es.submit(task) );
		es.shutdown();
		es.awaitTermination(100, TimeUnit.SECONDS);
		System.out.println("counter: "+task.getCounter()); 
	}

}

class AnotherTask implements Runnable {
	private AtomicInteger counter = new AtomicInteger(0);

	@Override
	public void run() {
		for (int i=0;i<10_000_000;++i) {
			counter.incrementAndGet();				
		}
	}

	public int getCounter() {
		return counter.get();
	}
	
}
