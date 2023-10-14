package divaeva.hw.api.pet;

import divaeva.hw.api.TestUrls;
import dto.CategoryDTO;
import dto.PetDTO;
import dto.TagDTO;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import rest.client.RestClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ChangePetTest extends PetTestBase {
    private final RestClient restClient = new RestClient(TestUrls.BASE_SERVER_URL_PET.getUrl());

    @Test
    public void verifyPetCanBeUpdate() {
        int petId = 11;
        PetDTO petToCreate = createDefaultPet(petId);

        Response previouslyCreatedPetResponse = restClient.postEntity(petToCreate);
        Assert.assertEquals(previouslyCreatedPetResponse.getStatusCode(), 200);

        int updateCategoryId = 999;
        String updateCategoryName = "cat";

        int updateTagId = 90;
        String updateTagName = "Myrka";

        String updatePetName = "Siamese";
        String updateStatus = "available";
        String updatePhotoUrl = "https://loremflickr.com/320/278";
        String updatePhotoSecond = "https://loremflickr.com/320/279";

        CategoryDTO updateCategoryDTO = new CategoryDTO(updateCategoryId, updateCategoryName);
        TagDTO updateTagsDTO = new TagDTO(updateTagId, updateTagName);

        List<TagDTO> updateTags = Collections.singletonList(updateTagsDTO);
        List<String> updatePhotoUrls = Arrays.asList(updatePhotoUrl, updatePhotoSecond);

        PetDTO updatedPetEntity = new PetDTO(petId, updateCategoryDTO, updatePetName, updatePhotoUrls, updateTags, updateStatus);

        Response updatedPetResponse = restClient.updateEntity(updatedPetEntity);
        PetDTO updatedPet = updatedPetResponse.as(PetDTO.class);

        Assert.assertEquals(updatedPet.getId(), petId);
        Assert.assertEquals(updatedPet.getName(), updatePetName);
        Assert.assertEquals(updatedPet.getCategory(), updateCategoryDTO);
        Assert.assertEquals(updatedPet.getTags(), updateTags);
        Assert.assertEquals(updatedPet.getPhotoUrls(), updatePhotoUrls);
    }
}
