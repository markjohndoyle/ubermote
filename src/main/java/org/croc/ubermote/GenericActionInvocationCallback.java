package org.croc.ubermote;

import org.teleal.cling.controlpoint.ActionCallback;
import org.teleal.cling.model.action.ActionArgumentValue;
import org.teleal.cling.model.action.ActionInvocation;
import org.teleal.cling.model.message.UpnpResponse;

public class GenericActionInvocationCallback extends ActionCallback {


	public GenericActionInvocationCallback(ActionInvocation actionInvocation) {
		super(actionInvocation);
	}
	
	@Override
	public void success(ActionInvocation invocation) {
		for(ActionArgumentValue  argValue : invocation.getOutput()) {
			ActionArgumentValue status  = invocation.getOutput(argValue.getArgument().getName());
			System.out.println(status);
		}
	}

	@Override
	public void failure(ActionInvocation invocation, UpnpResponse operation, String defaultMsg) {
		System.err.println(defaultMsg);
	}
}
