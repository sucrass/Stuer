package de.eimantas.steuer.shared.model;

import java.io.Serializable;

public class KategoriesPOJO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public KategoriesPOJO() {

	}

	private String icon;
	private String kategorie;
	private String name;
	private int user;

	public String getKategorie() {
		return kategorie;
	}

	public String getIcon() {
		return icon;
	}

	public void setName(String string) {
		this.name = string;
	}

	public String getName() {
		return name;
	}

	public int getUser() {
		return user;
	}

	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}

	public void setIcon(String icon2) {
		this.icon = icon2;
	}

	public void setUser(int user) {
		this.user = user;
	}

}
