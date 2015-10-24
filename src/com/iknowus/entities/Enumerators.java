package com.iknowus.entities;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Enumerators implements Serializable {

	public static final class Status {
		public static int Delete = 2;
		public static int Enable = 1;
		public static int Disable = 0;		
	}

}
