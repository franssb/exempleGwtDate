package be.steformations.fs.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.ibm.icu.text.DateFormat;

import be.steformations.fs.client.ui.material.DateFormatterMaterial;

public class DateFormatEntryPoint implements EntryPoint {

	@Override
	public void onModuleLoad() {
		DateFormatterMaterial ui = new DateFormatterMaterial();
		new DateFormatController(ui);
		RootLayoutPanel.get().add(ui);
	}

}
