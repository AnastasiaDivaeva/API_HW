package divaeva.hw.api.pet;

import dto.CategoryDTO;
import dto.PetDTO;
import dto.TagDTO;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PetTestBase {

    protected PetDTO createDefaultPet(int petId) {
        int categoryId = 11;
        String categoryName = "dog";
        int tagId = 1;
        String tagName = "Bobik";
        String petName = "Labrador";
        String petStatus = "available";

        String photoUrl = "https://loremflickr.com/320/240";
        String photoUrlSecond = "https://loremflickr.com/320/241";

        CategoryDTO category = new CategoryDTO(categoryId, categoryName);
        TagDTO tagDTO = new TagDTO(tagId, tagName);

        List<TagDTO> tags = Collections.singletonList(tagDTO);
        List<String> photoUrls = Arrays.asList(photoUrl, photoUrlSecond);

        return new PetDTO(petId, category, petName, photoUrls, tags, petStatus);
    }
}
