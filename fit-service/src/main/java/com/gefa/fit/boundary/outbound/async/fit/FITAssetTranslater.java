package com.gefa.fit.boundary.outbound.async.fit;

import com.gefa.fit.application.domain.Asset;
import com.gefa.fit.application.domain.events.AssetCreatedEvent;
import com.gefa.fit.boundary.outbound.async.fit.domain.FITAsset;

public class FITAssetTranslater {

	public FITAsset toFITAsset(AssetCreatedEvent assetCreatedEvent) {
		return new FITAsset();
	}

	public Asset fromFITAsset(FITAsset fitAsset) {
		return null;
	}

}
