package divaeva.hw.api.store;

import divaeva.hw.api.TestUrls;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import rest.client.RestClient;

import java.util.Map;

public class GetStoreInventoryTest extends StoreTestBase {

    private final RestClient restClient = new RestClient(TestUrls.BASE_SERVER_URL_STORE_INVENTORY.getUrl());

    @Test
    public void getStoreInventoryTest() {
        Response getResponse = restClient.getEntities();
        Map response = getResponse.as(Map.class);
        Assert.assertFalse(response.isEmpty());
        Assert.assertEquals(getResponse.getStatusCode(), 200);
    }
}
