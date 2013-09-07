package de.eimantas.steuer.client.ui.main;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.eimantas.steuer.client.ui.main.dashboard.Dashboard;

public class MainView extends Composite {
	public MainView() {
		super();
		VerticalPanel mainLayout = new VerticalPanel();
		initWidget(mainLayout);
		mainLayout.setSize("100%", "100%");
		Button b = new Button();

		HorizontalPanel obereLayout = new HorizontalPanel();
		obereLayout.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		obereLayout.setSpacing(5);
		mainLayout.add(obereLayout);
		obereLayout.setSize("100%", "15px");

		ObereLeiste obereLeiste = new ObereLeiste();
		obereLayout.add(obereLeiste);
		obereLeiste.setWidth("100%");

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		mainLayout.add(horizontalPanel_2);
		horizontalPanel_2.setSize("100%", "100%");
		mainLayout.setCellHeight(horizontalPanel_2, "100%");
		mainLayout.setCellWidth(horizontalPanel_2, "100%");

		HorizontalPanel mainDynContainer = new HorizontalPanel();

		mainDynContainer.setSize("100%", "100%");

		VerticalPanel linkeLeiste = new VerticalPanel();

		linkeLeiste.add(new LinkeLeiste().asWidget());

		horizontalPanel_2.add(linkeLeiste);
		horizontalPanel_2.add(mainDynContainer);
		VerticalPanel verticalPanel_1 = new VerticalPanel();
		mainDynContainer.add(verticalPanel_1);
		verticalPanel_1.setSize("100%", "100%");
		mainDynContainer.setCellHeight(verticalPanel_1, "100%");
		mainDynContainer.setCellWidth(verticalPanel_1, "100%");

		verticalPanel_1.add(new Dashboard());

		VerticalPanel untereLeiste = new VerticalPanel();
		untereLeiste
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		mainLayout.add(untereLeiste);
		mainLayout.setCellHorizontalAlignment(untereLeiste,
				HasHorizontalAlignment.ALIGN_CENTER);

		Label copy = new Label("Copyright (c) 2013 SSF GMBH");
		untereLeiste.add(copy);

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		untereLeiste.add(horizontalPanel);

		Hyperlink hprlnkNewHyperlink = new Hyperlink("Sitemap", false,
				"newHistoryToken");
		hprlnkNewHyperlink.setHTML("Sitemap");
		horizontalPanel.add(hprlnkNewHyperlink);

		Label lblNewLabel = new Label("|");
		horizontalPanel.add(lblNewLabel);

		Hyperlink hprlnkNutzungsbedingungen = new Hyperlink(
				"Nutzungsbedingungen", false, "newHistoryToken");
		horizontalPanel.add(hprlnkNutzungsbedingungen);

		Label label = new Label("|");
		horizontalPanel.add(label);

		Hyperlink hprlnkDatenschutz = new Hyperlink("Datenschutz", false,
				"newHistoryToken");
		hprlnkDatenschutz.setHTML("Datenschutz");
		horizontalPanel.add(hprlnkDatenschutz);
	}
}
