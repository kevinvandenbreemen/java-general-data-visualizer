package com.vandenbreemen.jgdv.mvp;

import java.awt.*;

/**
 * Underlying data structure you want to render.  Knows how to draw parts of itself
 */
public interface SystemModel {

    /**
     * Render current state of the system model
     * @param graphics2D    Java {@link Graphics2D} object to draw on
     * @param size          Size of the area to draw on
     */
    void render(Graphics2D graphics2D, Dimension size);
}
