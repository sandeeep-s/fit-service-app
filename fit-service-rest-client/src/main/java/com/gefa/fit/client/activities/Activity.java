package com.gefa.fit.client.activities;

import com.gefa.fit.client.network.HttpBinding;

public class Activity {

	protected final HttpBinding httpBinding = new HttpBinding();

	protected Actions actions;

	public Actions getActions() {
		return actions;
	}
}
