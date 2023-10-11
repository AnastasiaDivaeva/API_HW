package divaeva.hw.api.store;

import dto.StoreDTO;

public class StoreTestBase {
    protected final String BASE_SERVER_URL_STORE = "https://petstore.swagger.io/v2/store/order/";
    protected final String BASE_SERVER_URL_STORE_INVENTORY = "https://petstore.swagger.io/v2/store/inventory";

    protected StoreDTO createDefaultStore(int id) {
        int petId = 12;
        int quantity = 2;
        String shipDate = "2023-10-11T10:41:30.088+0000";
        String status = "placed";
        boolean complete = true;

        return StoreDTO.createStore(id, petId, quantity, shipDate, status, complete);
    }
}
