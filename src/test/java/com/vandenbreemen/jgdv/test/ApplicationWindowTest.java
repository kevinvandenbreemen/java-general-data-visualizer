package com.vandenbreemen.jgdv.test;

import com.vandenbreemen.jgdv.ApplicationWindow;
import com.vandenbreemen.jgdv.mvp.MenuItem;

public class ApplicationWindowTest {

    public static void main(String[] args) {
        int width = 800;
        int height = 800;
        ApplicationWindow win = new ApplicationWindow(new TestPresenter(new TestModel()), "Test", width, height);
        win.addFileMenuItem(new MenuItem() {
            @Override
            public String getName() {
                return "FTEST";
            }

            @Override
            public void doAction() {
                System.out.println("THIS IS A TEST");
            }
        });
        win.addFileMenuItem(new MenuItem() {
            @Override
            public String getName() {
                return "Another Test";
            }

            @Override
            public void doAction() {
                System.out.println("ANOTHER TEST");
            }
        });
    }

}
