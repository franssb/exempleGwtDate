package be.steformations.fs.client.http.beans;

import java.io.Serializable;
import java.util.Date;

public class DateResult implements Serializable {

	
	private Date date;
	private String formattedDate;
	
	public Date getDate() {
		return date;
	}
	public String getFormattedDate() {
		return formattedDate;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setFormattedDate(String formattedDate) {
		this.formattedDate = formattedDate;
	}
}
