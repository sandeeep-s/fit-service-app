package com.gefa.fit.application.domain;

public class AssetCreatedState extends AssetState {

    private Asset asset;

    public AssetCreatedState(Asset asset) {

        this.asset = asset;
    }

    @Override
    public void moveToDeletedState() {

        asset.setAssetState(new AssetDeletedState(asset));
    }

}
