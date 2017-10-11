package be.steformations.fs.client.http.rpc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

import be.steformations.fs.client.DateFormatController;
import be.steformations.fs.client.http.beans.DateResult;

public class DateFormatRcpDateResultCallback implements AsyncCallback<DateResult> {

	
	private DateFormatController controller;
	
	
	public DateFormatRcpDateResultCallback(DateFormatController controller) {
		super();
		this.controller = controller;
	}

	@Override
	public void onFailure(Throwable caught) {
		Window.alert(caught.getMessage());
		
	}

	@Override
	public void onSuccess(DateResult result) {
		GWT.log("DateFormatRcpDateResultCallback.onSuccess() =>" + result.toString());
		this.controller.setDateResult(result);
	}

}
