package com.vandenbreemen.jgdv.mvp;

import com.vandenbreemen.jgdv.Canvas;

public class SystemPresenter<M extends SystemModel> {

    private M model;

    public SystemPresenter(M model) {
        this.model = model;
    }

    public void initialize(Canvas canvas) {
        canvas.setModel(this.model);
    }
}
