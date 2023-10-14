package divaeva.hw.api.pet;

import divaeva.hw.api.TestUrls;
import dto.ErrorResponse;
import dto.PetDTO;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import rest.client.RestClient;

public class GetPetTest extends PetTestBase {
    private final RestClient restClient = new RestClient(TestUrls.BASE_SERVER_URL_PET.getUrl());

    @Test
    public void getPetTest() {
        int petId = 11;
        PetDTO defaultPet = createDefaultPet(petId);
        Response response = restClient.postEntity(defaultPet);
        Assert.assertEquals(response.getStatusCode(), 200);

        Response foundPet = restClient.getEntities(petId);
        PetDTO pet = response.as(PetDTO.class);
        Assert.assertEquals(foundPet.getStatusCode(), 200);
        Assert.assertEquals(pet.getId(), petId);
    }

    @Test
    public void getNonExistentPet() {
        int petId = 3;
        restClient.deleteEntity(petId);

        Response response = restClient.getEntities(petId);
        Assert.assertEquals(response.getStatusCode(), 404);
        ErrorResponse errorResponse = response.as(ErrorResponse.class);

        Assert.assertEquals(errorResponse.getCode(), 1);
        Assert.assertEquals(errorResponse.getType(), "error");
        Assert.assertEquals(errorResponse.getMessage(), "Pet not found");
    }
}
