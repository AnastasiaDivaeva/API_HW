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

public class CreatePetTest extends PetTestBase {
    private final RestClient restClient = new RestClient(TestUrls.BASE_SERVER_URL_PET.getUrl());

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

        CategoryDTO category = new CategoryDTO(categoryId, categoryName);
        TagDTO tagDTO = new TagDTO(tagId, tagName);

        List<TagDTO> tags = Collections.singletonList(tagDTO);
        List<String> photoUrls = Arrays.asList(photoUrl, photoUrlSecond);

        PetDTO petToCreate = new PetDTO(petId, category, petName, photoUrls, tags, petStatus);

        Response response = restClient.postEntity(petToCreate);
        PetDTO createdPetResponse = response.as(PetDTO.class);

        Assert.assertEquals(createdPetResponse.getId(), petId);
        Assert.assertEquals(createdPetResponse.getName(), petName);
        Assert.assertEquals(createdPetResponse.getCategory(), category);
        Assert.assertEquals(createdPetResponse.getTags(), tags);
        Assert.assertEquals(createdPetResponse.getPhotoUrls(), photoUrls);
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

        CategoryDTO category = new CategoryDTO(categoryId, categoryName);
        TagDTO tagDTO = new TagDTO(tagId, tagName);

        List<TagDTO> tags = Collections.singletonList(tagDTO);
        List<String> photoUrls = Arrays.asList(photoUrl, photoUrlSecond);

        PetDTO petToCreate = new PetDTO(petId, category, petName, photoUrls, tags, petStatus);

        restClient.postEntity(petToCreate);

        Response previouslyCreatedPetResponse = restClient.getEntities(petId);
        PetDTO previouslyCreatedPet = previouslyCreatedPetResponse.as(PetDTO.class);

        Assert.assertEquals(previouslyCreatedPet.getId(), petId);
        Assert.assertEquals(previouslyCreatedPet.getName(), petName);
        Assert.assertEquals(previouslyCreatedPet.getCategory(), category);
        Assert.assertEquals(previouslyCreatedPet.getTags(), tags);
        Assert.assertEquals(previouslyCreatedPet.getPhotoUrls(), photoUrls);
    }
}
