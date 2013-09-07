package de.eimantas.steuer.shared.event;

import com.google.gwt.event.shared.EventHandler;

public interface AddEintragEventHandler extends EventHandler {
	void onAddEintrag(AddEintragEvent event);
}
