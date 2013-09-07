package de.eimantas.steuer.client.ui.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface Images extends ClientBundle {

	public Images INSTANCE = GWT.create(Images.class);

	@Source("offene.png")
	ImageResource offene();

	@Source("einstellung.png")
	ImageResource einstellung();

	@Source("erfassen.png")
	ImageResource erfassen();

	@Source("home.png")
	ImageResource home();

}