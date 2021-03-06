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

	@Source("car.png")
	ImageResource auto();

	@Source("date.png")
	ImageResource datum();

	@Source("comment.png")
	ImageResource komment();

	@Source("arrow_join.png")
	ImageResource pauschale();

	@Source("money_dollar.png")
	ImageResource geld();

	@Source("arbeit.png")
	ImageResource arbeit();

	@Source("chart_curve.png")
	ImageResource verlust();

	@Source("house_link.png")
	ImageResource zimmer();

}