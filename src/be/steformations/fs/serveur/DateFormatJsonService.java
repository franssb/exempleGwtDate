package be.steformations.fs.serveur;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.GregorianCalendar;

import be.steformations.fs.client.http.beans.DateParams;
import be.steformations.fs.client.http.beans.DateResult;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/json/service")		//equivalent à la déclaration dans le web.xml
public class DateFormatJsonService extends HttpServlet{


	private Calendar calendar = GregorianCalendar.getInstance();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("DateFormatJsonService.doPost()");
		
		com.fasterxml.jackson.databind.ObjectMapper mapper = new ObjectMapper();
		java.io.InputStream ips = req.getInputStream();
		DateParams params = mapper.readerFor(DateParams.class).readValue(ips);
		System.out.println(params);

		calendar.set(calendar.DAY_OF_MONTH, params.getDay());
		calendar.set(calendar.MONTH, params.getMonth() -1);
		calendar.set(calendar.YEAR, params.getYear());
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL,
				new Locale(params.getLocale()));
		String formatted = df.format(calendar.getTime());
		DateResult result =  new DateResult();
		result.setDate(calendar.getTime());
		result.setFormattedDate(formatted);
		
		String json = mapper.writeValueAsString(result);
		System.out.println(json);
		
		resp.setContentType("application/json");
		resp.getWriter().write(json);
	}
}
