package com.vandenbreemen.jgdv.test;

import com.vandenbreemen.jgdv.mvp.SystemModel;

import java.awt.*;

public class TestModel implements SystemModel {

    private int positionX = 0;
    private int positionY = 0;

    @Override
    public void render(Graphics2D graphics2D, Dimension size) {
        graphics2D.setColor(Color.BLACK);

        positionX += 1;
        positionY += 1;
        positionX %= size.width;
        positionY %= size.height;

        graphics2D.drawString("THIS IS A TEST", positionX, positionY);
    }
}
