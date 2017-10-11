package be.steformations.fs.client.http.rpc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

import be.steformations.fs.client.DateFormatController;

public class DateFormatRpcStringCallback implements AsyncCallback<String> {

	private DateFormatController controller;
	
	
	
	public DateFormatRpcStringCallback(DateFormatController controller) {
		super();
		this.controller = controller;
	}

	@Override
	public void onFailure(Throwable caught) {
		Window.alert(caught.getMessage());
		
	}

	@Override
	public void onSuccess(String result) {
		GWT.log("DataFormatRpcStringCallback.onSuccess() =>" + result);
		this.controller.setFormatedDate(result);
	}

}
