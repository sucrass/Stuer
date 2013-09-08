package de.eimantas.steuer.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.eimantas.steuer.shared.model.KategoriesPOJO;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface MainService extends RemoteService {
	String greetServer(String name) throws IllegalArgumentException;

	ArrayList<KategoriesPOJO> getKategories(int userId);
}
