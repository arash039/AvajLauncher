package com.avj;

import java.util.ArrayList;
import java.util.List;

public class Tower {
	private List<Flyable> observers = new ArrayList<>();
	public boolean earlyEnd = false;
	
	public void register(Flyable p_flyable){
		observers.add(p_flyable);
		System.out.println("Tower says: " + p_flyable.getType() + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ") registered to weather tower.");
	}
	public void unregister(Flyable p_flyable){
		observers.remove(p_flyable);
		System.out.println("Tower says: " + p_flyable.getType() + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ") unregistered from weather tower.");
	}
	public void conditionChanged(){
		List<Flyable> temp = new ArrayList<>(observers);
		for (Flyable index : temp)
			index.updateConditions();
		if (observers.size() == 0) {
			earlyEnd = true;
			return;
		}
	}
}
