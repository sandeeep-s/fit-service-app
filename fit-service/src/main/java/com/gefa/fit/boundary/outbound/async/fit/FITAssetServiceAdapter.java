package com.gefa.fit.boundary.outbound.async.fit;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.gefa.fit.application.domain.events.AssetCreatedEvent;

@ApplicationScoped
public class FITAssetServiceAdapter {

	@Inject
	private FITAssetTranslater fitAssetTranslater;

	@Inject
	private JMSFacade jmsBinding;

	public void createAsset(AssetCreatedEvent assetCreatedEvent) {
		jmsBinding.createAsset(fitAssetTranslater.toFITAsset(assetCreatedEvent));
	}

	public void updateAsset(AssetCreatedEvent assetCreatedEvent) {
		jmsBinding.updateAsset(fitAssetTranslater.toFITAsset(assetCreatedEvent));
	}

}
