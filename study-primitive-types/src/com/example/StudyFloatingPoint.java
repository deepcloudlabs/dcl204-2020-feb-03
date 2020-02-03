package com.example;

import java.math.BigDecimal;

public class StudyFloatingPoint {

	public static void main(String[] args) {
		// IEEE-754
		float f = 3.1415161718F; // 4-byte
		double g = 3.1415; // 8-byte
		float x = 1_000_000_000;
		x += 50;
		System.out.println(
			String.format("%16.3f", x)
		);
		double y = 2.0;
		y = y - 1.10;
		System.out.println(
			String.format("%16.16f", y)
		);
		BigDecimal bd = new BigDecimal("2.0");
		bd = bd.subtract(new BigDecimal("1.1"));
		System.out.println(bd);
		double one = 0/0.;
		System.out.println(Double.isNaN(one));
	}

}
