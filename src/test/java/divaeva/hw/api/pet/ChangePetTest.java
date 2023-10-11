package divaeva.hw.api.pet;

import dto.CategoryDTO;
import dto.PetDTO;
import dto.TagDTO;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import rest.client.RestClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ChangePetTest extends PetTestBase {
    private RestClient<PetDTO> restClient = new RestClient<>(BASE_SERVER_URL_PET);

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

        CategoryDTO updateCategoryDTO = CategoryDTO.createCategory(updateCategoryId, updateCategoryName);
        TagDTO updateTagsDTO = TagDTO.createTag(updateTagId, updateTagName);

        Set<TagDTO> updateTags = new HashSet<>(Collections.singletonList(updateTagsDTO));
        Set<String> updatePhotoUrls = new HashSet<>(Arrays.asList(updatePhotoUrl, updatePhotoSecond));

        PetDTO updatedPetEntity = PetDTO.createPet(petId, updatePetName, updateStatus, updateTags, updatePhotoUrls, updateCategoryDTO);

        Response updatedPetResponse = restClient.updateEntity(updatedPetEntity);
        PetDTO updatedPet = updatedPetResponse.as(PetDTO.class);

        Assert.assertEquals(updatedPet.getId(), petId);
        Assert.assertEquals(updatedPet.getName(), updatePetName);
        Assert.assertEquals(updatedPet.getCategory(), updateCategoryDTO);
        Assert.assertEqualsDeep(updatedPet.getTags(), updateTags, null);
        Assert.assertEqualsDeep(updatedPet.getPhotoUrls(), updatePhotoUrls, null);
    }
}
