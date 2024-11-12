package com.avj;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();

    void register(Flyable p_flyable){
		observers.add(p_flyable);
		System.out.println("Tower says:" + p_flyable.getType() + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ") registered to weather tower.");
	}
    void unregister(Flyable p_flyable){
		observers.remove(p_flyable);
		System.out.println("Tower says:" + p_flyable.getType() + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ") unregistered from weather tower.");
	}
    void conditionChnaged(){
		for (Flyable flyable : observers)
			flyable.updateConditions();
	}
}

