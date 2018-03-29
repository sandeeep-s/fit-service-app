package com.gefa.fit.application;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.gefa.fit.application.domain.Asset;
import com.gefa.fit.application.domain.AssetCreatedState;
import com.gefa.fit.application.domain.events.AssetCreatedEvent;
import com.gefa.fit.application.domain.events.DomainEvent;
import com.gefa.fit.application.domain.repositories.MapAssetRepository;
import com.gefa.fit.application.exceptions.AssetCreationException;
import com.gefa.fit.application.exceptions.AssetRemovalException;
import com.gefa.fit.application.exceptions.AssetUpdateException;
import com.gefa.fit.application.infrastructure.RXDomainEventsDispatcher;

@ApplicationScoped
public class AssetService {

    @Inject
    private MapAssetRepository assetRepository;
    // private AssetRepository assetRepository;

    @Inject
    private RXDomainEventsDispatcher domainEventsDispatcher;

    public Long create(Asset asset) {

        Long assetId;
        try {
            asset.setAssetState(new AssetCreatedState(asset));
            assetId = assetRepository.saveAsset(asset);
            asset.addDomainEvent(new AssetCreatedEvent(asset));
            for (DomainEvent domainEvent : asset.getDomainEvents()) {
                domainEventsDispatcher.dispatch(domainEvent);
            }
        } catch (Exception e) {
            throw new AssetCreationException();
        }

        return assetId;
    }

    public void update(Asset asset) {

        try{
            Asset assetFromRepo = assetRepository.getAsset(asset.getId());
            assetFromRepo.moveToCreatedState();
            assetRepository.updateAsset(asset);

        }catch(UnsupportedOperationException e){
            throw new AssetUpdateException();
        }catch(Exception e){
            throw new AssetUpdateException();
        }

        // TODO Update the assetFromRepo details onto asset
    }

    public Asset getAsset(Long assetId) {
        return assetRepository.getAsset(assetId);
    }

    public Asset removeAsset(Long assetId) {
        try {
            Asset asset = assetRepository.getAsset(assetId);
            asset.moveToDeletedState();
            return assetRepository.delete(assetId);
        } catch (UnsupportedOperationException e) {
            throw new AssetRemovalException();
        }

    }

}
