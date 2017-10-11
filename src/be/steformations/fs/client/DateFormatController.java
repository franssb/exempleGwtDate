package be.steformations.fs.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

import be.steformations.fs.client.http.beans.DateParams;
import be.steformations.fs.client.http.rpc.DateFormatRpcService;
import be.steformations.fs.client.http.rpc.DateFormatRpcServiceAsync;
import be.steformations.fs.client.http.rpc.DateFormatRpcStringCallback;
import be.steformations.fs.client.ui.DateFormatterUI;

public class DateFormatController implements ClickHandler{

	private DateFormatterUI ui;
	
	public DateFormatController(DateFormatterUI ui) {
		super();
		this.ui=ui;
		this.ui.getFormatEventSource().addClickHandler(this);
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
		
		this.formatDateRpc(params);
		
	}
	
	private void formatDateRpc(DateParams params){
		GWT.log("DateFormatController.formatDateRpc()");
		DateFormatRpcServiceAsync service = GWT.create(DateFormatRpcService.class);
		DateFormatRpcStringCallback callback = new DateFormatRpcStringCallback();
		service.format(params, callback);	// appel http
	}

}
