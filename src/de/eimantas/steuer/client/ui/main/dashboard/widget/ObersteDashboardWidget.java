package de.eimantas.steuer.client.ui.main.dashboard.widget;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ObersteDashboardWidget extends Composite {

	public ObersteDashboardWidget() {

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(4);
		horizontalPanel.setStyleName("rahmen");
		initWidget(horizontalPanel);
		horizontalPanel.setWidth("100%");

		VerticalPanel linkeTeil = new VerticalPanel();
		linkeTeil.setStyleName("rahmen");
		linkeTeil.setSpacing(5);
		horizontalPanel.add(linkeTeil);
		horizontalPanel.setCellHeight(linkeTeil, "80px");
		linkeTeil.setHeight("80px");

		Label lblDatum = new Label("Datum : 16.8.2013 , 22:55 Uhr");
		lblDatum.setStyleName("red");
		linkeTeil.add(lblDatum);

		Label lblBalanz = new Label("Balanz : 8.225,13 EUR");
		lblBalanz.setStyleName("balanz");
		linkeTeil.add(lblBalanz);

		HorizontalPanel untereErste = new HorizontalPanel();
		untereErste.setSpacing(10);
		linkeTeil.add(untereErste);

		Label label = new Label("0,00%");
		label.setStyleName("fettig");
		untereErste.add(label);

		Label label_1 = new Label("[0,00]");
		untereErste.add(label_1);

		VerticalPanel mitlereTeil = new VerticalPanel();
		mitlereTeil.setStyleName("rahmen");
		mitlereTeil.setSpacing(5);
		horizontalPanel.add(mitlereTeil);
		mitlereTeil.setHeight("80px");
		horizontalPanel.setCellHeight(mitlereTeil, "80px");

		Label lblEnthalteneWerte = new Label("Enthaltene Werte");
		lblEnthalteneWerte.setStyleName("norm");
		mitlereTeil.add(lblEnthalteneWerte);

		Label label_3 = new Label("30");
		label_3.setStyleName("fettig");
		mitlereTeil.add(label_3);

		Label lblTagesvol = new Label("Tages-Vol.:");
		mitlereTeil.add(lblTagesvol);

		Label label_2 = new Label("----");
		mitlereTeil.add(label_2);

		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setStyleName("rahmen");
		verticalPanel.setSpacing(5);
		horizontalPanel.add(verticalPanel);
		verticalPanel.setHeight("80px");
		horizontalPanel.setCellHeight(verticalPanel, "80px");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_1);

		Label lblTyp = new Label("Typ:");
		horizontalPanel_1.add(lblTyp);

		Label lblIndex = new Label("Index");
		lblIndex.setStyleName("fettig");
		horizontalPanel_1.add(lblIndex);

		Label lblBrseLt = new Label("B\u00F6rse : LT CommerzBank");
		verticalPanel.add(lblBrseLt);

	}

}
