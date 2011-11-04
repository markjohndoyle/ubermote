package org.croc.ubermote.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PropertySupportModelObject {

	PropertyChangeSupport propSupport = new PropertyChangeSupport(this);

	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		propSupport.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		propSupport.removePropertyChangeListener(propertyName, listener);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.propSupport.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		this.propSupport.removePropertyChangeListener(listener);
	}

	/**
	 * @return the propSupport
	 */
	protected PropertyChangeSupport getPropSupport() {
		return propSupport;
	}

	protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
		propSupport.firePropertyChange(propertyName, oldValue, newValue);
	}
}
