package com.gefa.fit.boundary.inbound.rest.activities;

import com.gefa.fit.application.AssetService;
import com.gefa.fit.application.domain.Asset;
import com.gefa.fit.boundary.inbound.rest.representations.AssetRepresentation;
import com.gefa.fit.boundary.inbound.rest.representations.Link;
import com.gefa.fit.boundary.inbound.rest.representations.converters.AssetConverter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@ApplicationScoped
public class CreateAssetActivity {

	@Inject
	private AssetService assetService;

	@Inject
	private AssetConverter assetConverter;

	public CreateAssetActivity() {

	}

	public AssetRepresentation create(AssetRepresentation assetRepresentation, UriInfo uriInfo) {

		Asset asset = assetConverter.toAsset(assetRepresentation);
		Long assetId = assetService.create(asset);

		String assetURI = uriInfo.getBaseUri() + "v1.0.0/asset/" + assetId;
		Link assetSelflink = new Link("self", assetURI, MediaType.APPLICATION_XML);
		Link assetUpdatelink = new Link("update", assetURI, MediaType.APPLICATION_XML);
		Link assetDeletelink = new Link("remove", assetURI, MediaType.APPLICATION_XML);

		return new AssetRepresentation(asset, assetSelflink, assetUpdatelink, assetDeletelink);
	}

}
