package de.eimantas.steuer.server;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.eimantas.steuer.client.MainService;
import de.eimantas.steuer.server.model.Kategorie;
import de.eimantas.steuer.server.persistance.HibernateUtil;
import de.eimantas.steuer.shared.FieldVerifier;
import de.eimantas.steuer.shared.model.KategoriesPOJO;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class MainServiceImpl extends RemoteServiceServlet implements
		MainService {

	@Override
	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid.
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back
			// to
			// the client.
			throw new IllegalArgumentException(
					"Name must be at least 4 characters long");
		}

		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");

		// Escape data from the client to avoid cross-site script
		// vulnerabilities.
		input = escapeHtml(input);
		userAgent = escapeHtml(userAgent);

		return "Hello, " + input + "!<br><br>I am running " + serverInfo
				+ ".<br><br>It looks like you are using:<br>" + userAgent;
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html
	 *            the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}

	@Override
	public ArrayList<KategoriesPOJO> getKategories(int userId) {
		return getKategoriesFromDB(userId);
	}

	private ArrayList<KategoriesPOJO> getKategoriesFromDB(int userId) {

		ArrayList<KategoriesPOJO> kat = new ArrayList<KategoriesPOJO>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("from Kategorie");

		@SuppressWarnings("rawtypes")
		List liste = q.list();
		for (Object o : liste) {
			if (o instanceof Kategorie) {
				KategoriesPOJO kp = new KategoriesPOJO();
				kp.setName(((Kategorie) o).getName());
				kp.setIcon(((Kategorie) o).getIcon());
				kp.setUser(((Kategorie) o).getUser());
				kp.setKategorie(((Kategorie) o).getName());
				kat.add(kp);

			}

		}
		System.out.println("Gruesse von Kat ist: " + kat.size());
		return kat;
	}
}
