package com.gefa.fit.client.activities;


import com.gefa.fit.client.representations.AssetRepresentation;

public class RepresentationHypermediaProcessor {

	Actions extractNextActionsFromAssetRepresentation(AssetRepresentation assetRepresentation) {

		Actions actions = new Actions();

		if (null != assetRepresentation) {
			if (null != assetRepresentation.getSelfLink()) {
				actions.add(new ClientReadAssetActivity(assetRepresentation.getSelfLink().getUri()));
			}

			if (null != assetRepresentation.getUpdateLink()) {
				actions.add(new ClientUpdateAssetActivity(assetRepresentation.getUpdateLink().getUri()));
			}

			if (null != assetRepresentation.getRemoveLink()) {
				actions.add(new ClientRemoveAssetActivity(assetRepresentation.getRemoveLink().getUri()));
			}
		}

		return actions;

	}


}
