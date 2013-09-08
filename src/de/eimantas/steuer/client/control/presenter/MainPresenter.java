package de.eimantas.steuer.client.control.presenter;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

import de.eimantas.steuer.client.MainServiceAsync;
import de.eimantas.steuer.shared.event.AddEintragEvent;
import de.eimantas.steuer.shared.model.KategoriesPOJO;

public class MainPresenter implements Presenter {

	private MainServiceAsync rpcService;
	private HandlerManager eventBus;
	private MainDisplay display;
	private LinkeLeisteIf linkeLeiste;

	public MainPresenter(MainServiceAsync rpcService, HandlerManager eventBus,
			MainDisplay mainView, LinkeLeisteIf leiste) {
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = mainView;
		this.linkeLeiste = leiste;
	}

	@Override
	public void go(HasWidgets container) {
		bind();
		container.clear();
		container.add(display.asWidget());
		display.addLinkeLeiste(linkeLeiste.asWidget());
		fetchData();
	}

	private void fetchData() {
		getKategories();
	}

	private void getKategories() {
		rpcService.getKategories(1,
				new AsyncCallback<ArrayList<KategoriesPOJO>>() {

					@Override
					public void onSuccess(ArrayList<KategoriesPOJO> result) {
						linkeLeiste.setKategories(result);
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO
					}
				});
	}

	private void bind() {
		display.getAddButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new AddEintragEvent());
			}
		});
	}
}
