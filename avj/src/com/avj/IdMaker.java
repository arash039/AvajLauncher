package com.avj;

public class IdMaker {
	//private List<Integer> ids = new ArrayList<>();
	private int ids = 0;

	public int getId() {
		int temp = ids;
		ids++;
		return temp;
	}
}
