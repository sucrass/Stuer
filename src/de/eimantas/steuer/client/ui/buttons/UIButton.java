package de.eimantas.steuer.client.ui.buttons;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.resources.client.ImageResource;
import com.sencha.gxt.widget.core.client.button.TextButton;

public class UIButton extends TextButton implements HasClickHandlers {

	public UIButton(String name, ImageResource icon) {
		super();
		this.setStyleName("leisteOben");
		this.setText(name);
		// this.setIcon(Images.INSTANCE.chrome());
		this.setIcon(icon);
	}

	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return addDomHandler(handler, ClickEvent.getType());
	}
}
