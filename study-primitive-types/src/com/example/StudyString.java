package com.example;

public class StudyString {

	public static void main(String[] args) {
		String p = "Jack";
		String q = new String("Jack");
		String r = "Jack";
		System.out.println("p==q: "+(p==q));
		System.out.println("p.equals(q): "+p.equals(q));
		System.out.println("p==r: "+(p==r));
        q = q.intern();    
		System.out.println("p==q: "+(p==q));
	}

}
