package com.example.service.impl;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.example.service.LotteryService;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class SimpleLotteryService implements LotteryService {
	private LotteryService self;
	
	public void setProxy(LotteryService self) {
		this.self = self;
	}

	@Override
	public List<Integer> draw() {
		return ThreadLocalRandom.current().ints(1, 50).distinct().limit(6).sorted().boxed()
				.collect(Collectors.toList());
	}

	@Override
	public List<List<Integer>> draw(int n) {
		return IntStream.range(0, n)
				.mapToObj(i -> self.draw()).collect(Collectors.toList());
	}

}
