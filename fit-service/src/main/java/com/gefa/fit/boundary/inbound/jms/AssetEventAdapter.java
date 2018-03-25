package com.gefa.fit.boundary.inbound.jms;

import com.gefa.fit.boundary.inbound.jms.events.AssetEvent;

public abstract class AssetEventAdapter {

	public abstract void handleEvent(AssetEvent assetEvent) ;

}
