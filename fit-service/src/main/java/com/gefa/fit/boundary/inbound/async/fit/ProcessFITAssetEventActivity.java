package com.gefa.fit.boundary.inbound.async.fit;

import com.gefa.fit.application.AssetService;
import com.gefa.fit.application.domain.Asset;
import com.gefa.fit.application.domain.repositories.AssetRepository;
import com.gefa.fit.boundary.inbound.async.fit.domain.FITAssetEvent;

public class ProcessFITAssetEventActivity {

	private AssetService assetService;

	private AssetRepository assetRepository;

	public void create(FITAssetEvent fitAssetEvent) {

		if (assetRepository.exists(fitAssetEvent.getAssetNumber())) {
			Asset asset = assetRepository.getAsset(fitAssetEvent.getAssetNumber());
			assetService.update(asset);
		} else {
			assetService.create(createAssetFromEvent(fitAssetEvent));
		}
	}

	private Asset createAssetFromEvent(FITAssetEvent fitAssetEvent) {
		return new Asset(fitAssetEvent.getAssetName());
	}

	private Asset updateAssetFromEvent(Asset asset, FITAssetEvent fitAssetEvent) {
		return asset;
	}
}
