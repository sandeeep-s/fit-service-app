package com.gefa.fit.client.activities;

import com.gefa.fit.client.domain.Asset;
import com.gefa.fit.client.exceptions.MalformedAssetException;
import com.gefa.fit.client.exceptions.ServiceFailureException;
import com.gefa.fit.client.representations.AssetRepresentation;
import com.gefa.fit.client.representations.converters.AssetConverter;

import java.net.URI;

public class ClientCreateAssetActivity extends Activity {

	private Asset asset;

	private AssetConverter assetConverter = new AssetConverter();

	public void createAsset(Asset asset, URI assetURI) {

		try {
			AssetRepresentation assetRepresentation = httpBinding.createAsset(assetConverter.fromAsset(asset), assetURI);
			this.asset = assetConverter.toAsset(assetRepresentation);
			this.actions = new RepresentationHypermediaProcessor()
					.extractNextActionsFromAssetRepresentation(assetRepresentation);

		} catch (MalformedAssetException e) {
			e.printStackTrace();
		} catch (ServiceFailureException e) {
			e.printStackTrace();
		}

	}

	public Asset getAsset() {
		return asset;
	}

}
