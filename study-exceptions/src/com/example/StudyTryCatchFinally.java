package com.example;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class StudyTryCatchFinally {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// Java SE 7: Try-with-resources
		try (PreciousResource res1 = new PreciousResource(1);
				PreciousResource res2 = new PreciousResource(2);
				PreciousResource res3 = new PreciousResource(3);) {
			int x = 1 / 0;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
