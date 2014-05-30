package com.kourtessia.impl;

import javafx.application.Application;
import org.robovm.cocoatouch.foundation.NSAutoreleasePool;
import org.robovm.cocoatouch.foundation.NSDictionary;
import org.robovm.cocoatouch.uikit.UIApplication;
import org.robovm.cocoatouch.uikit.UIApplicationDelegate;

public class RoboVMMain extends UIApplicationDelegate.Adapter {

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
