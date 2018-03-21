package com.gefa.fit.domain;

import com.gefa.fit.client.domain.Asset;

import java.util.concurrent.ThreadLocalRandom;

public class TestAssetFactory {

	public Asset createAsset() {
		int random = ThreadLocalRandom.current().nextInt(10000, 30000);

		String assetName = "JMSTEST-" + random;
		return new Asset(assetName);

	}

}
