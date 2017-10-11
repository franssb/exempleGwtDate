package be.steformations.fs.serveur;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AvailableLocalesServlet extends HttpServlet{

	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AvailableLocalesServlet.doGet()");
		Locale[] locales = Locale.getAvailableLocales();
		StringBuilder sb = new StringBuilder();
		for (Locale locale : locales) {
			sb.append(locale.getLanguage()).append(",");
		}
		
		resp.setContentType("text/plain");
		resp.getWriter().write(sb.substring(0,sb.length()-1));
	}
}
