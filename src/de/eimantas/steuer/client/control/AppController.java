package de.eimantas.steuer.client.control;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

import de.eimantas.steuer.client.MainServiceAsync;
import de.eimantas.steuer.client.control.presenter.ErfassenPresenter;
import de.eimantas.steuer.client.control.presenter.LinkeLeisteIf;
import de.eimantas.steuer.client.control.presenter.MainPresenter;
import de.eimantas.steuer.client.control.presenter.Presenter;
import de.eimantas.steuer.client.ui.main.LinkeLeiste;
import de.eimantas.steuer.client.ui.main.MainView;
import de.eimantas.steuer.client.ui.neu.NeuEintragView;
import de.eimantas.steuer.shared.event.AddEintragEvent;
import de.eimantas.steuer.shared.event.AddEintragEventHandler;

public class AppController implements Presenter, ValueChangeHandler<String> {

	private MainServiceAsync rpcService;
	private HandlerManager eventBus;
	private HasWidgets container;
	private MainView mainView;
	private LinkeLeisteIf linkeLeiste;

	public AppController(MainServiceAsync rpcService, HandlerManager eventBus) {
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		bind();
	}

	private void bind() {
		History.addValueChangeHandler(this);

		eventBus.addHandler(AddEintragEvent.TYPE, new AddEintragEventHandler() {

			@Override
			public void onAddEintrag(AddEintragEvent event) {
				History.newItem("neu");
			}
		});

	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();

		if (token != null) {
			Presenter presenter = null;

			if (token.equals("dash")) {
				if (mainView == null) {
					mainView = new MainView();
				}

				if (linkeLeiste == null) {
					linkeLeiste = new LinkeLeiste();
				}
				presenter = new MainPresenter(rpcService, eventBus, mainView,
						linkeLeiste);
				presenter.go(container);
			} else if (token.equals("neu")) {
				if (mainView != null) {
					presenter = new ErfassenPresenter(rpcService, eventBus,
							new NeuEintragView());
					presenter.go(mainView.getDynContainer());
				} else {
					GWT.log("No Container zum Anzeigen", null);
				}
			}
			// else if (token.equals("add")) {
			// presenter = new EditContactPresenter(rpcService, eventBus,
			// new EditContactView());
			// } else if (token.equals("edit")) {
			// presenter = new EditContactPresenter(rpcService, eventBus,
			// new EditContactView());
			// }

		}

	}

	@Override
	public void go(HasWidgets container) {
		this.container = container;

		if ("".equals(History.getToken())) {
			History.newItem("dash");
		} else {
			History.fireCurrentHistoryState();
		}

	}

}
