package divaeva.hw.api.pet;

import dto.PetDTO;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import rest.client.RestClient;

public class DeletePetTest extends PetTestBase {
    private RestClient<PetDTO> restClient = new RestClient<>(BASE_SERVER_URL_PET);

    @Test
    public void verifyPetCanBeDelete() {
        int petId = 22;
        PetDTO defaultPet = createDefaultPet(petId);

        Response response = restClient.postEntity(defaultPet);
        Assert.assertEquals(response.getStatusCode(), 200);

        Response responseDelete = restClient.deleteEntity(petId);
        Assert.assertEquals(responseDelete.getStatusCode(), 200);

        Response response1 = restClient.getEntity(petId);
        Assert.assertEquals(response1.getStatusCode(), 404);
    }
}
