package de.eimantas.steuer.client.ui.main.stack;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import de.eimantas.steuer.client.ui.resources.Images;
import de.eimantas.steuer.shared.model.KategoriesPOJO;

public class StackDatum extends Widget {

	private ArrayList<KategoriesPOJO> data;

	public StackDatum(ArrayList<KategoriesPOJO> result) {
		this.data = result;
	}

	public Widget onInitialize() {
		// Get the images.
		Images images = (Images) GWT.create(Images.class);

		// Create a new stack layout panel.
		StackLayoutPanel stackPanel = new StackLayoutPanel(Unit.EM);
		stackPanel.setPixelSize(200, 400);

		// Widget contactsHeader = createHeaderWidget("Reise Kosten",
		// Images.INSTANCE.pauschale());
		// stackPanel.add(createContactsItem(images), contactsHeader, 4);
		//
		// Widget arbeitHeader = createHeaderWidget("Arbeits Mittel",
		// Images.INSTANCE.arbeit());
		// stackPanel.add(createContactsItem(images), arbeitHeader, 4);
		//
		// Widget zimmerHeader = createHeaderWidget("Arbeits Zimmer",
		// Images.INSTANCE.zimmer());
		// stackPanel.add(createContactsItem(images), zimmerHeader, 4);
		//
		// Widget verlustHeader = createHeaderWidget("Verluste aus Kapital",
		// Images.INSTANCE.verlust());
		// stackPanel.add(createContactsItem(images), verlustHeader, 4);

		if (data != null) {
			for (KategoriesPOJO pojo : data) {

				ImageResource img = Images.INSTANCE.arbeit();
				if (pojo.getIcon() != null
						&& pojo.getIcon().equalsIgnoreCase("reise")) {
					img = Images.INSTANCE.pauschale();
				}

				Widget verlustHeader = createHeaderWidget(pojo.getKategorie(),
						img);
				stackPanel.add(createContactsItem(images), verlustHeader, 4);
				System.out.println("adding POJO");
			}
		} else {
			GWT.log("Keine DATA dazu!!!!", null);
		}

		// END OF Stack Items

		// Return the stack panel.
		stackPanel.ensureDebugId("cwStackLayoutPanel");
		return stackPanel;
	}

	/**
	 * Create the list of Contacts.
	 * 
	 * @param images
	 *            the {@link Images} used in the Contacts
	 * @return the list of contacts
	 */
	private Widget createContactsItem(Images images) {
		// Create a popup to show the contact info when a contact is clicked
		HorizontalPanel contactPopupContainer = new HorizontalPanel();
		contactPopupContainer.setSpacing(5);
		contactPopupContainer.add(new Image(Images.INSTANCE.auto()));
		final HTML contactInfo = new HTML();
		contactPopupContainer.add(contactInfo);
		final PopupPanel contactPopup = new PopupPanel(true, false);
		contactPopup.setWidget(contactPopupContainer);

		// Create the list of contacts
		VerticalPanel contactsPanel = new VerticalPanel();
		contactsPanel.setSpacing(4);
		String[] contactNames = { "eimantas", "domi", "seb", "patrick" };
		String[] contactEmails = { "eimantas", "domi", "seb", "patrick" };
		for (int i = 0; i < contactNames.length; i++) {
			final String contactName = contactNames[i];
			final String contactEmail = contactEmails[i];
			final Anchor contactLink = new Anchor(contactName);
			contactsPanel.add(contactLink);

			// Open the contact info popup when the user clicks a contact
			contactLink.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					// Set the info about the contact
					SafeHtmlBuilder sb = new SafeHtmlBuilder();
					sb.appendEscaped(contactName);
					sb.appendHtmlConstant("<br><i>");
					sb.appendEscaped(contactEmail);
					sb.appendHtmlConstant("</i>");
					contactInfo.setHTML(sb.toSafeHtml());

					// Show the popup of contact info
					int left = contactLink.getAbsoluteLeft() + 14;
					int top = contactLink.getAbsoluteTop() + 14;
					contactPopup.setPopupPosition(left, top);
					contactPopup.show();
				}
			});
		}
		return new SimplePanel(contactsPanel);
	}

	/**
	 * Create a widget to display in the header that includes an image and some
	 * text.
	 * 
	 * @param text
	 *            the header text
	 * @param image
	 *            the {@link ImageResource} to add next to the header
	 * @return the header widget
	 */
	private Widget createHeaderWidget(String text, ImageResource image) {
		// Add the image and text to a horizontal panel
		HorizontalPanel hPanel = new HorizontalPanel();
		hPanel.setHeight("100%");
		hPanel.setSpacing(0);
		hPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		hPanel.add(new Image(image));
		HTML headerText = new HTML(text);
		headerText.setStyleName("cw-StackPanelHeader");
		hPanel.add(headerText);
		return new SimplePanel(hPanel);
	}

}
