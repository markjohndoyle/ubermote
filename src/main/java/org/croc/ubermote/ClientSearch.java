package org.croc.ubermote;

import org.croc.ubermote.model.DeviceModel;
import org.teleal.cling.UpnpService;
import org.teleal.cling.UpnpServiceImpl;
import org.teleal.cling.model.message.header.STAllHeader;
import org.teleal.cling.registry.RegistryListener;

/**
 * Runs a simple UPnP discovery procedure.
 */
public class ClientSearch {

	public static void main(String[] args) throws Exception {

		DeviceModel model = new DeviceModel();

		// UPnP discovery is asynchronous, we need a callback
		RegistryListener listener = new UpnpListener(model);

		// This will create necessary network resources for UPnP right away
		System.out.println("Starting Cling...");
		UpnpService upnpService = new UpnpServiceImpl(listener);

		// Send a search message to all devices and services, they should respond soon
		upnpService.getControlPoint().search(new STAllHeader());

		// Release all resources and advertise BYEBYE to other UPnP devices
		System.out.println("Stopping Cling...");
		upnpService.shutdown();
	}
}


