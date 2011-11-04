package org.croc.ubermote.model;

import org.teleal.cling.model.meta.ActionArgument;

public class ArgumentValueConstruct extends PropertySupportModelObject {

	private ActionArgument<?> argument;
	private Object value;

	public ArgumentValueConstruct(ActionArgument<?> argument, Object value) {
		super();
		this.argument = argument;
		this.value = value;
	}
	
	public String getDatatype() {
		return argument.getDatatype().getDisplayString();
	}

	/**
	 * @return the argument
	 */
	public ActionArgument<?> getArgument() {
		return argument;
	}

	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param argument
	 *            the argument to set
	 */
	public void setArgument(ActionArgument<?> argument) {
		getPropSupport().firePropertyChange("argument", this.argument, this.argument = argument);
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(Object value) {
		System.out.println("Setting new value " + value);
		getPropSupport().firePropertyChange("value", this.value, this.value = value);
	}

}
