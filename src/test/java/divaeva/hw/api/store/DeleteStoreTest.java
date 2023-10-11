package divaeva.hw.api.store;

import dto.StoreDTO;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import rest.client.RestClient;

public class DeleteStoreTest extends StoreTestBase {
    private RestClient<StoreDTO> restClient = new RestClient<>(BASE_SERVER_URL_STORE);

    @Test
    public void verifyStoreCanBeDelete() {
        int orderId = 12;

        StoreDTO storeDTO = createDefaultStore(orderId);
        Response postResponse = restClient.postEntity(storeDTO);
        Assert.assertEquals(postResponse.getStatusCode(), 200);

        Response responseDelete = restClient.deleteEntity(orderId);
        Assert.assertEquals(responseDelete.getStatusCode(), 200);

        Response response1 = restClient.getEntity(orderId);
        Assert.assertEquals(response1.getStatusCode(), 404);
    }
}
