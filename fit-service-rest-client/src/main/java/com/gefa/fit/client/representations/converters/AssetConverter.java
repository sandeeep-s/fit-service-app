package com.gefa.fit.client.representations.converters;


import com.gefa.fit.client.domain.Asset;
import com.gefa.fit.client.representations.AssetRepresentation;

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

    public AssetRepresentation fromAsset(Asset asset) {

        return new AssetRepresentation(asset);
    }

}
