package dto;

public class StoreDTO {
    private int id;
    private int petId;
    private int quantity;
    private String shipDate;
    private String status;
    private boolean complete;

    public int getId() {
        return id;
    }

    public StoreDTO setId(int id) {
        this.id = id;
        return this;
    }

    public int getPetId() {
        return petId;
    }

    public StoreDTO setPetId(int petId) {
        this.petId = petId;
        return this;
    }

    public String getShipDate() {
        return shipDate;
    }

    public StoreDTO setShipDate(String shipDate) {
        this.shipDate = shipDate;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public StoreDTO setStatus(String status) {
        this.status = status;
        return this;
    }

    public boolean isComplete() {
        return complete;
    }

    public StoreDTO setComplete(boolean complete) {
        this.complete = complete;
        return this;
    }
    public int getQuantity() {
        return quantity;
    }

    public StoreDTO setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
    public static StoreDTO createStore(int id,int petId,int quantity,String shipDate,String status,boolean complete){
        StoreDTO storeToCreate=new StoreDTO();
        storeToCreate.setId(id);
        storeToCreate.setPetId(petId);
        storeToCreate.setQuantity(quantity);
        storeToCreate.setShipDate(shipDate);
        storeToCreate.setStatus(status);
        storeToCreate.setComplete(complete);
        return storeToCreate;
    }
}
