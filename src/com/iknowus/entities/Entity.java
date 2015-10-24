package com.iknowus.entities;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Entity implements Serializable, Cloneable {

	private Action action = Action.None;

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	@SuppressWarnings("unchecked")
	public <T extends Entity> T getClone() {

		Entity obj = null;
		try {
			obj = (Entity) super.clone();
		} catch (CloneNotSupportedException ex) {
			ex.printStackTrace();
		}
		return (T) obj;
	}

	@SuppressWarnings("unchecked")
	public <T extends Entity> T getMe() {
		return (T) this;
	}

}
