package de.eimantas.steuer.client.ui.neu;

import gwtupload.client.IUploadStatus.Status;
import gwtupload.client.IUploader;
import gwtupload.client.IUploader.UploadedInfo;
import gwtupload.client.MultiUploader;
import gwtupload.client.PreloadedImage;
import gwtupload.client.PreloadedImage.OnLoadPreloadedImageHandler;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

import de.eimantas.steuer.client.control.presenter.NeuEintragViewInf;
import de.eimantas.steuer.client.ui.buttons.UIButton;
import de.eimantas.steuer.client.ui.resources.Images;

public class NeuEintragView extends Composite implements NeuEintragViewInf {

	private UIButton but = new UIButton("test", Images.INSTANCE.arbeit());

	private FlowPanel panelImages;
	private MultiUploader defaultUploader;

	public NeuEintragView() {
		panelImages = new FlowPanel();
		// Create a new uploader panel and attach it to the document
		defaultUploader = new MultiUploader();

		// Add a finish handler which will load the image once the upload
		// finishes
		defaultUploader.addOnFinishUploadHandler(onFinishUploaderHandler);
		// Load the image in the document and in the case of success attach it
		// to the viewer

	}

	private IUploader.OnFinishUploaderHandler onFinishUploaderHandler = new IUploader.OnFinishUploaderHandler() {
		public void onFinish(IUploader uploader) {
			if (uploader.getStatus() == Status.SUCCESS) {

				new PreloadedImage(uploader.fileUrl(), showImage);

				// The server sends useful information to the client by default
				UploadedInfo info = uploader.getServerInfo();
				System.out.println("File name " + info.name);
				System.out.println("File content-type " + info.ctype);
				System.out.println("File content-type " + info.key);
				System.out.println("File size " + info.size);

				// You can send any customized message and parse it
				System.out.println("Server message " + info.message);
			}
		}
	};

	// Attach an image to the pictures viewer
	private OnLoadPreloadedImageHandler showImage = new OnLoadPreloadedImageHandler() {
		public void onLoad(PreloadedImage image) {
			image.setWidth("75px");
			panelImages.add(image);
		}
	};

	@Override
	public Widget asWidget() {
		return defaultUploader;
	}

	public HasClickHandlers getSubmittButton() {
		return but;
	}

	public void submit() {
	}
}
