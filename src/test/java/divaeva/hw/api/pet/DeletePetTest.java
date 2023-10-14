package divaeva.hw.api.pet;

import divaeva.hw.api.TestUrls;
import dto.ErrorResponse;
import dto.PetDTO;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import rest.client.RestClient;

public class DeletePetTest extends PetTestBase {
    private final RestClient restClient = new RestClient(TestUrls.BASE_SERVER_URL_PET.getUrl());

    @Test
    public void verifyPetCanBeDelete() {
        int petId = 22;
        PetDTO defaultPet = createDefaultPet(petId);

        Response responseForPetCreation = restClient.postEntity(defaultPet);
        Assert.assertEquals(responseForPetCreation.getStatusCode(), 200);

        Response responseDelete = restClient.deleteEntity(petId);
        Assert.assertEquals(responseDelete.getStatusCode(), 200);

        Response petNotFoundResponse = restClient.getEntities(petId);
        Assert.assertEquals(petNotFoundResponse.getStatusCode(), 404);
        ErrorResponse errorResponse = petNotFoundResponse.as(ErrorResponse.class);

        Assert.assertEquals(errorResponse.getCode(), 1);
        Assert.assertEquals(errorResponse.getType(), "error");
        Assert.assertEquals(errorResponse.getMessage(), "Pet not found");
    }
}
