package com.vandenbreemen.jgdv;

import com.vandenbreemen.jgdv.mvp.SystemPresenter;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class ApplicationWindow extends JFrame {

    private Canvas canvas;
    private SystemPresenter presenter;

    /**
     * Actual loop of logic
     */
    private Thread logicLoop;

    public ApplicationWindow(SystemPresenter presenter, String title, int width, int height) {
        super(title);
        this.presenter = presenter;
        setBounds(20,20, width, height);

        canvas = new Canvas(width, height);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add("Center", canvas);

        presenter.initialize(canvas);
        initThread();

        setVisible(true);

        logicLoop.start();
    }

    /**
     * Set up but do not start the app thread
     */
    private void initThread() {
        logicLoop = new Thread("jgdv-logic-thread") {
            @Override
            public void run() {
                try {
                    do {
                        canvas.repaint();
                        sleep(10);
                    } while (currentThread() == this);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        };
        logicLoop.setPriority(Thread.NORM_PRIORITY + 1);    //  Slightly higher priority
    }

}
