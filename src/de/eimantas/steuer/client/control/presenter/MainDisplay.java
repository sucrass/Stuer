package de.eimantas.steuer.client.control.presenter;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

import de.eimantas.steuer.client.ui.main.dashboard.widget.AbstractChart.DataModel;

public interface MainDisplay {
	HasClickHandlers getAddButton();

	List<DataModel> getList();

	void addLinkeLeiste(Widget w);

	void setData(List<DataModel> data);

	int getClickedRow(ClickEvent event);

	Widget asWidget();
}
