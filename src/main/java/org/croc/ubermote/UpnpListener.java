package org.croc.ubermote;

import org.croc.ubermote.model.DeviceModel;
import org.teleal.cling.model.meta.LocalDevice;
import org.teleal.cling.model.meta.RemoteDevice;
import org.teleal.cling.registry.Registry;
import org.teleal.cling.registry.RegistryListener;

public class UpnpListener implements RegistryListener {
	
	DeviceModel model;
	
	public UpnpListener(DeviceModel model) {
		this.model = model;
	}
	
	public void remoteDeviceDiscoveryStarted(Registry registry, RemoteDevice device) {
		String host = device.getIdentity().getDescriptorURL().getHost();
		System.out.println("Discovery started: " + device.getDisplayString() + " on " + host);
	}

	public void remoteDeviceDiscoveryFailed(Registry registry, RemoteDevice device, Exception ex) {
		System.out.println("Discovery failed: " + device.getDisplayString() + " => " + ex);
	}

	public void remoteDeviceAdded(Registry registry, RemoteDevice device) {
		System.out.println("Remote device available: " + device.getDisplayString());
		model.addRemoteDevice(device);
	}

	public void remoteDeviceUpdated(Registry registry, RemoteDevice device) {
	}

	public void remoteDeviceRemoved(Registry registry, RemoteDevice device) {
		String host = device.getIdentity().getDescriptorURL().getHost();
		System.out.println("Remote device removed: " + device.getDisplayString() + " on " + host);
		model.removeRemoteDevice(device);
	}

	
	
	public void localDeviceAdded(Registry registry, LocalDevice device) {
		System.out.println("Local device added: " + device.getDisplayString());
		model.addLocalDevice(device);
	}

	public void localDeviceRemoved(Registry registry, LocalDevice device) {
		System.out.println("Local device removed: " + device.getDisplayString());
		model.addLocalDevice(device);
	}

	public void beforeShutdown(Registry registry) {
		System.out.println("Before shutdown, the registry has devices: " + registry.getDevices().size());
	}

	public void afterShutdown() {
		System.out.println("Shutdown of registry complete!");

	}

	
}
