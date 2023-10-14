package divaeva.hw.api.store;

import divaeva.hw.api.TestUrls;
import dto.StoreDTO;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import rest.client.RestClient;

public class CreateStoreTest extends StoreTestBase {
    private final RestClient restClient = new RestClient(TestUrls.BASE_SERVER_URL_STORE.getUrl());

    @Test
    public void verifyStoreCanBeCreate() {
        int id = 12;
        int petId = 12;
        int quantity = 2;
        String shipDate = "2023-10-11T10:41:30.088+0000";
        String status = "placed";
        boolean complete = true;

        StoreDTO storeToCreate = new StoreDTO(id, petId, quantity, shipDate, status, complete);
        Response response = restClient.postEntity(storeToCreate);
        StoreDTO createStoreResponse = response.as(StoreDTO.class);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(createStoreResponse.getId(), id);
        Assert.assertEquals(createStoreResponse.getPetId(), petId);
        Assert.assertEquals(createStoreResponse.getQuantity(), quantity);
        Assert.assertEquals(createStoreResponse.getShipDate(), shipDate);
        Assert.assertEquals(createStoreResponse.getStatus(), status);
        Assert.assertTrue(createStoreResponse.isComplete());
    }
}
