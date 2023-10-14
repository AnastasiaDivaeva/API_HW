package divaeva.hw.api.store;

import dto.StoreDTO;

public class StoreTestBase {

    protected StoreDTO createDefaultStore(int id) {
        int petId = 12;
        int quantity = 2;
        String shipDate = "2023-10-11T10:41:30.088+0000";
        String status = "placed";
        boolean complete = true;

        return new StoreDTO(id, petId, quantity, shipDate, status, complete);
    }
}
