package com.gefa.fit.boundary.inbound.rest.resources;

import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.gefa.fit.application.exceptions.AssetRemovalException;
import com.gefa.fit.boundary.inbound.rest.activities.CreateAssetActivity;
import com.gefa.fit.boundary.inbound.rest.activities.ReadAssetActivity;
import com.gefa.fit.boundary.inbound.rest.activities.RemoveAssetActivity;
import com.gefa.fit.boundary.inbound.rest.activities.UpdateAssetActivity;
import com.gefa.fit.boundary.inbound.rest.representations.AssetRepresentation;

public class AssetResourceImpl implements AssetResource {

	@Inject
	private CreateAssetActivity createAssetActivity;

	@Inject
	private UpdateAssetActivity updateAssetActivity;

	@Inject
	private ReadAssetActivity readAssetActivity;

	@Inject
	private RemoveAssetActivity removeAssetActivity;

	@Context
	UriInfo uriInfo;

	public Response addAsset(AssetRepresentation assetRepresentation) {
		AssetRepresentation responseRepresentation = createAssetActivity.create(assetRepresentation, uriInfo);
		ResponseBuilder builder = Response.status(Status.CREATED).type(MediaType.APPLICATION_JSON)
				.entity(responseRepresentation);

		return builder.build();
	}

	public AssetRepresentation updateAsset(Long assetId, AssetRepresentation assetRepresentation) {
		AssetRepresentation responseRepresentation = updateAssetActivity.update(assetId, assetRepresentation, uriInfo);
		return responseRepresentation;
	}

	public Response getAsset(Long assetId) {
		AssetRepresentation responseRepresentation = readAssetActivity.retrieveById(assetId, uriInfo);
		ResponseBuilder builder = Response.status(Status.OK).type(MediaType.APPLICATION_JSON)
				.entity(responseRepresentation);
		return builder.build();
	}

	public Response removeAsset(Long assetId) {
		try {
			AssetRepresentation responseRepresentation = removeAssetActivity.delete(assetId);
			ResponseBuilder builder = Response.status(Status.OK).type(MediaType.APPLICATION_JSON)
					.entity(responseRepresentation);
			return builder.build();
		} catch (AssetRemovalException e) {
			return Response.status(Status.METHOD_NOT_ALLOWED).build();
		}
	}

}
