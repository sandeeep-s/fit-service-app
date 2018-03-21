package com.gefa.fit.application.domain;

public class AssetDeletedState extends AssetState {

	private Asset asset;

	public AssetDeletedState(Asset asset) {
		this.asset = asset;
	}

}
