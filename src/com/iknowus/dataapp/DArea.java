package com.iknowus.dataapp;

import java.sql.Connection;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import com.iknowus.App;
import com.iknowus.Constantes;
import com.iknowus.data.Data;


public class DArea<T> extends Data<T> {

	public DArea(Class<T> type, Connection connection) {
		super(type, connection);
	}

	public T buscar(Long id) {
		return super.buscar(id);
	}
	
	public T searchByUser(Long userID) {
		return super.buscar("select * from " + this.tableName + " where user_id = " + userID);
	}
	
	public List<T> listar() {
		Long actual_date = Calendar.getInstance(TimeZone.getTimeZone(App.TIME_ZONE)).getTimeInMillis();
		return this.list("select * from app_package_ads where package_id in (select id from app_package where idc_type=" + Constantes.Services_Types.ANUNCIO_LISTADO + " and status=1 and " + actual_date + " BETWEEN start_date and end_date) and current_ads=1 and status=1");
	}
	
	public List<T> listar(Long id, Long date, Long placeId) {
		String query = String.format("SELECT * FROM %s where id > %d and date >= %d and place_id=%d order by id limit 30", this.tableName, id, date, placeId);
		List<T> lista = this.list(query);
		return lista;
	}	
}
