package de.eimantas.steuer.client.ui.neu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import de.eimantas.steuer.client.control.presenter.NeuEintragViewInf;
import de.eimantas.steuer.client.ui.buttons.UIButton;
import de.eimantas.steuer.client.ui.resources.Images;

public class NeuEintragView extends Composite implements NeuEintragViewInf {
	private FormPanel form;
	private UIButton but;
	private VerticalPanel vPanel;
	private FileUpload fileUpload;

	public NeuEintragView() {
		form = new FormPanel();
		vPanel = new VerticalPanel();
		// http://google-web-toolkit.googlecode.com/svn/javadoc/latest/com/google/gwt/user/client/ui/FileUpload.html
		form.setMethod(FormPanel.METHOD_POST);
		// The HTTP request is encoded in multipart format.
		form.setEncoding(FormPanel.ENCODING_MULTIPART); // multipart MIME
														// encoding
		form.setAction("/FileUploadGreeting"); // The
												// servlet
												// FileUploadGreeting

		form.setWidget(vPanel);

		fileUpload = new FileUpload();
		fileUpload.setName("uploader"); // Very important
		vPanel.add(fileUpload);

		Label maxUpload = new Label();
		maxUpload.setText("Maximum upload file size: 1MB");
		vPanel.add(maxUpload);
		but = new UIButton("Submit", Images.INSTANCE.erfassen());
		but.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				form.submit();
				GWT.log(fileUpload.getFilename(), null);
			}
		});
		vPanel.add(but);

	}

	@Override
	public Widget asWidget() {
		return vPanel;
	}

	public HasClickHandlers getSubmittButton() {
		return but;
	}

	public void submit() {
	}
}
