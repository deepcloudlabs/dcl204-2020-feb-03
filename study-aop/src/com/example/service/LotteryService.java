package com.example.service;

import java.util.List;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public interface LotteryService {
	List<Integer> draw();

	List<List<Integer>> draw(int n);
}
