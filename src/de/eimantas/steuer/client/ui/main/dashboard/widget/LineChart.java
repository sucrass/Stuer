package de.eimantas.steuer.client.ui.main.dashboard.widget;

import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.chart.client.chart.Chart;
import com.sencha.gxt.chart.client.chart.Chart.Position;
import com.sencha.gxt.chart.client.chart.axis.CategoryAxis;
import com.sencha.gxt.chart.client.chart.axis.NumericAxis;
import com.sencha.gxt.chart.client.chart.series.BarSeries;
import com.sencha.gxt.chart.client.draw.RGB;
import com.sencha.gxt.chart.client.draw.sprite.TextSprite;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.fx.client.Draggable;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;

public class LineChart extends AbstractChart {

	@Override
	public Widget asWidget() {
		Chart<DataModel> chart = new Chart<DataModel>();
		chart.setDefaultInsets(50);
		final ListStore<DataModel> listStore = new ListStore<DataModel>(
				dataModelProperties.id());
		chart.setStore(listStore);
		chart.setShadowChart(true);

		NumericAxis<DataModel> axis = new NumericAxis<DataModel>();
		axis.setPosition(Position.BOTTOM);
		axis.addField(dataModelProperties.data());
		TextSprite title = new TextSprite("Data");
		title.setFontSize(18);
		axis.setTitleConfig(title);
		axis.setDisplayGrid(true);
		axis.setMinimum(0);
		// axis.setMaximum(30);
		chart.addAxis(axis);

		CategoryAxis<DataModel, String> catAxis = new CategoryAxis<DataModel, String>();
		catAxis.setPosition(Position.LEFT);
		catAxis.setField(dataModelProperties.name());
		title = new TextSprite("Name");
		title.setFontSize(18);
		catAxis.setTitleConfig(title);
		chart.addAxis(catAxis);

		final BarSeries<DataModel> bar = new BarSeries<DataModel>();
		bar.setYAxisPosition(Position.BOTTOM);
		bar.addYField(dataModelProperties.data());
		bar.addColor(new RGB(148, 174, 10));
		bar.setHighlighting(true);
		chart.addSeries(bar);

		new Draggable(panel, panel.getHeader()).setUseProxy(false);
		addSomeData(listStore);
		chart.setLayoutData(new VerticalLayoutData(1, 1));

		panel.add(chart);

		return panel;
	}

}