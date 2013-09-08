package de.eimantas.steuer.client.control.presenter;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.Widget;

import de.eimantas.steuer.shared.model.KategoriesPOJO;

public interface LinkeLeisteIf {

	void setKategories(ArrayList<KategoriesPOJO> result);

	Widget asWidget();

}
