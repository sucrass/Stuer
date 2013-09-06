package de.eimantas.steuer.client.ui.main;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainView extends Composite {
	public MainView() {

		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel.setSpacing(5);
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setWidth("100%");

		Hyperlink hprlnkSettings = new Hyperlink("Settings", false,
				"newHistoryToken");
		hprlnkSettings.setHTML("Fotos");
		horizontalPanel.add(hprlnkSettings);

		Hyperlink hprlnkKategorien = new Hyperlink("Kategorien", false,
				"newHistoryToken");
		horizontalPanel.add(hprlnkKategorien);

		Hyperlink hyperlink = new Hyperlink("Kategorien", false,
				"newHistoryToken");
		hyperlink.setHTML("Sonstiges");
		horizontalPanel.add(hyperlink);

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		horizontalPanel_1.setSpacing(10);
		horizontalPanel.add(horizontalPanel_1);
		horizontalPanel.setCellHorizontalAlignment(horizontalPanel_1,
				HasHorizontalAlignment.ALIGN_RIGHT);

		Image image = new Image((String) null);
		horizontalPanel_1.add(image);
		image.setSize("30px", "30px");

		Button btnNewButton = new Button("Settings");
		horizontalPanel_1.add(btnNewButton);

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_2);
		horizontalPanel_2.setSize("100%", "100%");
		verticalPanel.setCellHeight(horizontalPanel_2, "100%");
		verticalPanel.setCellWidth(horizontalPanel_2, "100%");

		HorizontalPanel horizontalPanel_3 = new HorizontalPanel();
		horizontalPanel_2.add(horizontalPanel_3);
		horizontalPanel_3.setSize("100%", "100%");

		VerticalPanel verticalPanel_2 = new VerticalPanel();
		horizontalPanel_3.add(verticalPanel_2);
		verticalPanel_2.setSize("", "100%");

		Button btnNachDatum = new Button("Nach Datum");
		verticalPanel_2.add(btnNachDatum);

		Button btnNachOrt = new Button("Nach Ort");
		verticalPanel_2.add(btnNachOrt);

		Button btnNachKategorie = new Button("Nach Kategorie");
		verticalPanel_2.add(btnNachKategorie);

		Button btnNachKommentar = new Button("Nach Kommentar");
		verticalPanel_2.add(btnNachKommentar);

		Button btnUnbekante = new Button("Unbekannte");
		verticalPanel_2.add(btnUnbekante);

		VerticalPanel verticalPanel_1 = new VerticalPanel();
		horizontalPanel_3.add(verticalPanel_1);
		verticalPanel_1.setSize("100%", "100%");
		horizontalPanel_3.setCellHeight(verticalPanel_1, "100%");
		horizontalPanel_3.setCellWidth(verticalPanel_1, "100%");

		CellTable<Object> cellTable = new CellTable<Object>();
		verticalPanel_1.add(cellTable);
		cellTable.setSize("100%", "100%");
	}

}
