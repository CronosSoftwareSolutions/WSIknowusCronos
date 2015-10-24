package com.iknowus.ws;

import java.util.Set;
import java.util.HashSet;
import javax.ws.rs.core.Application;

public class ServicesApplication extends Application {

	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();

	public ServicesApplication() {
		singletons.add(new Services());
	}

	@Override
	public Set<Class<?>> getClasses() {
		return empty;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
