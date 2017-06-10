package com.data.dao.api;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;


public class DataActivator implements BundleActivator {
	
    public void start(BundleContext context) {
        System.out.println("Starting Demo bundle");
    }

    public void stop(BundleContext context) {
        System.out.println("Stopping Demo bundle");
    }
}