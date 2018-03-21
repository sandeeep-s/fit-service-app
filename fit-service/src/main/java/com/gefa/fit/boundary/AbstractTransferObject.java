package com.gefa.fit.boundary;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class AbstractTransferObject {

	private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	public static String toJson(Object o) {
		return getGsonInstance().toJson(o);
	}

	public final String toJson() {
		return getGsonInstance().toJson(this);
	}

	private static Gson getGsonInstance() {
		return new GsonBuilder().setDateFormat(DATE_FORMAT).create();
	}
}
