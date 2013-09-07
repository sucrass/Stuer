package de.eimantas.steuer.client.ui.main;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainView extends Composite {
	public MainView() {
		super();
		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		verticalPanel.setSize("100%", "100%");
		Button b = new Button();

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel.setSpacing(5);
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setSize("100%", "15px");

		ObereLeiste obereLeiste = new ObereLeiste();
		horizontalPanel.add(obereLeiste);
		obereLeiste.setWidth("100%");

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_2);
		horizontalPanel_2.setSize("100%", "100%");
		verticalPanel.setCellHeight(horizontalPanel_2, "100%");
		verticalPanel.setCellWidth(horizontalPanel_2, "100%");

		HorizontalPanel horizontalPanel_3 = new HorizontalPanel();
		horizontalPanel_2.add(horizontalPanel_3);
		horizontalPanel_3.setSize("100%", "100%");

		VerticalPanel verticalPanel_2 = new VerticalPanel();

		verticalPanel_2.add(new LinkeLeiste().asWidget());

		horizontalPanel_2.add(verticalPanel_2);

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
