package com.gefa.fit.boundary.inbound.jms.events;


import com.gefa.fit.boundary.AbstractTransferObject;

public class AssetEvent extends AbstractTransferObject {

    private String eventType;

	private String assetName;

    public AssetEvent(String eventType, String assetName) {
        this.eventType = eventType;
        this.assetName = assetName;
    }

    public String getEventType() {
        return eventType;
    }

    public String getAssetName() {
        return assetName;
    }

}