package com.gefa.fit.boundary.inbound.v0_0_0.rest.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.gefa.fit.boundary.inbound.v0_0_0.rest.representations.AssetRepresentation;

@Path("/v0.0.0/asset")
@Api(value = "assets")
@SwaggerDefinition(tags = { @Tag(name = "assets", description = "Operations on assets.") })
public interface AssetResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Create an asset", notes = "Create an asset in EKF Tool")
	@ApiResponses(@ApiResponse(code = 200, message = "Asset has been created"))
	Response addAsset(AssetRepresentation assetRepresentation);

	@POST
	@Path("/{assetId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	AssetRepresentation updateAsset(@PathParam("assetId") Long id, AssetRepresentation assetRepresentation);

	@GET
	@Path("/{assetId}")
	@Produces(MediaType.APPLICATION_JSON)
	Response getAsset(@PathParam("assetId") Long id);

	@DELETE
	@Path("/{assetId}")
	@Produces(MediaType.APPLICATION_JSON)
	Response removeAsset(@PathParam("assetId") Long id);

}
