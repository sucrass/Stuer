package de.eimantas.steuer.shared.event;

import com.google.gwt.event.shared.GwtEvent;

public class AddEintragEvent extends GwtEvent<AddEintragEventHandler> {
	public static Type<AddEintragEventHandler> TYPE = new Type<AddEintragEventHandler>();

	@Override
	public Type<AddEintragEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(AddEintragEventHandler handler) {
		handler.onAddEintrag(this);
	}
}
