package com.gefa.fit.boundary.outbound.async.fit;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.gefa.fit.application.domain.events.AssetCreatedEvent;
import com.gefa.fit.application.domain.events.DomainEvent;
import com.gefa.fit.application.domain.events.handlers.DomainEventHandler;

@ApplicationScoped
public class FITAssetCreatedEventHandler implements DomainEventHandler {

	@Inject
	private FITAssetService fitAssetService;

	@Override
	public void handle(DomainEvent assetCreatedEvent) {

			fitAssetService.createAsset((AssetCreatedEvent)assetCreatedEvent);
	}

}
