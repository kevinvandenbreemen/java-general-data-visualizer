package com.vandenbreemen.jgdv;

import com.vandenbreemen.jgdv.mvp.MenuItem;
import com.vandenbreemen.jgdv.mvp.SystemPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ApplicationWindow extends JFrame {

    private static final long LOGIC_LOOP_DELAY_MILLIS = 10;

    private Canvas canvas;
    private SystemPresenter presenter;

    private List<MenuItem> fileMenuItems;

    /**
     * Actual loop of logic
     */
    private Thread logicLoop;

    public ApplicationWindow(SystemPresenter presenter, String title, int width, int height) {
        super(title);
        this.presenter = presenter;
        this.fileMenuItems = new ArrayList<>();
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
                        presenter.notifyObservers();
                        sleep(LOGIC_LOOP_DELAY_MILLIS);
                    } while (currentThread() == this);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        };
        logicLoop.setPriority(Thread.NORM_PRIORITY + 1);    //  Slightly higher priority
    }

    private void updateMenu() {
        JMenuBar bar = new JMenuBar();
        if(!fileMenuItems.isEmpty()) {
            JMenu fileMenu = new JMenu("FILE");
            fileMenuItems.forEach(menuItem -> {
                JMenuItem item = new JMenuItem(menuItem.getName());
                item.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuItem.doAction();
                    }
                });
                fileMenu.add(item);
            });

            bar.add(fileMenu);
        }

        setJMenuBar(bar);
        invalidate();
    }

    public void addFileMenuItem(MenuItem item) {
        fileMenuItems.add(item);
        updateMenu();
    }

}
