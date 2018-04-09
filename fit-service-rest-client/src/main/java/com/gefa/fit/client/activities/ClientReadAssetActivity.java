package com.gefa.fit.client.activities;

import com.gefa.fit.client.domain.Asset;
import com.gefa.fit.client.exceptions.NotFoundException;
import com.gefa.fit.client.exceptions.ServiceFailureException;
import com.gefa.fit.client.representations.AssetRepresentation;
import com.gefa.fit.client.representations.converters.AssetConverter;

import java.net.URI;

public class ClientReadAssetActivity extends Activity {

	private final URI assetURI;
	private Asset asset;
	private AssetConverter assetConverter =  new AssetConverter();

	public ClientReadAssetActivity(URI assetURI) {
		this.assetURI = assetURI;
	}

	public void readAsset() throws NotFoundException, ServiceFailureException {
			System.out.println("assetURI="+assetURI);
			AssetRepresentation assetRepresentation = httpBinding.retrieveAsset(assetURI);
			this.asset = assetConverter.toAsset(assetRepresentation);
			this.actions = new RepresentationHypermediaProcessor()
					.extractNextActionsFromAssetRepresentation(assetRepresentation);
	}
	
	public Asset getAsset() {
		return asset;
	}
}
