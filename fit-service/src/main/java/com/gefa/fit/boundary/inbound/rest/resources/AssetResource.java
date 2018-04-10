package com.gefa.fit.boundary.inbound.rest.resources;

import com.gefa.fit.boundary.inbound.rest.representations.AssetRepresentation;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1.0.0/asset")
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
