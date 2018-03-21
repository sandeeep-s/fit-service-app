package com.gefa.fit.client.domain;

public class Asset {

    private Long id;
    private String assetName;
    private String assetStatus;

    public Asset() {

    }

    public Asset(String assetName) {
        this.assetName = assetName;
    }

    public Asset(Long id, String assetName) {
        this.id = id;
        this.assetName = assetName;
    }

    public Asset(Long id, String assetName, String assetStatus) {
        this.id = id;
        this.assetName = assetName;
        this.assetStatus = assetStatus;
    }

    public Long getId() {
        return id;
    }

    public String getAssetName() {
        return assetName;
    }

    public String getAssetStatus() {
        return assetStatus;
    }
}
