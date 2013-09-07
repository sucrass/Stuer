package de.eimantas.steuer.client.control.presenter;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

public interface NeuEintragViewInf {

	Widget asWidget();

	HasClickHandlers getSubmittButton();

	void submit();

}
