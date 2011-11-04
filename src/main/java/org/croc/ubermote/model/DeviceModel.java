package org.croc.ubermote.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import org.teleal.cling.model.meta.LocalDevice;
import org.teleal.cling.model.meta.RemoteDevice;

public class DeviceModel {

	private final PropertyChangeSupport propChangeSupport = new PropertyChangeSupport(this);

	private List<RemoteDevice> availableRemoteDevices = new ArrayList<RemoteDevice>();
	private List<LocalDevice> availableLocalDevices = new ArrayList<LocalDevice>();

	/**
	 * @return the availableRemoteDevices
	 */
	public List<RemoteDevice> getAvailableRemoteDevices() {
		return availableRemoteDevices;
	}

	/**
	 * @return the availableLocalDevices
	 */
	public List<LocalDevice> getAvailableLocalDevices() {
		return availableLocalDevices;
	}

	public void addRemoteDevice(RemoteDevice device) {
		this.availableRemoteDevices.add(device);
		propChangeSupport.firePropertyChange("availableRemoteDevices", null, this.availableRemoteDevices);
	}

	public void addLocalDevice(LocalDevice device) {
		this.availableLocalDevices.add(device);
		propChangeSupport.firePropertyChange("availableLocalDevices", null, this.availableLocalDevices);
	}

	public void removeRemoteDevice(RemoteDevice device) {
		this.availableRemoteDevices.remove(device);
		propChangeSupport.firePropertyChange("availableRemoteDevices", null, this.availableRemoteDevices);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.propChangeSupport.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		this.propChangeSupport.removePropertyChangeListener(listener);
	}

}
