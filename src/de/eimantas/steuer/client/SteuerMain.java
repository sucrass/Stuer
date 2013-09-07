package de.eimantas.steuer.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;

import de.eimantas.steuer.client.control.AppController;

public class SteuerMain implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		MainServiceAsync rpcService = GWT.create(MainService.class);
		HandlerManager eventBus = new HandlerManager(null);
		AppController appViewer = new AppController(rpcService, eventBus);
		appViewer.go(RootPanel.get());

	}
}
