package com.vandenbreemen.jgdv.mvp;

import com.vandenbreemen.jgdv.Canvas;

import java.util.ArrayList;
import java.util.List;

public class SystemPresenter<M extends SystemModel> {

    private M model;
    private List<LogicCycleObserver> observers;

    public SystemPresenter(M model) {
        this.model = model;
        this.observers = new ArrayList<>();
    }

    public void initialize(Canvas canvas) {
        canvas.setModel(this.model);
    }

    public void addObserver(LogicCycleObserver observer) {
        this.observers.add(observer);
    }

    public void notifyObservers() {
        observers.forEach(LogicCycleObserver::update);
    }
}
