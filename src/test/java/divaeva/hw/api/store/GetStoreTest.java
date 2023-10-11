package divaeva.hw.api.store;

import dto.StoreDTO;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import rest.client.RestClient;

public class GetStoreTest extends StoreTestBase {
    private RestClient<StoreDTO> restClient = new RestClient<>(BASE_SERVER_URL_STORE);

    @Test
    public void getStoreTest() {
        int id = 12;

        StoreDTO storeToCreate = createDefaultStore(id);
        restClient.postEntity(storeToCreate);

        Response foundOrder = restClient.getEntity(id);
        Assert.assertEquals(foundOrder.getStatusCode(), 200);
    }

}
