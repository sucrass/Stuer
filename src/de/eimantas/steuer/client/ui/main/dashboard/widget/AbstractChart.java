package de.eimantas.steuer.client.ui.main.dashboard.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.fx.client.Draggable;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.Resizable;
import com.sencha.gxt.widget.core.client.Resizable.Dir;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.CollapseEvent;
import com.sencha.gxt.widget.core.client.event.CollapseEvent.CollapseHandler;
import com.sencha.gxt.widget.core.client.event.ExpandEvent;
import com.sencha.gxt.widget.core.client.event.ExpandEvent.ExpandHandler;

public abstract class AbstractChart implements IsWidget {
	public class DataModel {
		private int id;
		private String name;
		private double data;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getData() {
			return data;
		}

		public void setData(double data) {
			this.data = data;
		}
	}

	// Chart data model property access definitions
	public interface DataModelProperties extends PropertyAccess<DataModel> {
		ModelKeyProvider<DataModel> id();

		ValueProvider<DataModel, String> name();

		ValueProvider<DataModel, Double> data();
	}

	public static final DataModelProperties dataModelProperties = GWT
			.create(DataModelProperties.class);
	protected FramedPanel panel;
	protected VerticalLayoutContainer layout;

	public AbstractChart() {
		panel = new FramedPanel();
		panel.getElement().getStyle().setMargin(10, Unit.PX);
		panel.setCollapsible(true);
		panel.setHeadingText("Pie Chart");
		panel.setPixelSize(400, 400);
		panel.setBodyBorder(true);

		final Resizable resize = new Resizable(panel, Dir.E, Dir.SE, Dir.S);
		resize.setMinHeight(400);
		resize.setMinWidth(400);

		panel.addExpandHandler(new ExpandHandler() {
			public void onExpand(ExpandEvent event) {
				resize.setEnabled(true);
			}
		});
		panel.addCollapseHandler(new CollapseHandler() {
			public void onCollapse(CollapseEvent event) {
				resize.setEnabled(false);
			}
		});

		new Draggable(panel, panel.getHeader()).setUseProxy(false);

		layout = new VerticalLayoutContainer();
		panel.add(layout);
	}

	protected void addSomeData(ListStore<DataModel> listStore) {
		DataModel item1 = new DataModel();
		item1.setId(1);
		item1.setName("Sebastian");
		item1.setData(37);

		DataModel item2 = new DataModel();
		item2.setId(2);
		item2.setName("Patrick");
		item2.setData(54);

		DataModel item3 = new DataModel();
		item3.setId(3);
		item3.setName("Domi");
		item3.setData(29);

		DataModel item4 = new DataModel();
		item4.setId(4);
		item4.setName("Eimantas");
		item4.setData(12);

		listStore.add(item1);
		listStore.add(item2);
		listStore.add(item3);
		listStore.add(item4);
	}

	public abstract Widget asWidget();
}
