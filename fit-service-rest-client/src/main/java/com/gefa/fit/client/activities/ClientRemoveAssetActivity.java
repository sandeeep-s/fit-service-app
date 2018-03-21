package com.gefa.fit.client.activities;

import java.net.URI;

import com.gefa.fit.client.domain.Asset;
import com.gefa.fit.client.exceptions.CannotCancelException;
import com.gefa.fit.client.exceptions.NotFoundException;
import com.gefa.fit.client.exceptions.ServiceFailureException;
import com.gefa.fit.client.representations.AssetRepresentation;
import com.gefa.fit.client.representations.converters.AssetConverter;

public class ClientRemoveAssetActivity extends Activity {

    private final URI assetURI;

    private Asset asset;

    private AssetConverter assetConverter;

    public ClientRemoveAssetActivity(URI assetURI) {
        this.assetURI = assetURI;
    }

    public void removeAsset(Asset asset) {
        try {
            AssetRepresentation assetRepresentation = httpBinding.removeAsset(assetURI);
            this.asset = assetConverter.toAsset(assetRepresentation);
        } catch (NotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ServiceFailureException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (CannotCancelException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Asset getAsset() {
        return asset;
    }

}
