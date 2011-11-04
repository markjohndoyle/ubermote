package org.croc.ubermote;

import org.croc.ubermote.model.DeviceModel;
import org.teleal.cling.UpnpService;
import org.teleal.cling.UpnpServiceImpl;
import org.teleal.cling.model.message.header.STAllHeader;
import org.teleal.cling.registry.RegistryListener;

public class UpnpScanner {

	private RegistryListener registry;
	private UpnpService upnpService;

	public UpnpScanner(DeviceModel model) {
		registry = new UpnpListener(model);
	}

	public void scan() {
		// This will create necessary network resources for UPnP right away
		System.out.println("Starting Cling...");
		upnpService = new UpnpServiceImpl(registry);

		// Send a search message to all devices and services, they should respond soon
		upnpService.getControlPoint().search(new STAllHeader());
	}

	/**
	 * @return the upnpService
	 */
	public UpnpService getUpnpService() {
		return upnpService;
	}
}
