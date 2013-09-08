package de.eimantas.steuer.client.ui.main.dashboard;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.eimantas.steuer.client.ui.main.dashboard.widget.AnderePie;
import de.eimantas.steuer.client.ui.main.dashboard.widget.BarChart;
import de.eimantas.steuer.client.ui.main.dashboard.widget.LineChart;
import de.eimantas.steuer.client.ui.main.dashboard.widget.ObersteDashboardWidget;
import de.eimantas.steuer.client.ui.main.dashboard.widget.PieChart;

public class Dashboard extends Composite {

	public Dashboard() {

		VerticalPanel hauptPanel = new VerticalPanel();
		initWidget(hauptPanel);

		HorizontalPanel ersteTier = new HorizontalPanel();
		ersteTier.add(new ObersteDashboardWidget());
		ersteTier.setSize("100%", "100%");
		hauptPanel.add(ersteTier);

		HorizontalPanel zweiteTier = new HorizontalPanel();

		zweiteTier.add(new PieChart().asWidget());
		zweiteTier.add(new LineChart().asWidget());
		zweiteTier.add(new AnderePie().asWidget());
		hauptPanel.add(zweiteTier);

		HorizontalPanel dritteTier = new HorizontalPanel();
		dritteTier.add(new BarChart().asWidget());
		hauptPanel.add(dritteTier);

	}

}
