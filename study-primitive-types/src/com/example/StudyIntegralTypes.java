package com.example;

import java.math.BigInteger;

public class StudyIntegralTypes {

	public static void main(String[] args) {
		byte b = -128; // 1-Byte, [-128..127]
		System.out.println("b="+b);
        b--;
        System.out.println("b="+b);
        short s = 2; // 2-byte, [-32768..32767] 
        s = Short.MIN_VALUE;
        System.out.println("s="+s);
        s--;
        System.out.println("s="+s);
        int i = 3; // 4-byte, [-2147483648..2147483647]
        i=Integer.MIN_VALUE;
        System.out.println("i="+i);
        --i;
        System.out.println("i="+i);
        long l = 4 ; // 8-byte, [-9223372036854775808..9223372036854775807]
        l=Long.MIN_VALUE;
        System.out.println("l="+l);
        --l;
        System.out.println("l="+l);
        BigInteger bi = BigInteger.valueOf(Long.MAX_VALUE);
        System.out.println("bi="+bi);
        bi = bi.add(BigInteger.ONE);
        System.out.println("bi="+bi);
        byte x=9,y=123,z=0;
        z = (byte)(z + x + y) ;
        System.out.println("z="+z);
//        i = 0 / 0;
//        System.out.println("i="+i);
        long u = Integer.MAX_VALUE + 1L;
        System.out.println("u="+u);
	}

}
