package be.steformations.fs.serveur;

import java.util.Locale;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.GregorianCalendar;

import be.steformations.fs.client.http.beans.DateParams;
import be.steformations.fs.client.http.rpc.DateFormatRpcService;

@SuppressWarnings("serial")
public class DateFormatRpcServiceImpl 
		extends RemoteServiceServlet 	//extension de HttpServlet
		implements DateFormatRpcService {

	
	private Calendar calendar = GregorianCalendar.getInstance();
	
	@Override
	public String format(DateParams params) {
		System.out.println("DateFormatRpcServiceImpl.format()");
		calendar.set(calendar.DAY_OF_MONTH, params.getDay());
		calendar.set(calendar.MONTH, params.getMonth() -1);
		calendar.set(calendar.YEAR, params.getYear());
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL,
				new Locale(params.getLocale()));
		String formatted = df.format(calendar.getTime());
		System.out.println(formatted);
		return formatted;
	}

}
