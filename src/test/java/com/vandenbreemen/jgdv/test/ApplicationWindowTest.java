package com.vandenbreemen.jgdv.test;

import com.vandenbreemen.jgdv.ApplicationWindow;

public class ApplicationWindowTest {

    public static void main(String[] args) {
        int width = 800;
        int height = 800;
        new ApplicationWindow(new TestPresenter(new TestModel()), "Test", width, height);
    }

}