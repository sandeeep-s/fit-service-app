package com.gefa.fit.boundary.inbound.jms.events.converter;

import com.gefa.fit.application.domain.Asset;
import com.gefa.fit.boundary.inbound.jms.events.AssetEvent;

public class AssetEventConverter {

	public Asset toAsset(AssetEvent assetEvent) {

		return new Asset(assetEvent.getAssetName());
	}

}
