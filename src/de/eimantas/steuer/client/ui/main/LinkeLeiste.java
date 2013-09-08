package de.eimantas.steuer.client.ui.main;

import java.util.ArrayList;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.PlainTabPanel;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.info.Info;

import de.eimantas.steuer.client.control.presenter.LinkeLeisteIf;
import de.eimantas.steuer.client.ui.main.stack.StackDatum;
import de.eimantas.steuer.client.ui.resources.Images;
import de.eimantas.steuer.shared.model.KategoriesPOJO;

public class LinkeLeiste extends Composite implements LinkeLeisteIf {
	private PlainTabPanel panel;
	private TabItemConfig config;

	@Override
	public Widget asWidget() {
		VerticalPanel vp = new VerticalPanel();
		// vp.setSpacing(5);

		SelectionHandler<Widget> handler = new SelectionHandler<Widget>() {

			public void onSelection(SelectionEvent<Widget> event) {
				TabPanel panel = (TabPanel) event.getSource();
				Widget w = event.getSelectedItem();
				TabItemConfig config = panel.getConfig(w);
				Info.display("Message", "'" + config.getText() + "' Selected");
			}
		};

		panel = new PlainTabPanel();
		// panel.setPixelSize(450, 250);
		panel.setSize("300px", "700px");
		panel.addSelectionHandler(handler);

		// Label iconTab = new Label("Nach Datum");
		// iconTab.addStyleName("pad-text");

		config = new TabItemConfig("Datum");
		config.setIcon(Images.INSTANCE.datum());

		Label iconTabOrt = new Label("Nach Ort Sortiert");
		// iconTabOrt.addStyleName("pad-text");

		TabItemConfig configOrt = new TabItemConfig("Ort");
		configOrt.setIcon(Images.INSTANCE.auto());
		panel.add(iconTabOrt, configOrt);

		Label iconTabKoment = new Label("Nach Komentar");
		// iconTabKoment.addStyleName("pad-text");

		TabItemConfig configKom = new TabItemConfig("Komentar");
		configKom.setIcon(Images.INSTANCE.komment());
		panel.add(iconTabKoment, configKom);

		// Label disabled = new Label("This tab should be disabled");
		// disabled.addStyleName("pad-text");
		//
		// config = new TabItemConfig("Disabled");
		// config.setEnabled(false);
		// panel.add(disabled, config);

		vp.add(panel);
		return vp;
	}

	public void setKategories(ArrayList<KategoriesPOJO> result) {
		panel.add(new StackDatum(result).onInitialize(), config);

	}
}