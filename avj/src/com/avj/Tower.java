package com.avj;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();

    void register(Flyable p_flyable){}
    void unregister(Flyable p_flyable){}
    void conditionChnaged(){}
}

