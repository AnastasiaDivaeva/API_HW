package divaeva.hw.api.store;

import divaeva.hw.api.TestUrls;
import dto.StoreDTO;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import rest.client.RestClient;

public class GetStoreTest extends StoreTestBase {
    private final RestClient restClient = new RestClient(TestUrls.BASE_SERVER_URL_STORE.getUrl());

    @Test
    public void getStoreTest() {
        int id = 12;
        int petId = 12;
        int quantity = 2;
        String shipDate = "2023-10-11T10:41:30.088+0000";
        String status = "placed";
        boolean complete = true;

        StoreDTO storeToCreate = new StoreDTO(id, petId, quantity, shipDate, status, complete);
        restClient.postEntity(storeToCreate);

        Response foundOrder = restClient.getEntities(id);
        StoreDTO storeDTO = foundOrder.as(StoreDTO.class);
        Assert.assertEquals(foundOrder.getStatusCode(), 200);
        Assert.assertEquals(storeDTO.getId(), id);
        Assert.assertEquals(storeDTO.getPetId(), petId);
        Assert.assertEquals(storeDTO.getQuantity(), quantity);
        Assert.assertEquals(storeDTO.getShipDate(), shipDate);
        Assert.assertEquals(storeDTO.getStatus(), status);
        Assert.assertEquals(storeDTO.isComplete(), complete);
    }
}
