package com.example.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class ProfilerHandler implements InvocationHandler {
	private Object target;

	public ProfilerHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long start = System.nanoTime();
		Object result = method.invoke(target, args);
		long stop = System.nanoTime();
		System.out.println(String.format("%s runs %d ns.", method.getName(), (stop - start)));
		return result;
	}

}
