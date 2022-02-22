package org.example;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;


public class DemoServiceListener implements BundleActivator, ServiceListener {
    public void start(BundleContext bc) {
        System.out.println("Hello world!");
        bc.addServiceListener(this);
    }

    public void stop(BundleContext bc) {
        bc.removeServiceListener(this);
        System.out.println("Goodbye, cruel world");
    }

    public void serviceChanged(ServiceEvent se) {
        String s;

        switch (se.getType()) {
            case ServiceEvent.MODIFIED:
                s = "modified";
                break;
            case ServiceEvent.REGISTERED:
                s = "registered";
                break;
            case ServiceEvent.UNREGISTERING:
                s = "unregistered";
                break;
            default:
                s = "unknown";
        }

        System.out.println("= = = service changed: " + s);
    }
}
