package de.eimantas.steuer.client.ui.main;

import com.google.gwt.resources.client.ImageResource;
import com.sencha.gxt.widget.core.client.button.TextButton;

public class UIButton extends TextButton {

	public UIButton(String name, ImageResource icon) {
		super();
		this.setStyleName("leisteOben");
		this.setText(name);
		// this.setIcon(Images.INSTANCE.chrome());
		this.setIcon(icon);
	}
}
