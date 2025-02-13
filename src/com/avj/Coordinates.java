package com.avj;

public class Coordinates {
	int longitude;
	int latitude;
	int height;

	Coordinates(int p_longitude, int p_latitude, int p_height){
		longitude = p_longitude;
		latitude = p_latitude;
		if (p_height > 100) {
			height = 100;
		} else {
			height = p_height;
		}
	}

	public int getLongitude(){
		return longitude;
	}

	public int getLatitude(){
		return latitude;
	}

	public int getHeight(){
		return height;
	}
}
