package com.kourtessia.impl;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;

import javafx.application.Application;

public class RoboVMMain extends UIApplicationDelegateAdapter {

    @Override
    public boolean didFinishLaunching(UIApplication application, NSDictionary launchOptions) {

        Thread launchThread = new Thread() {
            @Override
            public void run() {
                Application.launch(JavaFXAddressBook.class);
            }
        };
        launchThread.setDaemon(true);
        launchThread.start();

        return true;
    }

    public static void main(String[] args) throws Exception {
        System.setProperty("glass.platform", "ios");
        System.setProperty("prism.text", "native");

        NSAutoreleasePool pool = new NSAutoreleasePool();
        UIApplication.main(args, null, RoboVMMain.class);
        pool.drain();
    }
}

