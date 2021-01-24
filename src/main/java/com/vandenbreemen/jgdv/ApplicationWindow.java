package com.vandenbreemen.jgdv;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class ApplicationWindow extends JFrame {

    private Canvas canvas;

    public ApplicationWindow(String title, int width, int height) {
        super(title);

        setBounds(20,20, width, height);
        canvas = new Canvas(width, height);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add("Center", canvas);

        setVisible(true);
    }

    public static void main(String[] args) {
        int width = 800;
        int height = 800;
        new ApplicationWindow("Test", width, height);
    }

}
