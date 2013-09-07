package de.eimantas.steuer.client.ui.main;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;

import de.eimantas.steuer.client.ui.buttons.UIButton;
import de.eimantas.steuer.client.ui.resources.Images;

public class ObereLeiste extends Composite implements ObereLeisteImpl {
	private UIButton button_1;

	public ObereLeiste() {

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setStyleName("leisteOben");
		initWidget(horizontalPanel);
		horizontalPanel.setSize("", "5%");

		UIButton button = new UIButton("Home", Images.INSTANCE.home());
		horizontalPanel.add(button);

		button_1 = new UIButton("Erfassen", Images.INSTANCE.erfassen());
		horizontalPanel.add(button_1);

		UIButton button_2 = new UIButton("Offene", Images.INSTANCE.offene());
		horizontalPanel.add(button_2);

		UIButton button_3 = new UIButton("Einstellung",
				Images.INSTANCE.einstellung());
		horizontalPanel.add(button_3);

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel.add(horizontalPanel_1);
		horizontalPanel_1.setWidth("100%");
	}

	public HasClickHandlers getAddButton() {
		return button_1;
	}

}
