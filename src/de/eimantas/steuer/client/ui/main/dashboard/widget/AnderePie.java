package de.eimantas.steuer.client.ui.main.dashboard.widget;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
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
import com.sencha.gxt.chart.client.draw.sprite.TextSprite;
import com.sencha.gxt.chart.client.draw.sprite.TextSprite.TextAnchor;
import com.sencha.gxt.chart.client.draw.sprite.TextSprite.TextBaseline;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.StringLabelProvider;
import com.sencha.gxt.fx.client.Draggable;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.button.ToggleButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;

public class AnderePie extends AbstractChart {

	@Override
	public Widget asWidget() {
		final ListStore<DataModel> listStore = new ListStore<DataModel>(
				dataModelProperties.id());

		final Chart<DataModel> chart = new Chart<DataModel>();
		chart.setDefaultInsets(50);
		chart.setStore(listStore);
		chart.setShadowChart(true);

		Gradient slice1 = new Gradient("slice1", 45);
		slice1.addStop(new Stop(0, new RGB(148, 174, 10)));
		slice1.addStop(new Stop(100, new RGB(107, 126, 7)));
		chart.addGradient(slice1);

		Gradient slice2 = new Gradient("slice2", 45);
		slice2.addStop(new Stop(0, new RGB(17, 95, 166)));
		slice2.addStop(new Stop(100, new RGB(12, 69, 120)));
		chart.addGradient(slice2);

		Gradient slice3 = new Gradient("slice3", 45);
		slice3.addStop(new Stop(0, new RGB(166, 17, 32)));
		slice3.addStop(new Stop(100, new RGB(120, 12, 23)));
		chart.addGradient(slice3);

		final PieSeries<DataModel> series = new PieSeries<DataModel>();
		series.setAngleField(dataModelProperties.data());
		series.addColor(slice1);
		series.addColor(slice2);
		series.addColor(slice3);

		TextSprite textConfig = new TextSprite();
		textConfig.setFont("Arial");
		textConfig.setTextBaseline(TextBaseline.MIDDLE);
		textConfig.setFontSize(18);
		textConfig.setTextAnchor(TextAnchor.MIDDLE);
		textConfig.setZIndex(15);
		SeriesLabelConfig<DataModel> labelConfig = new SeriesLabelConfig<DataModel>();
		labelConfig.setSpriteConfig(textConfig);
		labelConfig.setLabelPosition(LabelPosition.START);
		labelConfig.setValueProvider(dataModelProperties.name(),
				new StringLabelProvider<String>());
		series.setLabelConfig(labelConfig);
		series.setHighlighting(true);
		series.setLegendValueProvider(dataModelProperties.name(),
				new LabelProvider<String>() {
					public String getLabel(String item) {
						return item.substring(0, 3);
					}
				});
		chart.addSeries(series);

		final Legend<DataModel> legend = new Legend<DataModel>();
		legend.setPosition(Position.RIGHT);
		legend.setItemHighlighting(true);
		legend.setItemHiding(true);
		chart.setLegend(legend);

		TextButton regenerate = new TextButton("Reload Data");
		regenerate.addSelectHandler(new SelectHandler() {

			public void onSelect(SelectEvent event) {
				listStore.clear();
				addSomeData(listStore);
				chart.redrawChart();
			}
		});

		ToggleButton donut = new ToggleButton("Donut");
		donut.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				if (event.getValue()) {
					series.setDonut(35);
				} else {
					series.setDonut(0);
				}
				chart.redrawChart();
			}
		});

		ToggleButton animation = new ToggleButton("Animate");
		animation.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				chart.setAnimated(event.getValue());
			}
		});
		animation.setValue(true, true);
		ToggleButton shadow = new ToggleButton("Shadow");
		shadow.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				chart.setShadowChart(event.getValue());
				chart.redrawChart();
			}
		});
		shadow.setValue(true);

		ToolBar toolBar = new ToolBar();
		toolBar.add(regenerate);
		toolBar.add(animation);
		toolBar.add(shadow);
		toolBar.add(donut);

		new Draggable(panel, panel.getHeader()).setUseProxy(false);
		addSomeData(listStore);
		VerticalLayoutContainer layout = new VerticalLayoutContainer();
		panel.add(layout);

		toolBar.setLayoutData(new VerticalLayoutData(1, -1));
		layout.add(toolBar);

		chart.setLayoutData(new VerticalLayoutData(1, 1));
		layout.add(chart);

		return panel;
	}

}
