package de.eimantas.steuer.client.control.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;

import de.eimantas.steuer.client.MainServiceAsync;

public class ErfassenPresenter implements Presenter {

	private MainServiceAsync rpcService;
	private HandlerManager eventBus;
	private NeuEintragViewInf display;

	public ErfassenPresenter(MainServiceAsync rpcService,
			HandlerManager eventBus, NeuEintragViewInf neuEintragView) {
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = neuEintragView;
	}

	public void go(HasWidgets container) {

		bind();
		container.clear();
		container.add(display.asWidget());
		// fetchData();
	}

	private void bind() {
		display.getSubmittButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				submittToServer();
			}

		});
	}

	protected void submittToServer() {
		display.submit();
	}

}
