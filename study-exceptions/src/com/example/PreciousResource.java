package com.example;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class PreciousResource implements AutoCloseable {
	private int id;

	public PreciousResource(int id) {
		this.id = id;
	}

	@Override
	public void close() throws Exception {
		System.out.println("Closing the resource " + id);

	}

}
