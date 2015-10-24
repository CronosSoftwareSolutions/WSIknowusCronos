package com.iknowus.data;

import java.sql.Connection;

public class DataGeneric<T> extends Data<T> {

	public DataGeneric(Class<T> type, Connection connection) {
		super(type, connection);
	}

	public T buscar(Long id) {
		return super.buscar(id);
	}

}