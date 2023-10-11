package divaeva.hw.api.pet;

import dto.CategoryDTO;
import dto.PetDTO;
import dto.TagDTO;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PetTestBase {
    protected final String BASE_SERVER_URL_PET = "https://petstore.swagger.io/v2/pet/";

    protected PetDTO createDefaultPet(int petId) {
        int categoryId = 11;
        String categoryName = "dog";
        int tagId = 1;
        String tagName = "Bobik";
        String petName = "Labrador";
        String petStatus = "available";

        String photoUrl = "https://loremflickr.com/320/240";
        String photoUrlSecond = "https://loremflickr.com/320/241";

        CategoryDTO category = CategoryDTO.createCategory(categoryId, categoryName);
        TagDTO tagDTO = TagDTO.createTag(tagId, tagName);

        Set<TagDTO> tags = new HashSet<>(Collections.singletonList(tagDTO));
        Set<String> photoUrls = new HashSet<>(Arrays.asList(photoUrl, photoUrlSecond));

        return PetDTO.createPet(petId, petName, petStatus, tags, photoUrls, category);
    }
}
