package com.gefa.fit.client;


import com.gefa.fit.client.activities.Actions;
import com.gefa.fit.client.activities.ClientCreateAssetActivity;
import com.gefa.fit.client.activities.ClientReadAssetActivity;
import com.gefa.fit.client.domain.Asset;
import com.gefa.fit.client.exceptions.NotFoundException;
import com.gefa.fit.client.exceptions.ServiceFailureException;
import com.gefa.fit.domain.TestAssetFactory;
import org.jboss.resteasy.test.TestPortProvider;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;


import java.net.URI;
import java.net.URISyntaxException;


public class AssetTest {

    @BeforeClass
    public static void init() throws Exception {
//        MyServer.startContainer();
    }

    @AfterClass
    public static void stop() throws Exception {
  //      MyServer.stopContainer();

    }

/*
    private String getEntryPointURI() {
        String testPortProviderURL = TestPortProvider.generateURL("/fit-asset-service/asset");
        System.out.println("testPortProviderURL="+testPortProviderURL);
        return testPortProviderURL;
    }
*/

	private String getEntryPointURI() {
		return "http://localhost:8082/fit-asset-service/asset";
	}

    @Test
    public void testCreateAsset() throws URISyntaxException, NotFoundException, ServiceFailureException {
        ClientCreateAssetActivity clientCreateAssetActivity = new ClientCreateAssetActivity();

        TestAssetFactory testAssetFactory = new TestAssetFactory();
        Asset asset = testAssetFactory.createAsset();

        clientCreateAssetActivity.createAsset(asset, new URI(getEntryPointURI()));

        Asset createdAsset = null;
        Actions actions = clientCreateAssetActivity.getActions();

        if (actions.has(ClientReadAssetActivity.class)) {
            ClientReadAssetActivity clientReadAssetActivity = actions.get(ClientReadAssetActivity.class);
            clientReadAssetActivity.readAsset();
            createdAsset = clientReadAssetActivity.getAsset();
            actions = clientReadAssetActivity.getActions();
        }
        Assert.assertEquals(asset.getAssetName(), createdAsset.getAssetName());

    }


}
