package com.gefa.fit.boundary.inbound.v0_0_0.rest.representations;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gefa.fit.application.domain.Asset;

public class AssetRepresentation extends Representation {

	private Long id;
	private String assetName;
	private String assetStatus;

	public AssetRepresentation() {

	}

	public AssetRepresentation(Asset asset, Link... links) {
		this.assetName = asset.getAssetName();
		this.assetStatus = asset.getAssetState().toString();
		this.links = Arrays.asList(links);

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getAssetStatus() {
		return assetStatus;
	}

	public void setAssetStatus(String assetStatus) {
		this.assetStatus = assetStatus;
	}

	@JsonIgnore
	public Link getSelfLink() {
		return getLinkByName("self");
	}

	@JsonIgnore
	public Link getUpdateLink() {
		return getLinkByName("update");
	}

	@JsonIgnore
	public Link getRemoveLink() {
		return getLinkByName("remove");
	}

	@JsonIgnore
	public Link getApproveLink() {
		return getLinkByName("approve");
	}

}
