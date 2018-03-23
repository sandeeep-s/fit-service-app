package com.gefa.fit.boundary.inbound.jms.base;

import javax.inject.Singleton;

@Singleton
public class Configuration {

	private long timeout = 20000;

	public long getTimeout() {
		return timeout;
	}

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}
	
	
	
}
