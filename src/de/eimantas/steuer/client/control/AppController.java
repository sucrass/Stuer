package de.eimantas.steuer.client.control;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

import de.eimantas.steuer.client.MainServiceAsync;
import de.eimantas.steuer.client.control.presenter.MainPresenter;
import de.eimantas.steuer.client.control.presenter.Presenter;
import de.eimantas.steuer.client.ui.main.MainView;
import de.eimantas.steuer.shared.event.AddEintragEvent;
import de.eimantas.steuer.shared.event.AddEintragEventHandler;

public class AppController implements Presenter, ValueChangeHandler<String> {

	private MainServiceAsync rpcService;
	private HandlerManager eventBus;
	private HasWidgets container;

	public AppController(MainServiceAsync rpcService, HandlerManager eventBus) {
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		bind();
	}

	private void bind() {
		History.addValueChangeHandler(this);

		eventBus.addHandler(AddEintragEvent.TYPE, new AddEintragEventHandler() {

			public void onAddEintrag(AddEintragEvent event) {
				History.newItem("neu");
			}
		});

	}

	public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();

		if (token != null) {
			Presenter presenter = null;

			if (token.equals("dash")) {
				presenter = new MainPresenter(rpcService, eventBus,
						new MainView());
			} else if (token.equals("neu")) {
				System.out.println("Fick Dich!");
			}
			// else if (token.equals("add")) {
			// presenter = new EditContactPresenter(rpcService, eventBus,
			// new EditContactView());
			// } else if (token.equals("edit")) {
			// presenter = new EditContactPresenter(rpcService, eventBus,
			// new EditContactView());
			// }
			if (presenter != null) {
				presenter.go(container);
			}

		}

	}

	public void go(HasWidgets container) {
		this.container = container;

		if ("".equals(History.getToken())) {
			History.newItem("dash");
		} else {
			History.fireCurrentHistoryState();
		}

	}

}
