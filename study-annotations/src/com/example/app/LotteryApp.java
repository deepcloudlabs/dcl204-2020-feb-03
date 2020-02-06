package com.example.app;

import com.example.LotteryModel;
import com.example.service.RandomNumberService;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class LotteryApp {

	public static void main(String[] args) throws Exception {
		LotteryModel lottery = new LotteryModel();
		RandomNumberService.generateRandomNumbers(lottery);
		System.out.println(lottery.getNumbers());
	}

}
