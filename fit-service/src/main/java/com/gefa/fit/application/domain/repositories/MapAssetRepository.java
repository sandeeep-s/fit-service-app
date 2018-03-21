package com.gefa.fit.application.domain.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Singleton;

import com.gefa.fit.application.domain.Asset;

@Singleton
public class MapAssetRepository implements AssetRepository {

	/*
	 * private static final MapAssetRepository thisRepository = new
	 * MapAssetRepository();
	 * 
	 * public static MapAssetRepository current() { return thisRepository; }
	 */
	private Map<Long, Asset> backingStore = new HashMap<Long, Asset>();

	public Long save(Asset asset) {
		int size = backingStore.size();
		Long id = Long.valueOf(size + 1);
		backingStore.put(id, asset);
		return id;
	}

	public Long update(Asset asset, Long id) {
		backingStore.put(id, asset);
		return id;
	}

	public Asset find(Long id) {
		return backingStore.get(id);
	}

	public Asset delete(Long id) {
		Asset asset = backingStore.remove(id);
		return asset;
	}

	@Override
	public Long saveAsset(Asset asset) {
		int size = backingStore.size();
		Long id = Long.valueOf(size + 1);
		backingStore.put(id, asset);
		return id;

	}

	@Override
	public void updateAsset(Asset asset) {
		backingStore.put(asset.getId(), asset);
	}

	@Override
	public Asset getAsset(Long assetId) {
		return backingStore.get(assetId);
	}

	@Override
	public Boolean exists(Long assetNumber) {

		return null;
	}

	@Override
	public List<Asset> getAssetsByDealer(Long gevisNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
