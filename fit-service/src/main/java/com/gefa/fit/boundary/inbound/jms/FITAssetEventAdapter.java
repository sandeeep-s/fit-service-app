package com.gefa.fit.boundary.inbound.jms;

import com.gefa.fit.application.AssetService;
import com.gefa.fit.boundary.inbound.jms.events.AssetEvent;
import com.gefa.fit.boundary.inbound.jms.events.converter.AssetEventConverter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class FITAssetEventAdapter extends AssetEventAdapter{

    @Inject
    private AssetService assetService;

    @Inject
    private AssetEventConverter assetEventConverter;

    @Override
    public void handleEvent(AssetEvent assetEvent) {
        String eventType = assetEvent.getEventType();
        switch (eventType){
            case "asset-created":
                assetService.create(assetEventConverter.toAsset(assetEvent));
                break;
            default:

        }
    }
}
