package be.steformations.fs.client.http.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import be.steformations.fs.client.http.beans.DateParams;

//	http://127.0.0.1:8888/dateformatter/service
@RemoteServiceRelativePath("service")	
public interface DateFormatRpcService extends RemoteService{
	
	String format(DateParams params);
}
