package divaeva.hw.api.store;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import rest.client.RestClient;

import java.util.Map;

public class GetStoreInventoryTest extends StoreTestBase {

    private RestClient<Map> restClient = new RestClient<>(BASE_SERVER_URL_STORE_INVENTORY);

    @Test
    public void getStoreInventoryTest() {
        Response getResponse = restClient.getEntity();
        Map response = getResponse.as(Map.class);
        Assert.assertFalse(response.isEmpty());
        Assert.assertEquals(getResponse.getStatusCode(), 200);
    }
}
