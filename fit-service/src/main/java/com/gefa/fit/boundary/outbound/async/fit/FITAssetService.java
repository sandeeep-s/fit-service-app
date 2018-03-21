package com.gefa.fit.boundary.outbound.async.fit;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.gefa.fit.application.domain.events.AssetCreatedEvent;

@ApplicationScoped
public class FITAssetService {

	@Inject
	private FITAssetServiceAdapter fitAssetServiceAdapter;

	public void createAsset(AssetCreatedEvent assetCreatedEvent) {
		fitAssetServiceAdapter.createAsset(assetCreatedEvent);
	}

	public void updateAsset(AssetCreatedEvent assetCreatedEvent) {
		fitAssetServiceAdapter.updateAsset(assetCreatedEvent);
	}

}
