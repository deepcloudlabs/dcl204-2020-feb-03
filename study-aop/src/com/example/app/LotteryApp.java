package com.example.app;

import java.lang.reflect.Proxy;

import com.example.aop.ProfilerHandler;
import com.example.service.LotteryService;
import com.example.service.impl.SimpleLotteryService;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class LotteryApp {

	public static void main(String[] args) {
		SimpleLotteryService lotterySrv = 
				new SimpleLotteryService();
		Class<? extends LotteryService> clazz = lotterySrv.getClass();
		LotteryService lotteryProxy =
				(LotteryService) 
		   Proxy.newProxyInstance(
				clazz.getClassLoader(), 
				clazz.getInterfaces(), 
				new ProfilerHandler(lotterySrv));
		lotterySrv.setProxy(lotteryProxy);
       System.out.println(lotteryProxy.getClass());
       System.out.println(lotteryProxy.draw());
       lotteryProxy.draw(10).forEach(System.out::println);
	}

}
