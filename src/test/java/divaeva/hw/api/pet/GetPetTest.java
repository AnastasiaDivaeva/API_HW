package divaeva.hw.api.pet;

import dto.CategoryDTO;
import dto.ErrorResponse;
import dto.PetDTO;
import dto.TagDTO;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import rest.client.RestClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GetPetTest extends PetTestBase {
    private RestClient<PetDTO> restClient = new RestClient<>(BASE_SERVER_URL_PET);

    @Test
    public void getPetTest() {
        int petId = 11;
        PetDTO defaultPet = createDefaultPet(petId);
        Response response = restClient.postEntity(defaultPet);

        Response foundPet = restClient.getEntity(petId);
        PetDTO pet = response.as(PetDTO.class);
        Assert.assertEquals(foundPet.getStatusCode(), 200);
        Assert.assertEquals(pet.getId(), petId);
    }

    @Test
    public void getNonExistentPet() {
        int petId = 3;
        restClient.deleteEntity(petId);

        Response response = restClient.getEntity(petId);
        Assert.assertEquals(response.getStatusCode(), 404);
        ErrorResponse errorResponse = response.as(ErrorResponse.class);

        Assert.assertEquals(errorResponse.getCode(), 1);
        Assert.assertEquals(errorResponse.getType(), "error");
        Assert.assertEquals(errorResponse.getMessage(), "Pet not found");
    }
}
