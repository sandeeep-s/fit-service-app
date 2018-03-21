package com.gefa.fit.boundary.inbound.rest.representations.converters;

import com.gefa.fit.application.domain.Asset;
import com.gefa.fit.boundary.inbound.rest.representations.AssetRepresentation;
import com.gefa.fit.boundary.inbound.rest.representations.Link;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AssetConverter {

	public Asset toAsset(AssetRepresentation assetRepresentation) {

		return new Asset(assetRepresentation.getId(),
				assetRepresentation.getAssetName());

	}

	public Asset toAsset(AssetRepresentation assetRepresentation, Long assetId) {
		return new Asset(assetId, assetRepresentation.getAssetName());

	}

	public AssetRepresentation fromAsset(Asset asset, Link... links) {
		return new AssetRepresentation(asset, links);
	}

}
