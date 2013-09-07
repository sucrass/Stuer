package de.eimantas.steuer.client.ui.main.dashboard.widget;

import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.chart.client.chart.Chart;
import com.sencha.gxt.chart.client.chart.Chart.Position;
import com.sencha.gxt.chart.client.chart.Legend;
import com.sencha.gxt.chart.client.chart.series.PieSeries;
import com.sencha.gxt.chart.client.chart.series.Series.LabelPosition;
import com.sencha.gxt.chart.client.chart.series.SeriesLabelConfig;
import com.sencha.gxt.chart.client.draw.Gradient;
import com.sencha.gxt.chart.client.draw.RGB;
import com.sencha.gxt.chart.client.draw.Stop;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.StringLabelProvider;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;

public class PieChart extends AbstractChart {

	private Chart<DataModel> chart;

	@Override
	public Widget asWidget() {
		final ListStore<DataModel> listStore = new ListStore<DataModel>(
				dataModelProperties.id());

		// Setup the chart
		chart = new Chart<DataModel>();
		chart.setStore(listStore);

		// Set the chart legend
		Legend<DataModel> legend = new Legend<DataModel>();
		legend.setPosition(Position.RIGHT);
		legend.setItemHighlighting(true);
		legend.setItemHiding(true);
		chart.setLegend(legend);

		// Setup series slice colors
		Gradient slice1 = new Gradient("slice1", 45);
		slice1.addStop(new Stop(0, new RGB(148, 174, 10)));
		slice1.addStop(new Stop(100, new RGB(107, 126, 7)));
		chart.addGradient(slice1);
		Gradient slice2 = new Gradient("slice2", 45);
		slice2.addStop(new Stop(0, new RGB(17, 95, 166)));
		slice2.addStop(new Stop(100, new RGB(12, 69, 120)));
		chart.addGradient(slice2);

		// Setup the chart series
		PieSeries<DataModel> series = new PieSeries<DataModel>();
		series.setAngleField(dataModelProperties.data());
		series.setDonut(50);
		series.addColor(slice1);
		series.addColor(slice2);

		// Setup the label config
		SeriesLabelConfig<DataModel> labelConfig = new SeriesLabelConfig<DataModel>();
		labelConfig.setLabelPosition(LabelPosition.START);
		labelConfig.setValueProvider(dataModelProperties.name(),
				new StringLabelProvider<String>());
		series.setLabelConfig(labelConfig);

		// Setup the legend label config
		series.setLegendValueProvider(dataModelProperties.name(),
				new LabelProvider<String>() {
					public String getLabel(String item) {
						return item.substring(0, 3);
					}
				});
		chart.addSeries(series);

		chart.setLayoutData(new VerticalLayoutData(1, 1));
		layout.add(chart);
		addSomeData(listStore);
		return panel;
	}

}
