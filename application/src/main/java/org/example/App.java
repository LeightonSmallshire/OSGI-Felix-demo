package org.example;

import org.apache.felix.framework.Felix;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import org.osgi.framework.ServiceReference;


import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import static org.osgi.framework.Constants.FRAMEWORK_STORAGE;

public class App {
    public static void main(String[] args) throws BundleException, InterruptedException, IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("ds.showtrace", "true"); // DEBUG
        map.put("ds.showerrors", "true");// DEBUG
        // use a temporary directory for the cache;
        map.put(FRAMEWORK_STORAGE, Files.createTempDirectory("felix-cache").toString());
        Felix f = new Felix(map);

        System.out.println("Starting OSGI...");
        f.start();

        // install bundles;
        f.getBundleContext().installBundle("file:demo-service/target/demo-service-1.0-SNAPSHOT.jar");

        // Start bundles & print services
        for (Bundle bundle : f.getBundleContext().getBundles()) {
            System.out.println("Bundle: " + bundle.getSymbolicName());
            bundle.start();
            if (bundle.getRegisteredServices() != null) {
                System.out.println("\tRegistered services:");
                for (ServiceReference<?> serviceReference : bundle.getRegisteredServices())
                    System.out.println("\t\t" + serviceReference);
            }
        }

        System.out.println("Stopping...");
        f.stop();
        f.waitForStop(1000);
    }
}
