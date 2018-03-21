package com.gefa.fit.application.domain;

public class Asset extends AggregateRoot {

	private Long id;
	private String assetName;
	private AssetState assetState;

	public Asset(String assetName) {
		super();
		this.assetName = assetName;
	}

	public Asset(Long id, String assetName) {
		super();
		this.id = id;
		this.assetName = assetName;
	}

	public Long getId() {
		return id;
	}

	public String getAssetName() {
		return assetName;
	}

	public AssetState getAssetState() {
		return assetState;
	}

	public void setAssetState(AssetState assetState) {
		this.assetState = assetState;
	}

	public void moveToCreatedState() {
		assetState.moveToCreatedState();
	}

	public void moveToDeletedState() {
		assetState.moveToDeletedState();
	}

}
