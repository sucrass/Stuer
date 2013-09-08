package de.eimantas.steuer.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.eimantas.steuer.shared.model.KategoriesPOJO;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface MainServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;

	void getKategories(int userId,
			AsyncCallback<ArrayList<KategoriesPOJO>> callback);
}
