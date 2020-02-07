package com.example;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class StudyRunnableThread {

	public static void main(String[] args) throws Exception {
		MyTask task = new MyTask();
		FutureTask<Integer> future = 
				new FutureTask<Integer>(task); 
		Thread t = new Thread(future);
		t.start();
		System.out.println(future.get());
		System.out.println("Bye");
	}

}

class Task implements Runnable {
	private int result;

	@Override
	public void run() {
		System.out.println("Hello Mars!");
		result = 42;
	}

	public int getResult() {
		return result;
	}

}
class MyTask implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		System.out.println("Hello Mars!");
		return 42;
	}
	
}
