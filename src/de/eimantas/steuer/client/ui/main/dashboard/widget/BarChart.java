package de.eimantas.steuer.client.ui.main.dashboard.widget;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.chart.client.chart.Chart;
import com.sencha.gxt.chart.client.chart.Chart.Position;
import com.sencha.gxt.chart.client.chart.axis.CategoryAxis;
import com.sencha.gxt.chart.client.chart.axis.NumericAxis;
import com.sencha.gxt.chart.client.chart.series.BarSeries;
import com.sencha.gxt.chart.client.chart.series.SeriesHighlighter;
import com.sencha.gxt.chart.client.chart.series.SeriesLabelConfig;
import com.sencha.gxt.chart.client.chart.series.SeriesRenderer;
import com.sencha.gxt.chart.client.draw.Color;
import com.sencha.gxt.chart.client.draw.DrawFx;
import com.sencha.gxt.chart.client.draw.Gradient;
import com.sencha.gxt.chart.client.draw.RGB;
import com.sencha.gxt.chart.client.draw.path.PathSprite;
import com.sencha.gxt.chart.client.draw.sprite.Sprite;
import com.sencha.gxt.chart.client.draw.sprite.TextSprite;
import com.sencha.gxt.chart.client.draw.sprite.TextSprite.TextAnchor;
import com.sencha.gxt.chart.client.draw.sprite.TextSprite.TextBaseline;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.fx.client.easing.BounceOut;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.button.ToggleButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;

public class BarChart extends AbstractChart {

	@Override
	public Widget asWidget() {
		final Chart<DataModel> chart = new Chart<DataModel>();
		chart.setBackground(new RGB(17, 17, 17));
		chart.setAnimationDuration(750);
		chart.setAnimationEasing(new BounceOut());
		chart.setShadowChart(true);

		final ListStore<DataModel> listStore = new ListStore<DataModel>(
				dataModelProperties.id());

		chart.setStore(listStore);

		NumericAxis<DataModel> axis = new NumericAxis<DataModel>();
		axis.setPosition(Position.LEFT);
		axis.addField(dataModelProperties.data());
		PathSprite grid = new PathSprite();
		grid.setStroke(RGB.WHITE);
		axis.setGridDefaultConfig(grid);
		TextSprite title = new TextSprite("Number of Hits");
		title.setFontSize(18);
		title.setFill(RGB.WHITE);
		axis.setTitleConfig(title);
		axis.setDisplayGrid(true);
		PathSprite white = new PathSprite();
		white.setStroke(RGB.WHITE);
		axis.setAxisConfig(white);
		TextSprite whiteText = new TextSprite();
		whiteText.setFill(RGB.WHITE);
		whiteText.setTextBaseline(TextBaseline.MIDDLE);
		axis.setLabelConfig(whiteText);
		axis.setMinimum(0);
		axis.setMaximum(100);
		chart.addAxis(axis);

		CategoryAxis<DataModel, String> catAxis = new CategoryAxis<DataModel, String>();
		catAxis.setPosition(Position.BOTTOM);
		catAxis.setField(dataModelProperties.name());
		title = new TextSprite("Month of the Year");
		title.setFontSize(18);
		title.setFill(RGB.WHITE);
		catAxis.setTitleConfig(title);
		catAxis.setAxisConfig(white);
		whiteText = whiteText.copy();
		whiteText.setTextAnchor(TextAnchor.MIDDLE);
		catAxis.setLabelConfig(whiteText);
		chart.addAxis(catAxis);

		Gradient grad1 = new Gradient("v-1", 0);
		grad1.addStop(0, new RGB(212, 40, 40));
		grad1.addStop(100, new RGB(117, 14, 14));
		chart.addGradient(grad1);
		Gradient grad2 = new Gradient("v-2", 0);
		grad2.addStop(0, new RGB(180, 216, 42));
		grad2.addStop(100, new RGB(94, 114, 13));
		chart.addGradient(grad2);
		Gradient grad3 = new Gradient("v-3", 0);
		grad3.addStop(0, new RGB(43, 221, 115));
		grad3.addStop(100, new RGB(14, 117, 56));
		chart.addGradient(grad3);

		final Color[] colors = { grad1, grad2, grad3 };

		final BarSeries<DataModel> column = new BarSeries<DataModel>();
		column.setYAxisPosition(Position.LEFT);
		column.addYField(dataModelProperties.data());
		TextSprite sprite = new TextSprite();
		sprite.setFill(RGB.WHITE);
		sprite.setFontSize(18);
		sprite.setTextAnchor(TextAnchor.MIDDLE);
		SeriesLabelConfig<DataModel> labelConfig = new SeriesLabelConfig<DataModel>();
		labelConfig.setSpriteConfig(sprite);
		column.setLabelConfig(labelConfig);
		column.setColumn(true);
		column.setHighlighting(true);
		column.setRenderer(new SeriesRenderer<DataModel>() {
			public void spriteRenderer(Sprite sprite, int index,
					ListStore<DataModel> store) {
				sprite.setFill(colors[index % colors.length]);
				sprite.redraw();
			}
		});
		column.setHighlighter(new SeriesHighlighter() {

			public void highlight(Sprite sprite) {
				sprite.setStroke(new RGB(85, 85, 204));
				DrawFx.createStrokeWidthAnimator(sprite, 3).run(250);
			}

			public void unHighlight(Sprite sprite) {
				sprite.setStroke(Color.NONE);
				DrawFx.createStrokeWidthAnimator(sprite, 0).run(250);
			}
		});
		chart.addSeries(column);

		TextButton regenerate = new TextButton("Reload Data");
		regenerate.addSelectHandler(new SelectHandler() {

			public void onSelect(SelectEvent event) {
				listStore.clear();
				addSomeData(listStore);
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
		addSomeData(listStore);
		chart.setLayoutData(new VerticalLayoutData(1, 1));
		layout.add(chart);
		panel.setPixelSize(1200, 300);
		return panel;
	}
}
