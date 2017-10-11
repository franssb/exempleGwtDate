package be.steformations.fs.client.http.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

import be.steformations.fs.client.http.beans.DateParams;

public interface DateFormatRpcServiceAsync {

	void format(DateParams params, AsyncCallback<String> callback);

}
