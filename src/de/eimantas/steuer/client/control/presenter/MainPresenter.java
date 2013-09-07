package de.eimantas.steuer.client.control.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;

import de.eimantas.steuer.client.MainServiceAsync;
import de.eimantas.steuer.shared.event.AddEintragEvent;

public class MainPresenter implements Presenter {

	private MainServiceAsync rpcService;
	private HandlerManager eventBus;
	private MainDisplay display;

	public MainPresenter(MainServiceAsync rpcService, HandlerManager eventBus,
			MainDisplay mainView) {
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = mainView;
	}

	public void go(HasWidgets container) {
		bind();
		container.clear();
		container.add(display.asWidget());
		fetchData();
	}

	private void fetchData() {
		// TODO Auto-generated method stub

	}

	private void bind() {
		display.getAddButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new AddEintragEvent());
			}
		});
	}
}
