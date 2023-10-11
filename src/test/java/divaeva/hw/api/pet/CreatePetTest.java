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

public class CreatePetTest extends PetTestBase {
    private RestClient<PetDTO> restClient = new RestClient<>(BASE_SERVER_URL_PET);
    @Test
    public void verifyPetCanBeCreate() {
        int categoryId = 11;
        String categoryName = "dog";
        int tagId = 1;
        String tagName = "Bobik";
        int petId = 11;
        String petName = "Labrador";
        String petStatus = "available";

        String photoUrl = "https://loremflickr.com/320/240";
        String photoUrlSecond = "https://loremflickr.com/320/241";

        CategoryDTO category = CategoryDTO.createCategory(categoryId, categoryName);
        TagDTO tagDTO = TagDTO.createTag(tagId, tagName);

        Set<TagDTO> tags = new HashSet<>(Collections.singletonList(tagDTO));
        Set<String> photoUrls = new HashSet<>(Arrays.asList(photoUrl, photoUrlSecond));

        PetDTO petToCreate = PetDTO.createPet(petId, petName, petStatus, tags, photoUrls, category);

        Response response = restClient.postEntity(petToCreate);
        PetDTO createdPetResponse = response.as(PetDTO.class);

        Assert.assertEquals(createdPetResponse.getId(), petId);
        Assert.assertEquals(createdPetResponse.getName(), petName);
        Assert.assertEquals(createdPetResponse.getCategory(), category);
        Assert.assertEqualsDeep(createdPetResponse.getTags(), tags, null);
        Assert.assertEqualsDeep(createdPetResponse.getPhotoUrls(), photoUrls, null);
    }

    @Test
    public void verifyPetIsCreateAndSaveCorrectly() {
        int categoryId = 11;
        String categoryName = "dog";

        int tagId = 1;
        String tagName = "Bobik";

        int petId = 11;
        String petName = "Labrador";
        String petStatus = "available";

        String photoUrl = "https://loremflickr.com/320/240";
        String photoUrlSecond = "https://loremflickr.com/320/241";

        CategoryDTO category = CategoryDTO.createCategory(categoryId, categoryName);
        TagDTO tagDTO = TagDTO.createTag(tagId, tagName);

        Set<TagDTO> tags = new HashSet<>(Collections.singletonList(tagDTO));
        Set<String> photoUrls = new HashSet<>(Arrays.asList(photoUrl, photoUrlSecond));

        PetDTO petToCreate = PetDTO.createPet(petId, petName, petStatus, tags, photoUrls, category);

        restClient.postEntity(petToCreate);

        Response previouslyCreatedPetResponse = restClient.getEntity(petId);
        PetDTO previouslyCreatedPet = previouslyCreatedPetResponse.as(PetDTO.class);

        Assert.assertEquals(previouslyCreatedPet.getId(), petId);
        Assert.assertEquals(previouslyCreatedPet.getName(), petName);
        Assert.assertEquals(previouslyCreatedPet.getCategory(), category);
        Assert.assertEqualsDeep(previouslyCreatedPet.getTags(), tags, null);
        Assert.assertEqualsDeep(previouslyCreatedPet.getPhotoUrls(), photoUrls, null);
    }
}
