package com.iknowus.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Configuration {

	private Properties objProperties;

	public Configuration() {
		InputStream objStream = null;
		try {
			objStream = Configuration.class.getClassLoader().getResourceAsStream("config.properties");
			if (objStream != null) {
				this.objProperties = new Properties();
				this.objProperties.load(objStream);
				objStream.close();
				objStream = null;
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (objStream != null) {
				try {
					objStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String get(String key) {
		try {
			String value = this.objProperties.getProperty(key);
			return value;
		} catch (Exception ex) {
			ex.printStackTrace();
			return "";
		}
	}

	public void set(String key, String value) {
		this.objProperties.put(key, value);
	}

	@SuppressWarnings("rawtypes")
	public List<Map> list() {
		List<Map> lista = new ArrayList<Map>();
		try {
			Object[] keys = this.objProperties.keySet().toArray();
			Arrays.sort(keys);
			Map<String, String> key;
			for (Object property : keys) {
				key = new HashMap<String, String>();
				key.put("key", this.objProperties.toString());
				key.put("value", this.objProperties.get(property.toString()).toString());
				lista.add(key);
			}
			key = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lista;
	}
}