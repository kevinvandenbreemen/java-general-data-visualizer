package com.vandenbreemen.jgdv;

import com.vandenbreemen.jgdv.mvp.SystemModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//  This code based heavily on https://gist.github.com/berlinbrown/4176103
//  As per that page I include the following copyright notice:
/**
 * Copyright (c) 2006-2010 Berlin Brown and botnode.com  All Rights Reserved
 *
 * http://www.opensource.org/licenses/bsd-license.php
 * All rights reserved.
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 * * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * * Neither the name of the Botnode.com (Berlin Brown) nor
 * the names of its contributors may be used to endorse or promote
 * products derived from this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * BasicDoubleBufferSwing.java
 * Jan 10, 2011
 * bbrown
 * Contact: Berlin Brown <berlin dot brown at gmail.com>
 */
public class Canvas extends JPanel implements MouseListener {

    private Image offScreenImageDrawed = null;
    private Graphics offScreenGraphicsDrawed = null;
    private SystemModel model;

    public Canvas(int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.white);

        addMouseListener(this);
    }

    public void setModel(SystemModel model) {
        this.model = model;
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        final Dimension d = getSize();
        if (offScreenImageDrawed == null) {
            // Double-buffer: clear the offscreen image.
            offScreenImageDrawed = createImage(d.width, d.height);
        }
        offScreenGraphicsDrawed = offScreenImageDrawed.getGraphics();
        offScreenGraphicsDrawed.setColor(Color.white);
        offScreenGraphicsDrawed.fillRect(0, 0, d.width, d.height);

        renderOffScreen((Graphics2D)offScreenImageDrawed.getGraphics());
        g.drawImage(offScreenImageDrawed, 0, 0, null);
    }

    /**
     * Render content proper
     * @param g
     */
    public void renderOffScreen(final Graphics2D g) {
        g.setColor(Color.black);

        final Dimension d = getSize();

        model.render(g, d);
    }


    @Override
    public void mouseClicked(MouseEvent e) {



    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}