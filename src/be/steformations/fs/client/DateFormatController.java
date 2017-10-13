package be.steformations.fs.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

import be.steformations.fs.client.http.beans.DateParams;
import be.steformations.fs.client.http.beans.DateResult;
import be.steformations.fs.client.http.rpc.DateFormatRcpDateResultCallback;
import be.steformations.fs.client.http.rpc.DateFormatRpcService;
import be.steformations.fs.client.http.rpc.DateFormatRpcServiceAsync;
import be.steformations.fs.client.http.rpc.DateFormatRpcStringCallback;
import be.steformations.fs.client.http.standard.LocalesRequestCallback;
import be.steformations.fs.client.ui.DateFormatterUI;

public class DateFormatController implements ClickHandler{

	private DateFormatterUI ui;
	
	public DateFormatController(DateFormatterUI ui) {
		super();
		this.ui=ui;
		this.ui.getFormatEventSource().addClickHandler(this);
		this.getAvailableLocales();
	}
	@Override
	public void onClick(ClickEvent event) {
		GWT.log("DateFormatController.onClick()");
		DateParams params = new DateParams();
		params.setDay((Integer.parseInt(this.ui.getDayInput().getValue())));
		params.setMonth((Integer.parseInt(this.ui.getMonthInput().getValue())));
		params.setYear(this.ui.getYearInput().getValue());
		params.setLocale(this.ui.getLocaleInput().getValue());
		GWT.log(params.toString());
		
		//this.formatDateRpc(params);
		this.formatDateToOBjectRpc(params);
	}
	
	public void setFormatedDate(String s){
		GWT.log("DateFormatController.setFormatedDate() =>" +s);
		this.ui.getOutput().setText(s);
	}	
	
	public void setDateResult(DateResult result){
		GWT.log("DateFormatController.setDateResult() =>" + result);
		this.ui.getOutput().setText(result.getFormattedDate());
	}
	
	public void setAvailableLocales(String[] locales) {
		GWT.log("DateFormatController.setAvailableLocales()");
		this.ui.setLocales(locales);
		
	}
	
	private void formatDateToOBjectRpc(DateParams params){
		GWT.log("DateFormatController.formatDateToOBjectRpc()");
		DateFormatRpcServiceAsync service = GWT.create(DateFormatRpcService.class);
		DateFormatRcpDateResultCallback callback = new DateFormatRcpDateResultCallback(this);
		service.formatToObject(params, callback);	//post http
	}
	
	@SuppressWarnings("unused")
	private void formatDateRpc(DateParams params){
		GWT.log("DateFormatController.formatDateRpc()");
		DateFormatRpcServiceAsync service = GWT.create(DateFormatRpcService.class);
		AsyncCallback<String> callback = new DateFormatRpcStringCallback(this);
		service.format(params, callback);	// appel http
	}

	private void getAvailableLocales(){
		GWT.log("DateFormatController.getAvailableLocales()");
		String url="http://127.0.0.1:8888/available/locales";
		RequestBuilder rb = new RequestBuilder(RequestBuilder.GET, url);
		LocalesRequestCallback callback = new LocalesRequestCallback(this);
		rb.setCallback(callback);
		try {
			rb.send();	//get http
		} catch (Exception e) {
			Window.alert(e.getMessage());
		}
	}
	
	

}
