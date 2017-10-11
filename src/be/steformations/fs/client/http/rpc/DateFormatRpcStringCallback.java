package be.steformations.fs.client.http.rpc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class DateFormatRpcStringCallback implements AsyncCallback<String> {

	@Override
	public void onFailure(Throwable caught) {
		Window.alert(caught.getMessage());
		
	}

	@Override
	public void onSuccess(String result) {
		GWT.log("DataFormatRpcStringCallback.onSuccess() =>" + result);
		
	}

}
