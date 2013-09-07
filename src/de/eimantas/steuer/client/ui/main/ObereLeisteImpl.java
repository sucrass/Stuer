package de.eimantas.steuer.client.ui.main;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.IsWidget;

public interface ObereLeisteImpl extends IsWidget {

	HasClickHandlers getAddButton();

	void setWidth(String string);

}
